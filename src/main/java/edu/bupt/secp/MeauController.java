package edu.bupt.secp;

import edu.bupt.secp.model.Meau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;

import edu.bupt.secp.model.MeauRepository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/meau")
public class MeauController {
    @Autowired
    private MeauRepository meauRepository;

    @RequestMapping(value="add")
    public @ResponseBody String addNewMeau(@RequestParam Integer restaurant_id,
                                           @RequestParam String name,
                                           @RequestParam Float price,
                                           @RequestParam String brief,
                                           @RequestParam MultipartFile image){
        Meau n = new Meau();
        n.setName(name);
        n.setRestaurant_id(restaurant_id);
        n.setPrice(price);
        n.setBrief(brief);

        // 处理上传图片
        String fileName = image.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String image_addr = name + suffix;
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + String.format("static/meau/%d_", restaurant_id);

        File dest = new File(path+image_addr);
        try{
            image.transferTo(dest);
        }catch (IOException e){
            e.printStackTrace();
        }

        n.setImage_addr(image_addr);
        meauRepository.save(n);

        return String.format("添加菜品成功，请继续 <a href=\"/meau/addmeau?restaurant_id=%d\">添加菜品</a>", restaurant_id);
    }

    @RequestMapping(value="list", method = RequestMethod.GET)
    public @ResponseBody List<Meau> all_meau(){
        return  (List<Meau>)meauRepository.findAll();
    }

    @RequestMapping(value="addmeau", method = RequestMethod.GET)
    public String register(@RequestParam Integer restaurant_id){
        return "addMeau";
    }
}
