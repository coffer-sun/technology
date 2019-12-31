package com.fanpin.controller;

import com.fanpin.entity.Log;
import com.fanpin.entity.Product;
import com.fanpin.entity.ShoppingCart;
import com.fanpin.service.ILoginSvc;
import com.fanpin.service.IProductSvc;
import com.fanpin.service.IShoCartSvc;
import com.fanpin.util.ToolsUtil;
import com.fanpin.util.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/usercart")
public class ShoCartController {

    @Resource
    private IShoCartSvc shoCartSvc;
    @Resource
    private IProductSvc productSvc;
    @Resource
    private ILoginSvc loginSvc;

    @RequestMapping(value = "addcart")
    public String addCart(
            ShoppingCart cart) {
        cart.setCartbytime(ToolsUtil.getTime("yyyy-MM-dd HH:mm:ss", 0));
        Product product = productSvc.proSelByCId(cart.getPid());
        cart.setPriceall(cart.getNumbers() * product.getPrice());
        final int i = shoCartSvc.addCart(cart);
        Log log = ToolsUtil.insertLog(UserUtil.getLoginUserId(), "您添加了一款名为【" + product.getPname() + "】的商品到购物车");
        loginSvc.insertUserLog(log);
        return "redirect:mycart";
    }

    @RequestMapping(value = "delcart")
    public String delCart(Integer cartid) {
        int i = shoCartSvc.delCartByID(cartid);
        Log log = ToolsUtil.insertLog(UserUtil.getLoginUserId(), "您在购物车删除了购物ID为【" + cartid + "】的商品");
        loginSvc.insertUserLog(log);
        return "redirect:mycart";
    }

    @RequestMapping(value = "mycart")
    public ModelAndView myCart(ModelAndView view) {
        List<ShoppingCart> list = shoCartSvc.selAllCart(UserUtil.getLoginUserId());
        view.addObject("res_list", list);
        view.setViewName("user_cart");
        return view;
    }
}
