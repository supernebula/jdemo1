package com.essg.web.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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


    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/user/index", method = RequestMethod.GET)
    public String index(@RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize){

        return "user/index";
    }


    /**
     * 查询指定数量的记录
     * @param number
     * @return
     */
    @RequestMapping(value = "/user/list/{number}", method = RequestMethod.GET)
    public String list(@PathVariable("number") Integer number){

        return "user/index";
    }



    /**
     * 创建视图
     * @param map
     * @return
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String create(ModelMap map){

        return "user/create";
    }

    /**
     * 提交创建
     * @param map
     * @return
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String createPost(ModelMap map){

        return "user/create";
    }

    /**
     *编辑视图
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){

        return "user/create";
    }

    /**
     * 提交编辑
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
    public String editPost(@PathVariable Integer id, Model model){

        return "user/create";
    }


    /**
     *提交删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){

        return "user/create";
    }

}
