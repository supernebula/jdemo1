package com.essg.web.manage.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;

@RestController
@RequestMapping(value="/api/user")
public class UserApiController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String username, String password) throws Exception {
        //
        if(NULL)
        throw new Exception("未实现的方法");
        return "";
    }
}
