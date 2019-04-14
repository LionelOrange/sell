package com.cc.sell.service.impl;

import com.cc.sell.dataobject.ProductCategory;
import com.cc.sell.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chencheng
 * @date 2019/4/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());

    }

    @Test
    public void findAll() {
        List<ProductCategory> categoryList = categoryService.findAll();
        Assert.assertNotEquals(0,categoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list= Arrays.asList(1,2,3,4);
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void saveProductCategory() {
        ProductCategory productCategory=new ProductCategory("玩具",7);
        ProductCategory productCategory1 = categoryService.saveProductCategory(productCategory);
        Assert.assertNotNull(productCategory1);
    }
}