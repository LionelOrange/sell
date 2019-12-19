package com.cc.sell.service;

import com.cc.sell.dto.OrderDTO;

/**
 * @author chencheng
 * @date 2019/12/19
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
