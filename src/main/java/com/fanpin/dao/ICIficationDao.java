package com.fanpin.dao;

import com.fanpin.entity.ClassIfication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICIficationDao {
    List<ClassIfication> selAllClass();

    int addSort(ClassIfication sort);

    int deleteSort(@Param("classid") Integer classid);

    int upSort(ClassIfication sort);
}
