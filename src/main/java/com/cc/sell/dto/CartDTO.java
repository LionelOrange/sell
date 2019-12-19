package com.cc.sell.dto;

import lombok.Data;

/**
 * @author chencheng
 * @date 2019/12/19
 */
@Data
public class CartDTO {

    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
