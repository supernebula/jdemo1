package com.essg.web.manage.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * CURD example
 * https://blog.csdn.net/weixin_39478044/article/details/80291809
 */
@Controller
public class UserController {

    @RequestMapping({"/login"})
    public String login(){
        return "user/login";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String create(ModelMap map){

        return "user/create";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String createPost(ModelMap map){

        return "user/create";
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.GET)
    public String update(ModelMap map){

        return "user/create";
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updatePost(ModelMap map){

        return "user/create";
    }



}
