package edu.bupt.secp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @RequestMapping(value = "/homePage")
    public String home(){
        return "homePage";
    }

}
