package com.fanpin.service;

import com.fanpin.entity.ShoppingCart;

import java.util.List;

public interface IShoCartSvc {
    int addCart(ShoppingCart cart);
    List<ShoppingCart> selAllCart(Integer uid);
    int delCartByID(Integer cartid);
}
