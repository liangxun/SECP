package edu.bupt.secp;

import edu.bupt.secp.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bupt.secp.model.RestaurantRepository;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @RequestMapping(value="add")
    public @ResponseBody String addNewRestaurant(@RequestParam String name,
                                                 @RequestParam String password,
                                                 @RequestParam String phone){
        Restaurant n = new Restaurant();
        n.setName(name);
        n.setPassword(password);
        n.setPhone(phone);
        restaurantRepository.save(n);
        return "saved";
    }

    @RequestMapping(value="list", method = RequestMethod.GET)
    public List<Restaurant> all_restaurant(){
        return  (List<Restaurant>) restaurantRepository.findAll();
    }
}
