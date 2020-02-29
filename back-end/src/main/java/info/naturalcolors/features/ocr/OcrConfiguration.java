package info.naturalcolors.features.ocr;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OcrConfiguration {

    @Bean
    public Tesseract tesseract(@Value("${tessdata.prefix}") final String tessdata) {
        final var tesseract = new Tesseract();
        tesseract.setDatapath(tessdata);
        return tesseract;
    }
}
