package com.tianxing.webapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianxing on 2017/4/15.
 *
 */
@RestController
public class FscController {



    //@RequestMapping(value = "", method = RequestMethod.GET, consumes = "application/json")
    //public void root(){
    //}



    @RequestMapping(value = "v1", consumes = "application/json")
    public void api(){

    }
}
