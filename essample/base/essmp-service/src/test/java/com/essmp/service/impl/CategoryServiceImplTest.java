package com.essmp.service.impl;

import com.essmp.entity.Category;
import com.essmp.service.CategoryService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void getCategoryList() {
        List<Category> list = categoryService.getCategoryList();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void getCategoryById() {
        int id = 1;
        categoryService.getCategoryById(id);
    }

    @Test
    public void addCategory() {
        Category item = new Category();
        item.setName("办公用品");
        item.setPriority(4);
        item.setCreateTime(new Date());
        boolean isSuccess = categoryService.addCategory(item);
        Assert.assertTrue("插入类别成功！", isSuccess);
    }

    @Test
    public void modifyCategory() {
        Category item = new Category();
        item.setId(7);
        item.setName("办公用品2");
        item.setPriority(4);
        item.setLastEditTime(new Date());
        boolean isSuccess = categoryService.modifyCategory(item);
        Assert.assertTrue("修改类别成功！", isSuccess);
    }

    @Test
    public void deleteCategory() {
        boolean deleteSuccess = categoryService.deleteCategory(6);
        Assert.assertTrue(deleteSuccess);
    }
}