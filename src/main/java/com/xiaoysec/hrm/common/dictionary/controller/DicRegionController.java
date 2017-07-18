package com.xiaoysec.hrm.common.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoysec.hrm.common.dictionary.entity.City;
import com.xiaoysec.hrm.common.dictionary.entity.Province;
import com.xiaoysec.hrm.common.dictionary.service.DicRegionService;

@Controller
@RequestMapping(value = "${adminPath}/dicregion")
public class DicRegionController {
	
	@Autowired
	private DicRegionService dicService;
	
	@RequestMapping(value = "getProvince")
	@ResponseBody
	public List<Province> getProvinceList(){
		return dicService.getProvinceList();
	}
	
	//获取城市
	@RequestMapping(value = "getCity")
	@ResponseBody
	public List<City> getCityList(String provinceCode){
		return dicService.getCityList(provinceCode);
	}
	
	@RequestMapping(value = "getCityInfo")
	@ResponseBody
	public List<City> getCityInfo(){
		return dicService.getCityInfo();
	}
	

}
