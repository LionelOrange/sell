package com.cc.sell.VO;

import lombok.Data;

/**
 * @author chencheng
 * @date 2019/4/14
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
