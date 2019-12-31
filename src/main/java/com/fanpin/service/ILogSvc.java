package com.fanpin.service;

import java.util.List;

import com.fanpin.entity.Log;
import com.fanpin.entity.Page;

public interface ILogSvc {

	List<Log> logSelByUId(Integer uid);
	int logSelCount(Integer uid);
	List<Log> findLoad(Page page);
	int deleteLogByIds(Integer[] logids);
	int deleteLogAll();
}
