package info.naturalcolors.features.ocr;

import info.naturalcolors.features.shared.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class OcrExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(OcrExceptionHandler.class);

    @ExceptionHandler(MultipartException.class)
    ResponseEntity<Response> handleMultipartException() {
        return new ResponseEntity<>(new Response("", "Invalid file."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyFileException.class)
    ResponseEntity<Response> handleEmptyFileException() {
        return new ResponseEntity<>(new Response("", "Invalid file."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<Response> handleConstraintViolationException(final ConstraintViolationException exception) {
        final var message = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(";"));
        return new ResponseEntity<>(new Response("", message), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    ResponseEntity<Response> handleNullPointerException(final NullPointerException exception) {
        LOGGER.error("NullPointerException", exception);
        return new ResponseEntity<>(new Response("", "Something went wrong"), HttpStatus.BAD_REQUEST);
    }
}
