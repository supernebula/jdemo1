package com.essg.web.manage.controller;

import com.essg.common.part.PageResult;
import com.essg.service.CategoryService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.essg.entity.Category;
import com.essg.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/index")
    private String pagedCategory(ModelMap map, Integer page, Integer pageSize){
        if(page == null || page < 1) page = 1;
        if(pageSize == null || pageSize < 10) pageSize = 10;

        Page<Category> items = categoryService.queryByPage(page, pageSize);
        // 需要把Page包装成PageResult对象才能序列化。该插件也默认实现了一个PageResult
        PageResult<Category> pageResult = new PageResult<>(items);
        map.put("pageResult", pageResult);
/*        if(1 == 1)
            throw new RuntimeException("故意抛出的异常！！");*/
        map.addAttribute("host", "http://www.baidu.com");
        map.put("currentPage", page);
        return "category/index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String listCategory(ModelMap map){
        List<Category> list = categoryService.getCategoryList();
        map.put("categoryList", list);
        map.addAttribute("host", "http://www.baidu.com");
/*        if(1 == 1)
            throw new RuntimeException("故意抛出的异常！！");*/
        return "category/list";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    private String getCategory(ModelMap map, Integer categoryId){
        Category item = categoryService.getCategoryById(categoryId);
        map.put("category", item);
        return "category/detail";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    private String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private String addCategory(Category category){
        categoryService.addCategory(category);
        return "redirect:index";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    private String modifyCategory(Model model, Integer categoryId){
        Category item = categoryService.getCategoryById(categoryId);
        model.addAttribute("category", item);
        return "category/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    private String modifyCategory(Category category, Integer categoryId){
        Category item = categoryService.getCategoryById(categoryId);
        item.setName(category.getName());
        item.setPriority(category.getPriority());
        categoryService.modifyCategory(item);
        return "redirect:index";
    }

    @GetMapping(value = "/delete")
    private String deleteCategory(Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return "redirect:index";
    }
}

