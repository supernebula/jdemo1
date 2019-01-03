package com.essg.web.manage.controller;

import com.essg.entity.User;
import com.essg.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * CURD example
 * https://blog.csdn.net/weixin_39478044/article/details/80291809
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

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
    @GetMapping(value = "/user/index")
    //等价于 @RequestMapping(value = "/user/index", method = RequestMethod.GET)
    public String index(Model model, @RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize){

        if(pageIndex == null)
            pageIndex = 1;
        if(pageSize == null)
            pageSize = 10;
        Page<User> page =  userService.queryByPage(pageIndex, pageSize);
        PageInfo<User> paged = new PageInfo<>(page);
        model.addAttribute("userPaged",paged);
        return "user/index";
    }


    /**
     * 查询指定数量的记录
     * @param number
     * @return
     */
    @RequestMapping(value = "/user/list/{number}", method = RequestMethod.GET)
    public String list(Model model, @PathVariable("number") Integer number){
        List<User> list = userService.getUserList();
        model.addAttribute("userList", list);
        return "user/index";
    }



    /**
     * 创建视图
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("user", new User());
        return "user/create";
    }

    /**
     * 提交创建
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String createPost(Model model){

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
