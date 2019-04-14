package com.cc.sell.repository;

import com.cc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author chencheng
 * @date 2019/4/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void testFindOne(){
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void testSave(){
        ProductCategory productCategory=new ProductCategory("女生最爱",3);
        ProductCategory result = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(result);

    }

    @Test
    public void testFindByCategoryTypeIn(){
        List<Integer> list= Arrays.asList(1,2,3);
        List<ProductCategory> resultList = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,resultList.size());
    }
}