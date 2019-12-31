package com.fanpin.service;

import com.fanpin.entity.ClassIfication;

import java.util.List;

public interface ICIficationSvc {
    List<ClassIfication> selAllClass();

    int addSort(ClassIfication sort);

    int deleteSort(Integer classid);

    int upSort(ClassIfication sort);
}
