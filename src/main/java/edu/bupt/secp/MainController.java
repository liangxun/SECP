/*
* 后台管理模块
* 可以显示当前在线人数、在线商家等统计数据
* */
package edu.bupt.secp;

import edu.bupt.secp.model.RestaurantRepository;
import edu.bupt.secp.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
        return "userStatic";
    }

    @Autowired
    private RestaurantRepository restaurantRepository;
    @RequestMapping(value = "restaurantList", method = RequestMethod.GET)
    public String restaurant_static(Model model){
        model.addAttribute("restaurants", restaurantRepository.findAll());
        model.addAttribute("count", restaurantRepository.count());
        return "restaurantStatic";
    }
}
