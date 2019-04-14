package com.cc.sell.service;

import com.cc.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author chencheng
 * @date 2019/4/14
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory saveProductCategory(ProductCategory productCategory);
}
