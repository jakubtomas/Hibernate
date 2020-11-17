package sk.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class DefaultController {

    @RequestMapping
    public String printDefault(Model model) {
        model.addAttribute("message", "Hello World");
        return "default";
    }
}
