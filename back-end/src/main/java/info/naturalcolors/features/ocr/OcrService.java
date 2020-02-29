package info.naturalcolors.features.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OcrService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OcrService.class);

    private final Tesseract tesseract;

    public OcrService(final Tesseract tesseract) {
        this.tesseract = tesseract;
    }

    public void validate(final File file) {
        try {
            final var result = tesseract.doOCR(file);
            LOGGER.info(result);
        } catch (TesseractException e) {
            // TODO error handling
        }
    }
}
