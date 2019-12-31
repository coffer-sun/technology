package com.fanpin.controller;

import com.fanpin.entity.Order;
import com.fanpin.service.ILoginSvc;
import com.fanpin.service.IOrderSvc;
import com.fanpin.service.IProductSvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: MR·Wang
 * Date: 2019/10/25
 * Time: 上午 11:48
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/adminorder")
public class AdminOrderController {

    @Resource
    private IOrderSvc orderSvc;

    @Resource
    private IProductSvc productSvc;

    @Resource
    private ILoginSvc loginSvc;

    @RequestMapping("/getAdminOrders")
    public ModelAndView getAdminOrders(
            @RequestParam(required = false) String orderCode,
            @RequestParam(required = false) Integer uid,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String sort) {
        ModelAndView view = new ModelAndView();
        List<Order> list = orderSvc.getAdminOrders(orderCode, uid, status, startDate, endDate, sort);
        System.out.println("订单数量：" + list.size());
        view.addObject("orders", list);
        Object[] arrarInfo = {orderCode, uid, status, startDate, endDate, sort};
        view.addObject("arrarInfo", arrarInfo);
        view.setViewName("backstage/order_manage");
        return view;
    }

    @ResponseBody
    @RequestMapping("/handleOrderStatus")
    public Map<String,String> handleOrderStatus(
            @RequestParam Integer orderid,
            @RequestParam Integer status,
            @RequestParam(required=false) String orderpostname,
            @RequestParam(required=false) String orderpostcode){
        Map<String,String> m=new HashMap<String,String>();
        System.out.println(orderid+"-------"+status);
        try{
            int curStatus = orderSvc.getOrderStatusById(orderid);
            switch(status){
                case 3://同意退款
                    if(curStatus==2){
                        orderSvc.upOrderStatus(orderid,status);
                        m.put("handle", "success");
                    }else{
                        m.put("handle", "failure");
                    }
                    break;
                case 7://同意退货
                    if(curStatus==6){
                        orderSvc.upOrderStatus(orderid,status);
                        m.put("handle", "success");
                    }else{
                        m.put("handle", "failure");
                    }
                    break;
                case 8://确认收到退货
                    if(curStatus==7){
                        orderSvc.upOrderStatus(orderid,status);
                        m.put("handle", "success");
                    }else{
                        m.put("handle", "failure");
                    }
                    break;
                case 9://取消订单
                    if(curStatus==0){
                        orderSvc.upOrderStatus(orderid,status);
                        m.put("handle", "success");
                    }else{
                        m.put("handle", "failure");
                    }
                    break;
                case 4://去发货
                    if(curStatus==1){
                        orderSvc.upOrderStatus(orderid,status);
                        orderSvc.updateOrderPostInfo(orderid,orderpostcode,orderpostname);
                        m.put("handle", "success");
                    }else{
                        m.put("handle", "failure");
                    }
                    break;
                default:
                    m.put("handle", "failure");
                    break;
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            m.put("handle", "exception");
        }
        return m;
    }

    @ResponseBody
    @RequestMapping(value = "/delOrder", produces = "application/json;charset=UTF-8")
    public Map<String, Object> delOrder(Integer orderid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int status = orderSvc.getOrderStatusById(orderid);
            if(status==0||status==3||status==8||status==5||status==9){
                orderSvc.deleteOrder(orderid);
            }else{
                map.put("ERROR_MESSAGE", "注意订单状态，当前删除操作失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("ERROR_MESSAGE", "当前删除操作失败！");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/showOrder", produces = "application/json;charset=UTF-8")
    public Map<String, Object> showOrder(Integer orderid) {
        Map<String, Object> map = new HashMap<String, Object>();
        return map;
    }

    /*管理员点击 “修改” 订单的操作*/
    @ResponseBody
    @RequestMapping(value = "/updateOrder", produces = "application/json;charset=UTF-8")
    public Map<String, Object> updateOrder(
            Integer orderid,
            String orderpostname,
            String orderpostcode) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            orderSvc.updateOrderPostInfo(orderid, orderpostcode, orderpostname);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("res_error", -1);
        }
        return map;
    }
}
