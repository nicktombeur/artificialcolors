package info.naturalcolors;

import net.sourceforge.tess4j.Tesseract;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ApplicationTests {

    @MockBean
    private Tesseract tesseract;

    @Test
    public void contextLoads() {
    }

}
