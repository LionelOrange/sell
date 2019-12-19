package com.cc.sell.controller;

import com.cc.sell.VO.ProductInfoVO;
import com.cc.sell.VO.ProductVO;
import com.cc.sell.VO.ResultVO;
import com.cc.sell.dataobject.ProductCategory;
import com.cc.sell.dataobject.ProductInfo;
import com.cc.sell.service.CategoryService;
import com.cc.sell.service.ProductService;
import com.cc.sell.utils.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chencheng
 * @date 2019/4/14
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        List<ProductInfo> productInfoList = productService.findUpAll();

        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    productInfoVO.setProductId(productInfo.getProductId());
                    productInfoVO.setProductName(productInfo.getProductName());
                    productInfoVO.setProductDescription(productInfo.getProductDescription());
                    productInfoVO.setProductPrice(productInfo.getProductPrice());
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtils.success(productVOList);
    }
}
