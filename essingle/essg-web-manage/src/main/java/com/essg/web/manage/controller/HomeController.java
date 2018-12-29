package com.essg.web.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/")
    @ResponseBody
    public String index(){
        return "Hello Home";
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    @ResponseBody
    public String one(){
        return "Hello One";
    }

    @RequestMapping(value = "/tow", method = RequestMethod.GET)
    @ResponseBody
    public String tow() throws Exception{
        if(true)
            throw new Exception("test exception");
        return "tow";
    }
}
