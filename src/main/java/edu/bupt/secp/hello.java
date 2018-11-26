package edu.bupt.secp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//@RestController注解下将返回json格式的数据，比如hello方法的return就直接返回"hello springboot and java"到浏览器
@RestController
public class hello {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello springboot and java";
    }
}
