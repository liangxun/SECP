package edu.bupt.secp;

import edu.bupt.secp.model.Meau;
import edu.bupt.secp.model.Restaurant;
import edu.bupt.secp.model.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bupt.secp.model.MeauRepository;

import java.util.List;

public class DisplayController{
    @Autowired
    private MeauRepository meauRepository;
    private RestaurantRepository restaurantRepository;

    @RequestMapping(value="displaymeau", method = RequestMethod.GET)
    public List<Meau> all_meau(){
        return  (List<Meau>)meauRepository.findAll();
    }

    @RequestMapping(value="displayrestaurant", method = RequestMethod.GET)
    public List<Restaurant> all_restaurant(){
        return  (List<Restaurant>) restaurantRepository.findAll();
    }
}
