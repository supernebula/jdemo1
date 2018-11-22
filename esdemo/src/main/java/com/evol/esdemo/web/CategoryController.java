package com.evol.esdemo.web;

import com.evol.esdemo.entity.Category;
import com.evol.esdemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/listcategory", method = RequestMethod.GET)
    private String listCategory(ModelMap map){
        List<Category> list = categoryService.getCategoryList();
        map.put("categoryList", list);
        map.addAttribute("host", "http://www.baidu.com");
/*        if(1 == 1)
            throw new RuntimeException("故意抛出的异常！！");*/
        return "thymeleaf/listcategory";
    }

    @RequestMapping(value = "/getcategorybyid", method = RequestMethod.GET)
    private String getCategory(ModelMap map, Integer categoryId){
        Category item = categoryService.getCategoryById(categoryId);
        map.put("category", item);
        return "thymeleaf/categoryDetail";
    }
}
