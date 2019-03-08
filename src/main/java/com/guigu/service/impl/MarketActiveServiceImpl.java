package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.guigu.mapper.MarketActiveMapper;
import com.guigu.mapper.StaffInfoMapper;
import com.guigu.mapper.TemplateInfoMapper;
import com.guigu.pojo.MarketActive;
import com.guigu.pojo.MarketActiveExample;
import com.guigu.pojo.MessafeInfo;
import com.guigu.pojo.MessafeInfoExample;
import com.guigu.pojo.StaffInfo;
import com.guigu.pojo.StaffInfoExample;
import com.guigu.pojo.TemplateInfo;
import com.guigu.pojo.TemplateInfoExample;
import com.guigu.service.MarketActiveService;
@Service
public class MarketActiveServiceImpl implements MarketActiveService {
  
	    @Resource
	    private MarketActiveMapper marketActiveMapper;
	    
	    @Resource
		private StaffInfoMapper staffInfoMapper;
		@Override
		public List<MarketActive> findAll() throws Exception {
		List<MarketActive> list = marketActiveMapper.selectByExample(new MarketActiveExample());
		if(!CollectionUtils.isEmpty(list)) {
			list.forEach((MarketActive)->{
				MarketActive.setStaffInfo(staffInfoMapper.selectByPrimaryKey(MarketActive.getStaffId()));
			});
		}
		return list;
	}
		@Override
		public Boolean deleteById(int activeId) throws Exception {
			return marketActiveMapper.deleteByPrimaryKey(activeId)>0;
		}
		@Override
		public List<MarketActive> findByNameAndState(String activeName, int activeState) throws Exception {
			MarketActiveExample  example = new MarketActiveExample();
			if(activeName != null ) {
				example.createCriteria().andActiveStateEqualTo(Integer.valueOf(activeState)).andActiveNameLike("%"+activeName+"%");
			}else {
				example.createCriteria().andActiveStateEqualTo(Integer.valueOf(activeState));
			}
			List<MarketActive> list=  marketActiveMapper.selectByExample(example);
				
			return list;
		}
		@Override
		public Boolean addMarketActive(MarketActive marketActive) throws Exception {
			return marketActiveMapper.insertSelective(marketActive)>0;
		}
		@Override
		public MarketActive findById(int activeId) throws Exception {
			return marketActiveMapper.selectByPrimaryKey(activeId);
		}
		@Override
		public Boolean update(MarketActive marketActive) throws Exception {
			
			return marketActiveMapper.updateByPrimaryKeySelective(marketActive)>0;
		}
		
}

