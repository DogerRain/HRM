package com.xiaoysec.hrm.common.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {

	private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

	/**
	 * 
	 * @param dirPath
	 *            文件夹路径
	 * @return boolean 是否创建成功
	 */
	public static boolean createDirectory(String dirPath) {
		logger.debug("createDirectory method...");
		;
		if (!dirPath.endsWith(File.separator)) {
			dirPath += File.separator;
		}
		File file = new File(dirPath);
		if (file.exists()) {
			logger.debug("目录 " + dirPath + " 已存在!");
			return false;
		}
		if (file.mkdirs()) {
			logger.debug("目录 " + dirPath + " 创建成功!");
			return true;
		} else {
			logger.debug("目录 " + dirPath + " 创建失败!");
			return false;
		}
	}

}
