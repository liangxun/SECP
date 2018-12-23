package edu.bupt.secp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping(value = "/homePage")
    public String home(){
        return "homePage";
    }
}
