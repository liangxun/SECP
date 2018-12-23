package edu.bupt.secp;

import edu.bupt.secp.model.Meau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.bupt.secp.model.MeauRepository;

import java.util.List;

@RestController
@RequestMapping("/meau")
public class MeauController {
    @Autowired
    private MeauRepository meauRepository;

    @RequestMapping(value="add")
    public @ResponseBody String addNewMeau(@RequestParam Integer restaurant_id,
                                           @RequestParam String name,
                                           @RequestParam Float price,
                                           @RequestParam String brief,
                                           @RequestParam String image_addr){
        Meau n = new Meau();
        n.setName(name);
        n.setRestaurant_id(restaurant_id);
        n.setPrice(price);
        n.setBrief(brief);
        n.setImage_addr(image_addr);
        meauRepository.save(n);
        return "saved";
    }

    @RequestMapping(value="list", method = RequestMethod.GET)
    public List<Meau> all_meau(){
        return  (List<Meau>)meauRepository.findAll();
    }
}
