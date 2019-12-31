package com.fanpin.dao;

import java.util.List;

import com.fanpin.entity.Log;
import com.fanpin.entity.Page;
import org.apache.ibatis.annotations.Param;

public interface ILogDao {

	List<Log> logSelByUId(Integer uid);	//通过id查找日志
	int logSelCount(Integer uid);	//加载的总数据项
	List<Log> findLoad(Page page);	//读取加载项
	/*注意：此处要添加@Param("logids")，为其制指定参数来源*/
	int deleteLogByIds(@Param("logids") Integer[] logids);	//批量删除日志
	int deleteLogAll();	//一键删除日志
}
