package br.com.fiap.fivetechcolletive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class FivetechcolletiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(FivetechcolletiveApplication.class, args);
    }

    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "WebApp 5TECH COLLETIVE";
    }
}
