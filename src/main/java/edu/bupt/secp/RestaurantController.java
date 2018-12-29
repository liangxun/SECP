package edu.bupt.secp;

import edu.bupt.secp.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;

import edu.bupt.secp.model.RestaurantRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.io.File;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @RequestMapping(value="add")
    public @ResponseBody String addNewRestaurant(@RequestParam String name,
                                                 @RequestParam String password,
                                                 @RequestParam String phone,
                                                 @RequestParam MultipartFile image){
        Restaurant n = new Restaurant();
        n.setName(name);
        n.setPassword(password);
        n.setPhone(phone);
        n.setAccout(1000);

        // 处理上传图片
        String fileName = image.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String image_addr = name + suffix;
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";
        File dest = new File(path+image_addr);
        try{
            image.transferTo(dest);
        }catch (IOException e){
            e.printStackTrace();
        }

        n.setImage_addr(image_addr);
        restaurantRepository.save(n);

        Integer id = restaurantRepository.findIdbyName(name);

        return String.format("注册成功，请前往  <a href=\"/meau/addmeau?restaurant_id=%d\">添加菜品</a>", id);
    }

    @RequestMapping(value="list", method = RequestMethod.GET)
    public @ResponseBody List<Restaurant> all_restaurant(){
        return  (List<Restaurant>) restaurantRepository.findAll();
    }

    @RequestMapping(value="register", method = RequestMethod.GET)
    public String register(){
        return "restaurantRegester";
    }
}