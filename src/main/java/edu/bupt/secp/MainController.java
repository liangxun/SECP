/*
* 后台管理模块
* 可以显示当前在线人数、在线商家等统计数据
* */
package edu.bupt.secp;

import edu.bupt.secp.model.User;
import edu.bupt.secp.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class MainController {

    @RequestMapping(value = "/homePage")
    public String home(){
        return "homePage";
    }

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="userlist", method = RequestMethod.GET)
    public String users_static(Model model){
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("count", userRepository.count());
        return "userstatic";
    }
}
