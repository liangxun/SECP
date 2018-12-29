package edu.bupt.secp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bupt.secp.model.User;
import edu.bupt.secp.model.UserRepository;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="register")
    public List<String> addNewUser(@RequestParam String name,
                                           @RequestParam String password,
                                           @RequestParam String phone){
        User n = new User();
        n.setName(name);
        n.setPassword(password);
        if (phone == "") {
            n.setPhone("18811376899");
        }else{
            n.setPhone(phone);
        }
        n.setAccout(10000);
        userRepository.save(n);
        List<String> ret= new ArrayList<>();
        ret.add("saved");
        return ret;
    }

    @RequestMapping(value="list", method = RequestMethod.GET)
    public List<User> all_users(@RequestParam Integer n){
        //return  (List<User>) userRepository.findAll();
        return userRepository.findTopN(n);
    }
}
