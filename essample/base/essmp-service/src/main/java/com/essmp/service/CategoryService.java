package com.essmp.service;

import com.essmp.entity.Category;
import com.github.pagehelper.Page;

import java.util.List;

public interface CategoryService {

    /**
     *
     * @param pageIndex 页号
     * @param pageSize  每页记录数
     * @return
     */
    Page<Category> queryByPage(int pageIndex, int pageSize);

    /**
     * 获取类别列表
     * @return
     */
    List<Category> getCategoryList();

    /**
     * 通过类别Id获取类别信息
     * @param id
     * @return
     */
    Category getCategoryById(int id);

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
     * @param id
     * @return
     */
    boolean deleteCategory(int id);





}
