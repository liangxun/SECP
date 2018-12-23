package edu.bupt.secp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bupt.secp.model.User;
import edu.bupt.secp.model.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="register")
    public @ResponseBody String addNewUser(@RequestParam String name,
                                           @RequestParam String password,
                                           @RequestParam String phone){
        User n = new User();
        n.setName(name);
        n.setPassword(password);
        n.setPhone(phone);
        n.setAccout(10000);
        userRepository.save(n);
        return "saved";
    }

    @RequestMapping(value="list", method = RequestMethod.GET)
    public List<User> all_users(@RequestParam Integer n){
        //return  (List<User>) userRepository.findAll();
        return userRepository.findTopN(n);
    }
}
