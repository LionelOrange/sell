package com.cc.sell.dataobject;

import com.cc.sell.MyClassLoader;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author chencheng
 * @date 2019/4/14
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 状态,0正常1下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader=new MyClassLoader("/Users/chencheng/","MyClassLoader");
        Class<?> loadClass = myClassLoader.loadClass("Test");
        System.out.println(loadClass.getClassLoader());
        loadClass.newInstance();
    }
}
