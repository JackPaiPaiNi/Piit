package com.ey.piit.basesys.data.vo;

import java.io.File;

import com.ey.piit.basesys.data.entity.FilePersistence;

public class FilePersistenceVo extends FilePersistence{

	private File tempFile;// 临时文件对象，主要用户提供下载时使用

	public File getTempFile() {
		return tempFile;
	}

	public void setTempFile(File tempFile) {
		this.tempFile = tempFile;
	}
	
}
