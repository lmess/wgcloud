package com.wgcloud.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wgcloud.mapper.TcpStateMapper;
import com.wgcloud.entity.TcpState;
import com.github.pagehelper.PageHelper;
import com.wgcloud.util.DateUtil;
import com.wgcloud.util.UUIDUtil;

/**
 *
 * @ClassName:TcpStateService.java     
 * @version v2.1
 * @author: http://www.wgstart.com
 * @date: 2019年11月16日
 * @Description: TcpStateService.java
 * @Copyright: 2019-2020 wgcloud. All rights reserved.
 *
 */
@Service
public class TcpStateService{

	public PageInfo selectByParams(Map<String, Object> params, int currPage,int pageSize) throws Exception {
		PageHelper.startPage(currPage, pageSize);
		List<TcpState> list = tcpStateMapper.selectByParams(params);
		PageInfo<TcpState> pageInfo = new PageInfo<TcpState>(list);
		return pageInfo;
	}

	public void save(TcpState TcpState) throws Exception {
		TcpState.setId(UUIDUtil.getUUID());
		TcpState.setCreateTime(DateUtil.getNowTime());
		TcpState.setDateStr(DateUtil.getDateTimeString(TcpState.getCreateTime()));
		tcpStateMapper.save(TcpState);
	}
	
	
	public void saveRecord(List<TcpState> recordList) throws Exception {
		if(recordList.size()<1){
			return;
		}
		 for(TcpState as : recordList){
			 as.setId(UUIDUtil.getUUID());
			 as.setDateStr(DateUtil.getDateTimeString(as.getCreateTime()));
		 }
		 tcpStateMapper.insertList(recordList);
	}
	
	
	public int deleteById(String[] id) throws Exception {
		return tcpStateMapper.deleteById(id);
	}

	public TcpState selectById(String id)  throws Exception{
		return tcpStateMapper.selectById(id);
	}

	public List<TcpState> selectAllByParams(Map<String, Object> params)throws Exception {
		return tcpStateMapper.selectAllByParams(params);
	}
	
	
	@Autowired
	private TcpStateMapper tcpStateMapper;



}
