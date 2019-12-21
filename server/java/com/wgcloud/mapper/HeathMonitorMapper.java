package com.wgcloud.mapper;

import com.wgcloud.entity.HeathMonitor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @ClassName:HeathMonitorMapper.java
 * @version v2.1
 * @author: http://www.wgstart.com
 * @date: 2019年11月16日
 * @Description: HeathMonitorDao.java
 * @Copyright: 2019-2020 wgcloud. All rights reserved.
 *
 */
@Repository
public interface HeathMonitorMapper {

    public List<HeathMonitor> selectAllByParams(Map<String, Object> map) throws Exception;
    
	public List<HeathMonitor> selectByParams(Map<String, Object> params) throws Exception;
	
    public HeathMonitor selectById(String id) throws Exception;
    
    public void save(HeathMonitor HeathMonitor) throws Exception;

    public void insertList(List<HeathMonitor> recordList) throws Exception;
    
    public int deleteById(String[] id) throws Exception;

    public int deleteByDate(Map<String, Object> map) throws Exception;

    public int countByParams(Map<String, Object> params) throws Exception;

    public void updateList(List<HeathMonitor> recordList) throws Exception;
    
    public HeathMonitor updateById(HeathMonitor HeathMonitor) throws Exception;
}
