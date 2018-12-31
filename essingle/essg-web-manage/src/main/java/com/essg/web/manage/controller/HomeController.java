package com.essg.web.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping({"home", "/"})
public class HomeController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "Hello Home";
    }

    @RequestMapping({"/index", "/"})
    public String index(){
        return "home/index";
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
