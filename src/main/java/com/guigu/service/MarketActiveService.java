package com.guigu.service;

import java.util.List;

import com.guigu.pojo.MarketActive;

public interface MarketActiveService {

	List<MarketActive> findAll() throws Exception;

	Boolean deleteById(int activeId)throws Exception;

	List<MarketActive> findByNameAndState(String activeName, int activeState)throws Exception;

	Boolean addMarketActive(MarketActive marketActive)throws Exception;

	MarketActive findById(int activeId)throws Exception;

	Boolean update(MarketActive marketActive)throws Exception;

}
