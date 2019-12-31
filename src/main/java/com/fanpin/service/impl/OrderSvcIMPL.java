package com.fanpin.service.impl;

import com.fanpin.dao.IOrderDao;
import com.fanpin.entity.Order;
import com.fanpin.entity.OrderDetail;
import com.fanpin.service.IOrderSvc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: MR·Wang
 * Date: 2019/10/25
 * Time: 下午 1:54
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrderSvcIMPL implements IOrderSvc {

    @Resource
    private IOrderDao orderDao;

    @Override
    public int addOrder(Order order, List<OrderDetail> orderDetails) {
        /* 生成订单号：当前时间+100以内随机数 */
        Date d=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.CHINA);
        String str=sf.format(d);
        Random r=new Random();
        int i=r.nextInt(100);
        String s="";
        if(i<10){
            s="00"+i;
        }
        else if(i>=10&&i<=99){
            s="0"+i;
        }
        String orderCode=str+s;
        order.setOrdercode(orderCode);
        /*调用 Dao 为订单表添加数据 */
        orderDao.addOrder(order);

        int orderid=order.getOrderid();
        System.out.println("---------"+order.getOrderid());

        for(int j=0;j<orderDetails.size();j++){
            OrderDetail od=orderDetails.get(j);
            od.setOrderid(orderid);
            orderDao.addOrderDetail(od);
        }
        return orderid;
    }

    @Override
    public List<Order> getMyOrders(Integer uid,Integer status) {
        return orderDao.getMyOrders(uid,status);
    }

    @Override
    public void deleteOrder(Integer orderid) {
        orderDao.deleteOrder(orderid);
    }

    @Override
    public List<Order> getAdminOrders(String ordercode, Integer uid, String status, String startDate,String endDate, String sort) {
        Order order=new Order();
        order.setUid(uid);
        Map<String,Object> m=new HashMap<String,Object>();
        m.put("orderCode", ordercode);
        m.put("uid", uid);
        m.put("status", status);
        m.put("startDate", startDate);
        m.put("endDate", endDate);
        m.put("sort", sort);
        order.setParams(m);
        System.out.println("---------orderCode:"+order.getParams().get("status"));
        return orderDao.getOrders(order);
    }

    @Override
    public int getOrderStatusById(Integer orderid) {
        return orderDao.getOrderStatusById(orderid);
    }

    @Override
    public void upOrderStatus(Integer orderid, int status) {
        orderDao.upOrderStatus(orderid, status);
    }

    @Override
    public int countOrderStatus(Integer uid, Integer status) {
        return orderDao.countOrderStatus(uid, status);
    }

    @Override
    public Order getOrderDetailById(Integer orderid) {
        return orderDao.getOrderDetailById(orderid);
    }

    @Override
    public void updateOrderPostInfo(Integer orderid, String orderpostcode, String orderpostname) {
        orderDao.updateOrderPostInfo(orderid, orderpostcode, orderpostname);
    }
}
