package edu.bupt.secp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


// @Controller注解下将返回HTML，比如在home方法中的return就默认是去template文件夹下面找homePage.html
@Controller
public class MainController {

    @RequestMapping(value = "/homePage")
    public String home(){
        return "homePage";
    }

}
