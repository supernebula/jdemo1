package com.evol.esdemo.dao;

import com.evol.esdemo.dao.mapper.custom.CustomCategoryMapper;
import com.evol.esdemo.entity.Category;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class CustomCategoryMapperTest {

    /**
     * 参考： Project Structure > Project Settings > Facets > Spring > Spring(esdemo)
     * idea设置：Preferences > Editor > Inspections > Spring > Spring Core > Code > Autowiring for Bean Class > Severity:Warning
     */
    @Autowired
    private CustomCategoryMapper customCategoryMapper;

    @Test
    public void queryCategory() {
        List<Category> categoryList = customCategoryMapper.queryCategory();
        assertEquals(4, categoryList.size());
    }

    @Test
    public void findCategoryById() {
        Category category = customCategoryMapper.findCategoryById(1);
        assertEquals("数码", category.getName());
    }

    @Test
    public void insertCategory() {
        Category category = new Category();
        category.setName("饰品");
        category.setPriority(1);
        int effectedNum = customCategoryMapper.insertCategory(category);
        assertEquals(1, effectedNum);
    }

    @Test
    public void updateCategory() {
        Category category = new Category();
        category.setName("图书");
        category.setId(3);
        category.setLastEditTime(new Date());
        int effectedNum = customCategoryMapper.updateCategory(category);
        assertEquals(1, effectedNum);
    }

    @Test
    public void deleteCategory() {
        int effectedNum = customCategoryMapper.deleteCategory(3);
        assertEquals(1, effectedNum);
    }
}