package com.cc.sell.exception;

import com.cc.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @author chencheng
 * @date 2019/12/19
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
