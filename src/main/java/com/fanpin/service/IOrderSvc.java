package com.fanpin.service;

import com.fanpin.entity.Order;
import com.fanpin.entity.OrderDetail;

import java.util.List;

public interface IOrderSvc {
    int addOrder(Order order, List<OrderDetail> orderDetails);

    List<Order> getMyOrders(Integer uid, Integer status);

    void deleteOrder(Integer orderid);

    List<Order> getAdminOrders(String ordercode, Integer uid, String status, String startDate, String endDate, String sort);

    int getOrderStatusById(Integer orderid);

    void upOrderStatus(Integer orderid, int status);

    int countOrderStatus(Integer uid, Integer status);

    Order getOrderDetailById(Integer orderid);

    void updateOrderPostInfo(Integer orderid, String orderpostcode, String orderpostname);
}
