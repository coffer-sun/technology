package com.fanpin.service.impl;

import com.fanpin.dao.IShoCartDao;
import com.fanpin.entity.ShoppingCart;
import com.fanpin.service.IShoCartSvc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoCartSvcIMPL implements IShoCartSvc {

    @Resource
    private IShoCartDao shoCartDao;

    @Override
    public int addCart(ShoppingCart cart) {
        return shoCartDao.addCart(cart);
    }

    @Override
    public List<ShoppingCart> selAllCart(Integer uid) {
        return shoCartDao.selAllCart(uid);
    }

    @Override
    public int delCartByID(Integer cartid) {
        return shoCartDao.delCartByID(cartid);
    }
}
