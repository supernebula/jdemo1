package com.essmp.web.manage.controller;

import com.evol.esdemo.entity.Category;
import com.evol.esdemo.service.CategoryService;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/api/category")
public class CategoryApiController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String, Object> listCategory(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Category> list = categoryService.getCategoryList();
        modelMap.put("categoryList", list);
/*        if(1 == 1)
            throw new RuntimeException("故意抛出的异常！！");*/
        return modelMap;
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    private Map<String, Object> getCategory(Integer categoryId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Category item = categoryService.getCategoryById(categoryId);
        modelMap.put("category", item);
        return modelMap;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private Map<String, Object> addCategory(@ModelAttribute("category") Category category){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean isSuccess = categoryService.addCategory(category);
        modelMap.put("success", isSuccess);
        return modelMap;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    private Map<String, Object> modifyCategory(@ModelAttribute("category") Category category){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean isSuccess = categoryService.modifyCategory(category);
        modelMap.put("success", isSuccess);
        return modelMap;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private Map<String, Object> modifyCategory(Integer categoryId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean isSuccess = categoryService.deleteCategory(categoryId);
        modelMap.put("success", isSuccess);
        return modelMap;
    }


}
