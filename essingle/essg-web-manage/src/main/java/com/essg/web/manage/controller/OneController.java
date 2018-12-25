package com.essg.web.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneController {

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public String one(){
        return "Hello One";
    }

    @RequestMapping(value = "/tow", method = RequestMethod.GET)
    public String tow() throws Exception{
        if(true)
            throw new Exception("test exception");
        return "tow";
    }
}
