package com.essg.web.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneController {

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public String hello(){
        return "Hello One";
    }
}
