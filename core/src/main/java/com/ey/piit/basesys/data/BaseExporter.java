package com.ey.piit.basesys.data;

import java.io.File;
import java.util.Collection;

import com.ey.piit.basesys.data.entity.ExportSetting;
import com.ey.piit.basesys.data.entity.FilePersistence;
import com.ey.piit.basesys.data.entity.FileServiceMessage;
import com.ey.piit.basesys.data.handler.ExportDataHandler;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;

public abstract class BaseExporter {
	
	@SuppressWarnings("rawtypes")
	public abstract FilePersistence exportToFile(Collection<?> result, ExportSetting setting, User user, ExportDataHandler handler);
	
	public abstract int getExportSize();

	/**
	 * 拼接上传路径字符串
	 * @param dir			BASE目录
	 * @param ownerModule	第一层目录
	 * @param timestamp		第二层目录
	 * @return
	 * @throws FileServiceException 
	 */
	protected String newFilePath(String dir, String ownerModule, String date) {
		
		StringBuffer filePath = new StringBuffer();
		filePath.append(dir);
		filePath.append(ownerModule);
		filePath.append(File.separator);
		filePath.append(date);
		filePath.append(File.separator);
		
		try {
			File d = new File(filePath.toString());
			if (!d.exists())
				d.mkdirs();
		} catch (SecurityException e) {
			throw new ServiceException(FileServiceMessage.FILE_CANNOT_WRITE.toString(),e);
		}
		
		return filePath.toString();
	}
}
