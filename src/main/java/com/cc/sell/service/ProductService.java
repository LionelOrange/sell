package com.cc.sell.service;

import com.cc.sell.dataobject.ProductInfo;
import com.cc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author chencheng
 * @date 2019/4/14
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有上架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 上架
     * @param productId
     * @return
     */
    ProductInfo onSale(String productId);

    /**
     * 下架
     * @param productId
     * @return
     */
    ProductInfo offSale(String productId);
}
