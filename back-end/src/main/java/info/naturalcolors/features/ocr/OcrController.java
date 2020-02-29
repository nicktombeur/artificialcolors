package info.naturalcolors.features.ocr;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/ocr")
public class OcrController {

    private final OcrService ocrService;

    public OcrController(final OcrService ocrService) {
        this.ocrService = ocrService;
    }

    @PostMapping
    public void validate(@RequestParam("file") final MultipartFile uploadedFile) {
        // TODO safe to use fileName ? or use random value?
        final var file = new File(System.getProperty("java.io.tmpdir") + "/" + uploadedFile.getOriginalFilename());
        try {
            uploadedFile.transferTo(file);
            ocrService.validate(file);
        } catch (IOException e) {
            // TODO error handling
        }
    }
}
