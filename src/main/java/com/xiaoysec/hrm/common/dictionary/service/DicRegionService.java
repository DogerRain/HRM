package com.xiaoysec.hrm.common.dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoysec.hrm.common.dictionary.entity.City;
import com.xiaoysec.hrm.common.dictionary.entity.Province;
import com.xiaoysec.hrm.common.dictionary.mapper.DicRegionMapper;

@Service
@Transactional(readOnly = true)
public class DicRegionService {

	@Autowired
	private DicRegionMapper dicMapper;

	// 获取所有的省份信息
	public List<Province> getProvinceList() {
		return dicMapper.getProvinceList();
	}

	//根据省份编码获取城市列表
	public List<City> getCityList(String provinceCode) {
		return dicMapper.getCityList(provinceCode);
	}

	//获取所有城市信息
	public List<City> getCityInfo() {
		return dicMapper.getCityInfo();
	}

}
