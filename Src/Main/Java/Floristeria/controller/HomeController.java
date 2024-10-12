package Floristeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// necesario para index
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; 
    }
}
