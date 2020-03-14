package info.naturalcolors.features.ocr;

import info.naturalcolors.Integration;
import info.naturalcolors.NestedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OcrController.class)
@Integration
class OcrControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OcrService ocrService;

    @NestedTest
    class An_error_should_be_returned {

        @Test
        void if_the_multipart_file_is_empty() throws Exception {
            // Given
            final var file = new MockMultipartFile("file", "file", "image/jpeg", (byte[]) null);

            mockMvc.perform(multipart("/ocr").file(file))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.code", is("")))
                    .andExpect(jsonPath("$.message", is("Invalid file.")));
        }

        @Test
        void if_the_file_is_of_an_invalid_type() throws Exception {
            // Given
            final var resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("invalid.txt");
            final var file = new MockMultipartFile("file", "invalid.txt", "text/plain", resourceAsStream);

            mockMvc.perform(multipart("/ocr").file(file))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.code", is("")))
                    .andExpect(jsonPath("$.message", is("Only JPEG images are allowed")));
        }
    }

    @NestedTest
    class A_response_should_be_send {

        @Test
        void if_the_file_is_valid() throws Exception {
            // Given
            final var resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("valid_image.jpg");
            final var file = new MockMultipartFile("file", "valid_image.jpg", "image/jpeg", resourceAsStream);

            mockMvc.perform(multipart("/ocr").file(file))
                    .andExpect(status().isOk());
        }
    }

}
