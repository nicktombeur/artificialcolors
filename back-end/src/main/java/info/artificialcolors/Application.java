package info.artificialcolors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Application {

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/demo")
    @ResponseBody
    String demo() {
        return "This is a demo";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
