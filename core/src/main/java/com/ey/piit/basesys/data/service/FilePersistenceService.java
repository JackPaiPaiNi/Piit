package com.ey.piit.basesys.data.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.basesys.data.entity.FilePersistence;
import com.ey.piit.basesys.data.entity.FileServiceMessage;
import com.ey.piit.basesys.data.repository.FilePersistenceDao;
import com.ey.piit.basesys.data.vo.FilePersistenceVo;
import com.ey.piit.core.exception.BaseException;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.service.CoreService;
import com.ey.piit.core.utils.RandomUtils;

/**
 * 对外实现upload download方法实现，内部实现文件上传逻辑，下载逻辑。
 * @author Kevin-Y.Xu
 */
@Service
public class FilePersistenceService extends CoreService {

	@Autowired
	private FilePersistenceDao filePersistenceDao;
	
	private static final String FILES_IHS_PREFIX = "/files/";
	
	//从appliaction.properties配置文件中获取文件保存路径
	private String root ;
	
	private String module;
	
	/**
	 * 保存文件
	 * @param file//文件
	 * @param fileName//文件名
	 * @param fileContentType//上传文件类型
	 * @param ownerModule//指定所属模块
	 * @throws FileServiceException 
	 * @throws ServiceException
	 */
	public String saveFile(File file, String fileName, String fileContentType) {
		
		//创建文件对象
		FilePersistenceVo fp = new FilePersistenceVo();
		fp.setFileName(fileName);
		fp.setOwnerModule(module);
		fp.setTempFile(file);
		fp.setContentType(fileContentType);
		fp.setOperatorId(this.findCurUser().getEmpCode());
		
		//获取时间戳
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		//设置上传时间
		fp.setLogDate(ts);
		//创建时间作为第2层文件夹
		String physicalNameFolder = new SimpleDateFormat("yyyyMMdd").format(ts);
		//创建文件上传全路径
		String filePath = newFilePath(fp.getOwnerModule(), physicalNameFolder);
		
		File destFile = this.newPhysicalFile(filePath, fp.getFileName(), physicalNameFolder);
		
		//将物理文件名保存到实体类中
		fp.setPhysicalName(destFile.getAbsolutePath());
		//设置下载路径
		String downLoadPath = fp.getPhysicalName();
		
		String ihsFile = FILES_IHS_PREFIX + downLoadPath.substring(downLoadPath.indexOf(this.root) + this.root.length());
		
		fp.setDownloadPath(ihsFile.replace(File.separator, "/"));

		try {
			this.saveToNFS(fp, destFile);
			fp.setContentLength(new BigDecimal(destFile.length()));
			this.saveToDB(fp);
		} catch (Exception e) {
			FileUtils.deleteQuietly(destFile);
			throw new ServiceException(FileServiceMessage.FILE_SAVE_ERROR.toString(),e);
		}
		
		return fp.getId();
	}
	
	/**
	 * 保存文件到文件系统
	 * @param filePath
	 * @param fp
	 * @throws FileServiceException 
	 * @throws IOException 
	 * @throws BaseException
	 */
	private void saveToNFS(FilePersistenceVo fp, File destFile) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(fp.getTempFile());
			os = new FileOutputStream(destFile);
			
			IOUtils.copy(is, os);
		} catch (IOException e) {
			throw new ServiceException(e);
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}

	public void removeFilePersistenceById(String ids) {
		String[] idArr = ids.split(",");
		for (int i = 0; i < idArr.length; i++) {
		    String id = idArr[i];
		    FilePersistence fp = filePersistenceDao.selectById(id);
		    File delFile = new File(fp.getPhysicalName());
		    FileUtils.deleteQuietly(delFile);
        }
		filePersistenceDao.deleteByIds(ids);
	}
	
	/**
	 * 拼接上传路径字符串
	 * @param ownerModule	第一层目录
	 * @param timestamp		第二层目录
	 * @return
	 * @throws FileServiceException 
	 */
	private String newFilePath(String ownerModule, String date) {
		
		StringBuffer filePath = new StringBuffer();
		filePath.append(this.root);
		filePath.append(ownerModule);
		filePath.append(File.separator);
		filePath.append(date);
		
		try {
			File d = new File(filePath.toString());
			if (!d.exists())
				d.mkdirs();
		} catch (SecurityException e) {
			throw new ServiceException(FileServiceMessage.FILE_CANNOT_WRITE.toString(),e);
		}
		
		return filePath.toString();
	}
	
	private File newPhysicalFile(String filePath, String fileName, String suffix) {
		
		File newFile = null;
		
		while(true) {
			//获取随机数
			Integer rdm = Math.abs(RandomUtils.getRandom().nextInt());
			//拼接成新的文件名，作为物理路径
			String fileNewNameString = FilenameUtils.getBaseName(fileName) + "_" + suffix + "_" + rdm + FilenameUtils.EXTENSION_SEPARATOR
					+ FilenameUtils.getExtension(fileName);
			
			newFile = new File(filePath + File.separator + fileNewNameString);
			
			if (!newFile.exists())
				break;
		}
		
		return newFile;
	}
	
	/**
	 * 保存文件信息到数据库
	 * @param fp
	 * @return 
	 */
	private void saveToDB(FilePersistence fp) {
		fp.setId(UUID.randomUUID().toString());
		filePersistenceDao.insert(fp);
	}
	
	/**
	 * 根据文件ID获取文件
	 */
	public FilePersistence getFile(String id) {
		return filePersistenceDao.selectById(id);
	}

	public FilePersistence getDownloadFile(String id) {
		FilePersistence fp = null;
		fp = filePersistenceDao.selectById(id);
		if (fp == null) {
			throw new ValidateException(FileServiceMessage.FILE_INFO_NOT_EXIST.toString());
		}

		File file = new File(fp.getPhysicalName());
		if (!file.exists()) {
			throw new ValidateException(FileServiceMessage.FILE_NOT_EXIST.toString());
		}
		if (!file.canRead()) {
			throw new ValidateException(FileServiceMessage.FILE_CANNOT_READ.toString());
		}
		return fp;
	}

	public String saveFile(FilePersistence filePersistence) {
		filePersistence.setId(UUID.randomUUID().toString());
		filePersistenceDao.insert(filePersistence);
		return filePersistence.getId();
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public FilePersistenceDao getFilePersistenceDao() {
		return filePersistenceDao;
	}

	public void setFilePersistenceDao(FilePersistenceDao filePersistenceDao) {
		this.filePersistenceDao = filePersistenceDao;
	}

	public List<FilePersistenceVo> findFilePersistenceByQueryPage(Map<String, Object> params, PageBounds page) {
		return filePersistenceDao.selectByPage(params, page);
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Override
	protected ICoreDao getDao() {
		return null;
	}

}
