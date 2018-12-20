package com.essg.dao.mapper.custom;

import com.essg.entity.Category;
import com.github.pagehelper.Page;

import java.util.List;


/**
 *
 */
public interface CustomCategoryMapper {

    Page<Category> queryByPage();

    /**
     * 列出类别列表
     * @return categoryList
     */
    List<Category> queryCategory();

    /**
     *根据Id获取具体类别
     * @param categoryId
     * @return category
     */
    Category findCategoryById(int categoryId);

    /**
     * 插入类别信息
     * @param category
     * @return
     */
    int insertCategory(Category category);

    /**
     * 更新类别信息
     * @param category
     * @return
     */
    int updateCategory(Category category);

    /**
     * 根据Id删除具体类别
     * @param id
     * @return
     */
    int deleteCategory(int id);

}
