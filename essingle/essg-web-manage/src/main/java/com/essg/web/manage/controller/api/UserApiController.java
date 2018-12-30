package com.essg.web.manage.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.essg.common.util.*;

import javax.print.DocFlavor;

@RestController
@RequestMapping(value="/api/user")
public class UserApiController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String username, String password) throws Exception {
        //
        if(StringUtil.isNullOrEmpty(username) || StringUtil.isNullOrEmpty(password))
            throw new Exception("未实现的方法");
        return "";
    }
}
