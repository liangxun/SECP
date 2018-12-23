package edu.bupt.secp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        String ret = "hello springboot and java";
        return ret;
    }
}
