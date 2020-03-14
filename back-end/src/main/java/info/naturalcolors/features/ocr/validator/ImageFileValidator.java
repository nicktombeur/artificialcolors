package info.naturalcolors.features.ocr.validator;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Objects;

public class ImageFileValidator implements ConstraintValidator<ValidImage, MultipartFile> {

   private static final List<String> ALLOWED_CONTENT_TYPES = List.of(
           "image/jpeg",
           "image/jpg"
   );

   private ValidImage constraint;

   public void initialize(ValidImage constraint) {
      this.constraint = constraint;
   }

   public boolean isValid(final MultipartFile file, final ConstraintValidatorContext context) {
      Objects.requireNonNull(file, "MultipartFile cannot be null");
      Objects.requireNonNull(context, "ConstraintValidatorContext cannot be null");

      if (!isSupported(file.getContentType())) {
         addMessage(context);
         return false;
      }
      return true;
   }

   private boolean isSupported(final String contentType) {
      return ALLOWED_CONTENT_TYPES.contains(contentType);
   }

   private void addMessage(final ConstraintValidatorContext context) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(constraint.message())
              .addConstraintViolation();
   }
}
