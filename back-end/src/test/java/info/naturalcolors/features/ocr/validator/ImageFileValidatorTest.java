package info.naturalcolors.features.ocr.validator;

import info.naturalcolors.NestedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import javax.validation.ConstraintValidatorContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImageFileValidatorTest {

    @Mock
    private ConstraintValidatorContext context;

    @Mock
    private ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder;

    @Mock
    private ValidImage validImage;

    private ImageFileValidator imageFileValidator;

    @BeforeEach
    public void setUp() {
        this.imageFileValidator = new ImageFileValidator();
    }

    @NestedTest
    class Validation_should_pass {
        @ParameterizedTest
        @ValueSource(strings = {"image/jpeg", "image/jpg"})
        void if_the_file_has_an_allowed_content_type(String contentType) {
            // Given
            final var multipartFile = new MockMultipartFile("file", "file", contentType, (byte[]) null);

            // When
            final var valid = imageFileValidator.isValid(multipartFile, context);

            // Then
            assertThat(valid).isTrue();
        }
    }

    @NestedTest
    class Validation_should_fail {
        @Test
        void if_the_file_has_an_invalid_content_type() {
            // Given
            final var multipartFile = new MockMultipartFile("file", "file", "application/json", (byte[]) null);
            imageFileValidator.initialize(validImage);
            when(validImage.message()).thenReturn("");
            when(context.buildConstraintViolationWithTemplate(anyString())).thenReturn(constraintViolationBuilder);

            // When
            final var valid = imageFileValidator.isValid(multipartFile, context);

            // Then
            assertThat(valid).isFalse();
        }
    }

    @NestedTest
    class An_error_should_be_returned {
        @Test
        void if_the_multipart_file_is_missing() {
            assertThatNullPointerException()
                    .isThrownBy(() -> imageFileValidator.isValid(null, context))
                    .withMessage("MultipartFile cannot be null");
        }

        @Test
        void if_the_context_is_missing() {
            // Given
            final var multipartFile = new MockMultipartFile("file", "file", "application/json", (byte[]) null);

            assertThatNullPointerException()
                    .isThrownBy(() -> imageFileValidator.isValid(multipartFile, null))
                    .withMessage("ConstraintValidatorContext cannot be null");
        }
    }

}