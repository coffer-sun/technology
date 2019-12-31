package com.fanpin.service.impl;

import com.fanpin.dao.ICIficationDao;
import com.fanpin.entity.ClassIfication;
import com.fanpin.service.ICIficationSvc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CIficationSvcIMPL implements ICIficationSvc {

    @Resource
    private ICIficationDao cIficationDao;

    @Override
    public List<ClassIfication> selAllClass() {
        return cIficationDao.selAllClass();
    }

    @Override
    public int addSort(ClassIfication sort) {
        return cIficationDao.addSort(sort);
    }

    @Override
    public int deleteSort(Integer classid) {
        return cIficationDao.deleteSort(classid);
    }

    @Override
    public int upSort(ClassIfication sort) {
        return cIficationDao.upSort(sort);
    }
}
