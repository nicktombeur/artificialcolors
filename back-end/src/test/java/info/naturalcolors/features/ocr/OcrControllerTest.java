package info.naturalcolors.features.ocr;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OcrControllerTest {

    @Mock
    private OcrService ocrService;

    @Mock
    private MultipartFile multipartFile;

    private OcrController ocrController;

    @BeforeEach
    public void setUp() {
        this.ocrController = new OcrController(ocrService);
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class An_upload_is_valid {
        @Test
        void if_the_file_is_valid() {
            // Given
            when(multipartFile.isEmpty()).thenReturn(false);

            // When
            ocrController.containsArtificialColors(multipartFile);

            // Then
            verify(ocrService, times(1)).containsArtificialColors(multipartFile);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class An_upload_is_invalid {
        @Test
        void if_the_file_is_missing() {
            // Given
            when(multipartFile.isEmpty()).thenReturn(true);

            // When
            assertThatExceptionOfType(EmptyFileException.class)
                    .isThrownBy(() -> ocrController.containsArtificialColors(multipartFile));
        }
    }
}