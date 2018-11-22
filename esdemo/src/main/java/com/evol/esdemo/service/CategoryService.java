package com.evol.esdemo.service;

import com.evol.esdemo.entity.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 获取类别列表
     * @return
     */
    List<Category> getCategoryList();

    /**
     * 通过类别Id获取类别信息
     * @param categoryId
     * @return
     */
    Category getCategoryById(int categoryId);

    /**
     * 增加类别信息
     * @param category
     * @return
     */
    boolean addCategory(Category category);

    /**
     * 修改类别信息
     * @param category
     * @return
     */
    boolean modifyCategory(Category category);

    /**
     * 根据Id删除类别
     * @param category
     * @return
     */
    boolean deleteCategory(int category);





}
