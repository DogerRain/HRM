package com.xiaoysec.hrm.common.dictionary.mapper;

import java.util.List;

import com.xiaoysec.hrm.common.dictionary.entity.City;
import com.xiaoysec.hrm.common.dictionary.entity.Province;

public interface DicRegionMapper {

	List<Province> getProvinceList();

	List<City> getCityList(String provinceCode);

	List<City> getCityInfo();

}
