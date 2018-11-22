package com.evol.esdemo.web.admin;

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
@RequestMapping("admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

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
    private String addCategory(){
        return "category/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private String addCategory(Category category){
        categoryService.addCategory(category);
        return "category/create";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    private String modifyCategory(ModelMap map, Integer categoryId){
        Category item = categoryService.getCategoryById(categoryId);
        map.put("category", item);
        return "category/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    private String modifyCategory(Category category, Integer categoryId){
        Category item = categoryService.getCategoryById(categoryId);
        item.setCategoryName(category.getCategoryName());
        item.setPriority(category.getPriority());
        categoryService.modifyCategory(item);
        return "category/edit";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private String deleteCategory(Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return "category/list";
    }
}
