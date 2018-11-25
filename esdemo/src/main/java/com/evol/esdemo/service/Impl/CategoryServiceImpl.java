package com.evol.esdemo.service.Impl;

import com.evol.esdemo.dao.CategoryDao;
import com.evol.esdemo.entity.Category;
import com.evol.esdemo.service.CategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Page<Category> queryByPage(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        return categoryDao.queryByPage();
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryDao.queryCategory();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        /*if(1 == 1)
            throw new RuntimeException(this.getClass().getName() + ":故意抛出的异常！！");*/
        return categoryDao.findCategoryById(categoryId);
    }


    //并不是所有的异常都会回滚，默认值接收RuntimeException才回滚;
    // 可以通过rollbackFor 指定类型的异常回滚,如下：
    //@Transactional(rollbackFor = Exception.class
    @Transactional
    @Override
    public boolean addCategory(Category category) {
        if(category == null
                || category.getCategoryName() == null
                || "" == category.getCategoryName().trim()){
            throw new RuntimeException("类别信息不能为空！");
        }
        category.setCreateTime(new Date());
        category.setLastEditTime(new Date());
        try {
            int effectedNum = categoryDao.insertCategory(category);
            if(effectedNum == 0)
                throw new RuntimeException("插入类别信息失败！");
            return true;
        }catch (Exception ex){
            throw  new RuntimeException("插入类别信息失败：" + ex.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean modifyCategory(Category category) {
        if(category == null
                || category.getCategoryName() == null
                || "" == category.getCategoryName().trim()){
            throw new RuntimeException("类别信息不能为空！");
        }
        category.setLastEditTime(new Date());
        try {
            int effectedNum = categoryDao.updateCategory(category);
            if(effectedNum == 0)
                throw new RuntimeException("修改类别信息失败！");
            return true;
        }catch (Exception ex){
            throw  new RuntimeException("修改类别信息失败：" + ex.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteCategory(int categoryId) {
        if(categoryId <= 0)
            throw  new RuntimeException("区域Id不能为空！");
        try {
            int effectedNum = categoryDao.deleteCategory(categoryId);
            if(effectedNum == 0)
                throw new RuntimeException("删除类别信息失败:");
            return true;
        }catch (Exception ex){
            throw new RuntimeException("删除类别信息失败:" + ex.getMessage());
        }
    }
}
