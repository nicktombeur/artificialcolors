package info.naturalcolors.features.ocr;

import info.naturalcolors.features.ocr.validator.ValidImage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Validated
@RequestMapping("/ocr")
public class OcrController {

    private final OcrService ocrService;

    public OcrController(final OcrService ocrService) {
        this.ocrService = ocrService;
    }

    @PostMapping
    public void containsArtificialColors(
            @ValidImage(message = "Only JPEG images are allowed")
            @RequestParam("file") final MultipartFile uploadedFile) {
        if (uploadedFile.isEmpty()) throw new EmptyFileException();

        ocrService.containsArtificialColors(uploadedFile);
    }
}
