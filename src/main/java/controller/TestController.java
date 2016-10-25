package controller;

import entity.request.UsernameAndPassword;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianxing on 16/9/7.
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping(method = RequestMethod.GET, consumes = "application/json")
    public UsernameAndPassword getUsernameAndPassword(){
        return new UsernameAndPassword();
    }

}
