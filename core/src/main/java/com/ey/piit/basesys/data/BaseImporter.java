package com.ey.piit.basesys.data;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.User;

/**
 * 导入基类
 * @author Kevin-Y.Xu
 */
public abstract class BaseImporter {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	protected String importerDirectory;
	
	public static final String IMPORT_MODULE = "IMPORT";
	
	public abstract<E> String importFile(Class<E> clz, File file, Map<String, String> params);
	
	public abstract<E> String importFilePreview(Class<E> clz, File file, Map<String, String> params);
	
	public abstract<E> String importFile(Class<E> clz, MultipartFile file, Map<String, String> params);
	
	public abstract<E> String importFilePreview(Class<E> clz, MultipartFile file, Map<String, String> params);
	
	public abstract<E> List<E> importFileReturn(Class<E> clz, MultipartFile file, Map<String, String> params);
	
	protected User findCurUser(){
		Subject currentUser = SecurityUtils.getSubject();  
    	Session session = currentUser.getSession();
    	User curUser = (User)session.getAttribute(Constants.CURRENT_USER);
    	return curUser;
	}
	
	public String getImporterDirectory() {
		return importerDirectory;
	}

	public void setImporterDirectory(String importerDirectory) {
		this.importerDirectory = importerDirectory;
	}

}
