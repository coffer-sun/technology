package com.fanpin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fanpin.dao.ILogDao;
import com.fanpin.entity.Log;
import com.fanpin.entity.Page;
import com.fanpin.service.ILogSvc;

@Service
public class LogSvcIMPL implements ILogSvc {

    @Resource
    private ILogDao logDao;

    @Override
    public List<Log> logSelByUId(Integer uid) {
        return logDao.logSelByUId(uid);
    }

    @Override
    public int logSelCount(Integer uid) {
        return logDao.logSelCount(uid);
    }

    @Override
    public List<Log> findLoad(Page page) {
        return logDao.findLoad(page);
    }

    @Override
    public int deleteLogByIds(Integer[] logids) { return logDao.deleteLogByIds(logids); }

    @Override
    public int deleteLogAll() { return logDao.deleteLogAll(); }
}
