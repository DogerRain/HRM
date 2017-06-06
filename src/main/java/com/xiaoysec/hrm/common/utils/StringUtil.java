package com.xiaoysec.hrm.common.utils;

/**
 * 字符串工具类
 * @author xiaoysec
 *
 */
public class StringUtil {
	//区别于lang3中的CharSequence参数,该函数将空白符也算是空的一种
	public static boolean isEmpty(final String str){
		return str==null || str.trim().length()== 0;
	}
}
