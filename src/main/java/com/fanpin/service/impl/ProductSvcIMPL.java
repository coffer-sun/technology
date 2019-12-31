package com.fanpin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fanpin.dao.IProductDao;
import com.fanpin.entity.ClassIfication;
import com.fanpin.entity.Page;
import com.fanpin.entity.Product;
import com.fanpin.service.IProductSvc;

@Service
public class ProductSvcIMPL implements IProductSvc {

    @Resource
    private IProductDao productDao;

    @Override
    public Product proSelByCId(Integer pid) {
        return productDao.proSelByCId(pid);
    }

    @Override
    public List<Map<String, Object>> proSelByCIds(Integer[] pid, int[] pronum) {
        /* 调用 Dao 层从数据库获取相应商品列表 */
        List<Product> proinfo = productDao.proSelByCIds(pid);
        /* 创建新的键值对集合，存放信息 */
        List<Map<String,Object>> prolist=new ArrayList<Map<String, Object>>();
        for(int i=0;i<pid.length;i++){
            Product product=new Product();
            product.setPid(pid[i]);
            /* 返回对象 product 在 proinfo 集合中出现的索引位置
            int j=proinfo.indexOf(proinfo.get(i));
            System.out.println("---Svc---："+product);
            System.out.println("---Svc---："+proinfo.get(i));
            System.out.println("---Svc---："+j);
            if(j!=-1){*/
                Product pro=proinfo.get(i);
                Map<String,Object> m=new HashMap<String, Object>();
                m.put("pid", pid[i]);
                m.put("pname", pro.getPname());
                m.put("price", pro.getPrice());
                m.put("pimg", pro.getPimg());
                m.put("pronum", pronum[i]);
                prolist.add(m);
            /*}*/
        }
        return prolist;
    }

    @Override
    public int proSelCount(Integer classid) {
        return productDao.proSelCount(classid);
    }

    @Override
    public List<Product> findPage(Page page) {
        return productDao.findPage(page);
    }

    @Override
    public ClassIfication findClassName(Integer classid) {
        return productDao.findClassName(classid);
    }

    @Override
    public int proSelAllCount() {
        return productDao.proSelAllCount();
    }

    @Override
    public List<Product> findAllPage(Page page) {
        return productDao.findAllPage(page);
    }

    @Override
    public List<Product> selProductAll() {
        return productDao.selProductAll();
    }

    @Override
    public int upProduct(Product product) {
        return productDao.upProduct(product);
    }

    @Override
    public List<Product> selNumProduct(int index) {
        return productDao.selNumProduct(index);
    }

    @Override
    public List<Product> selTypePro(String type, int index, String sort) {
        return productDao.selTypePro(type, index, sort);
    }

    @Override
    public List<Product> searchProduct(String keyname, Integer classid) {
        return productDao.searchProduct(keyname, classid);
    }

    @Override
    public int addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public int delProduct(Integer pid) {
        return productDao.delProduct(pid);
    }


}
