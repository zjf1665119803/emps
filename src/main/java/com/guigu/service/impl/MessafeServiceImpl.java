package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.guigu.mapper.MessafeInfoMapper;
import com.guigu.mapper.StaffInfoMapper;
import com.guigu.pojo.MessafeInfo;
import com.guigu.pojo.MessafeInfoExample;
import com.guigu.service.MessafeService;
@Service
public class MessafeServiceImpl implements MessafeService {
    @Resource
    private MessafeInfoMapper messafeInfoMapper;
	@Resource
	private StaffInfoMapper staffInfoMapper;
	@Override
	public List<MessafeInfo> findAll() throws Exception {
		List<MessafeInfo> list = messafeInfoMapper.selectByExample(new MessafeInfoExample());
		if(!CollectionUtils.isEmpty(list)) {
			list.forEach((Messafe)->{
				Messafe.setStaffInfo(staffInfoMapper.selectByPrimaryKey(Messafe.getStaffId()));
			});
		}
		return list;
	}
	@Override
	public List<MessafeInfo> findByPhone(String messafePhone) throws Exception {
		MessafeInfoExample example = new MessafeInfoExample();
		example.createCriteria().andMessafePhoneLike("%"+messafePhone+"%");
		return messafeInfoMapper.selectByExample(example);
	}
	@Override
	public Boolean deleteMessafeById(int messafeId) throws Exception {
		return messafeInfoMapper.deleteByPrimaryKey(messafeId)>0;
	}
	@Override
	public MessafeInfo lookById(int messafeId) throws Exception {
		MessafeInfo messafeInfo = messafeInfoMapper.selectByPrimaryKey(messafeId);
		if(!messafeInfo.equals(null)) {
			messafeInfo.setStaffInfo(staffInfoMapper.selectByPrimaryKey(messafeInfo.getStaffId()));
		}
		return messafeInfo;
		}
	@Override
	public Boolean sendMessge(MessafeInfo messafeInfo) throws Exception {
		return messafeInfoMapper.insertSelective(messafeInfo)>0;
	}

}
