package com.xiaoysec.hrm.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public enum RaceMapper {
	ACHANGZU("1","阿昌族"),
	BAIZU("2","白族"),
	BAOANZU("3","保安族"),
	BULANGZU("4","布朗族"),
	BUYIZU("5","布依族"),
	CHAOXIANZU("6","朝鲜族"),
	DAWOERZU("7","达斡尔族"),
	DAIZU("8","傣族"),
	DEANGZU("9","德昂族"),
	DONGXIANGZU("10","东乡族"),
	DONGZU("11","侗族"),
	DULONGZU("12","独龙族"),
	ELUOSIZU("13","俄罗斯族"),
	ELUNCHUNZU("14","鄂伦春族"),
	EWENKEZU("15","鄂温克族"),
	GAOSHANZU("16","高山族"),
	GELAOZU("17","仡佬族"),
	HANIZU("18","哈尼族"),
	HASAKEZU("19","哈萨克族"),
	HANZU("20","汉族"),
	HEZHEZU("21","赫哲族"),
	HUIZU("22","回族"),
	JINUOZU("23","基诺族"),
	JINGZU("24","京族"),
	JINGPOZU("25","景颇族"),
	KEERKEZIZU("26","柯尔克孜族"),
	LAHUZU("27","拉祜族"),
	LIZU("28","黎族"),
	LISUZU("29","傈僳族"),
	LUOBAZU("30","珞巴族"),
	MANZU("31","满族"),
	MAONAOZU("32","毛南族"),
	MENBAZU("33","门巴族"),
	MENGGUZU("34","蒙古族"),
	MIAOZU("35","苗族"),
	MULAOZU("36","仫佬族"),
	NAXIZU("37","纳西族"),
	NUZU("38","怒族"),
	PUMIZU("39","普米族"),
	QIANGZU("40","羌族"),
	SALAZU("41","撒拉族"),
	SHEZU("42","畲族"),
	SHUIZU("43","水族"),
	TAJIKEZU("44","塔吉克族"),
	TATAERZU("45","塔塔尔族"),
	TUJIAZU("46","土家族"),
	TUZU("47","土族"),
	WAZU("48","佤族"),
	WEIWUERZU("49","维吾尔族"),
	WUZIBIEKEZU("50","乌孜别克族"),
	XIBOZU("51","锡伯族"),
	YAOZU("52","瑶族"),
	YIZU("53","彝族"),
	YUGUZU("54","裕固族"),
	ZANGZU("55","藏族"),
	ZHUANGZU("56","壮族");
	
	
	private String name;
	private String code;
	private RaceMapper(String code,String name){
		this.name = name;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	//通过code获取民族名称
	public static String getRaceName(String code){
		for(RaceMapper mapper : RaceMapper.values()){
			if(mapper.getCode().equals(code)){
				return mapper.getName();
			}
		}
		return null;
	}
	
	//通过民族名称获取民族code
	public static String getRaceCode(String name){
		for(RaceMapper mapper : RaceMapper.values()){
			if(mapper.getName().equals(name)){
				return mapper.getCode();
			}
		}
		return null;
	}
	
	public static Map<String,String> enumToMap(){
		HashMap<String, String> map = new HashMap<String,String>();
		for(RaceMapper mapper:RaceMapper.values()){
			map.put(mapper.getCode(), mapper.getName());
		}
		return map;
	}
	
	public static List<RaceMapper> enumToList(){
		ArrayList<RaceMapper> list = new ArrayList<RaceMapper>();
		for(RaceMapper mapper :RaceMapper.values()){
			list.add(mapper);
		}
		return list;
	}
	
	/**
	 * 枚举转json字符串
	 * @return
	 */
	public static String  enumToJsonString(){
		return JSON.toJSONString(enumToMap());
	}

}
