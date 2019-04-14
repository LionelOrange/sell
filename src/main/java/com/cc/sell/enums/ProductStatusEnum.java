package com.cc.sell.enums;

import lombok.Getter;

/**
 * @author chencheng
 * @date 2019/4/14
 */
@Getter
public enum ProductStatusEnum {
    //商品状态
    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
