package edu.bupt.secp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.bupt.secp.model.User;
import edu.bupt.secp.model.UserRepository;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/homePage")
    public String home(){
        return "homePage";
    }

    @RequestMapping(value="/adduser")
    public @ResponseBody String addNewUser(@RequestParam String name,
                                           @RequestParam String password,
                                           @RequestParam String phone){
        User n = new User();
        n.setName(name);
        n.setPassword(password);
        n.setPhone(phone);
        userRepository.save(n);
        return "saved";
    }
}
