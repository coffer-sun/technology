package com.fanpin.dao;

import com.fanpin.entity.ShoppingCart;

import java.util.List;

public interface IShoCartDao {

    int addCart(ShoppingCart cart); //添加购物车
    List<ShoppingCart> selAllCart(Integer uid);
    int delCartByID(Integer cartid);
}
