package info.naturalcolors.features.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class OcrService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OcrService.class);
    private static final String FILE_PREFIX = System.getProperty("java.io.tmpdir");

    private final Tesseract tesseract;

    public OcrService(final Tesseract tesseract) {
        this.tesseract = tesseract;
    }

    public void containsArtificialColors(final MultipartFile uploadedFile) {
        try {
            final var file = new File(FILE_PREFIX + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
            final var result = tesseract.doOCR(file);
            LOGGER.info(result);
        } catch (TesseractException | IOException e) {
            // TODO error handling
        }
    }
}
