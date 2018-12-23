package edu.bupt.secp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bupt.secp.model.Meau;
import edu.bupt.secp.model.Restaurant;
import edu.bupt.secp.model.RestaurantRepository;
import edu.bupt.secp.model.MeauRepository;


@RestController
@RequestMapping(value="/display")
public class DisplayController{
    @Autowired
    private MeauRepository meauRepository;
    
    @RequestMapping(value="displaymeau", method = RequestMethod.GET)
    public List<Meau> all_meau(@RequestParam Integer restaurant_id){
        return meauRepository.findMeausByRestaurant_id(restaurant_id);
    }

    @Autowired
    private RestaurantRepository restaurantRepository;
    @RequestMapping(value="displayrestaurant", method = RequestMethod.GET)
    public List<Restaurant> all_restaurant(){
        return  (List<Restaurant>) restaurantRepository.findAll();
    }
}
