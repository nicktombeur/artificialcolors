package info.artificialcolors.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class ArtificialColorsApplication {

    @RequestMapping("/test")
    @ResponseBody
    String test() {
        return "This a test for Heroku!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ArtificialColorsApplication.class, args);
    }

}
