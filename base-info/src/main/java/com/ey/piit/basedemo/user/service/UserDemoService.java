package com.ey.piit.basedemo.user.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basedemo.user.repository.UserDemoDao;
import com.ey.piit.basedemo.user.vo.DemoFileVo;
import com.ey.piit.basedemo.user.vo.UserDemoVo;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.core.utils.BeanValidators;
import com.ey.piit.core.utils.SelectUtils;
import com.ey.piit.core.utils.StringUtils;
import com.google.common.collect.Lists;

/**
 * 用户Service
 * @author kevin
 */
@Service
public class UserDemoService extends BaseService<UserDemoDao, UserDemoVo> {
	
	@Value("${tmp.file.folder}")
    private String folder;
	
	@Autowired
	protected Validator validator;
	
	@Override
	public UserDemoVo findById(String id) {
		UserDemoVo result = super.findById(id);
		if (result != null) {
			DemoFileVo demoFileVo = new DemoFileVo();
			demoFileVo.setId("1");
			demoFileVo.setName("win.ini");
			List<DemoFileVo> fileList = Lists.newArrayList(demoFileVo);
			result.setFileList(fileList);
		}
		return result;
	}

	@Override
	protected int save(UserDemoVo entity) {
		int result = super.save(entity);
		saveFile(entity);
		return result;
	}
	
	@Override
	protected void updateBefore(UserDemoVo entity) {
		BeanValidators.validateWithException(validator, entity);
	}

	private void saveFile(UserDemoVo record) {
		MultipartFile[] files = record.getFiles();

		// 判断file数组不能为空并且长度大于0
		if (files != null && files.length > 0) {
			
			// 循环获取file数组中得文件
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];

				// 判断文件是否为空
				if (!file.isEmpty()) {
					
					// 文件保存路径
					String filePath = folder + "userDemo" + "/" + record.getId();
					File path = new File(filePath);
					if (!path.exists()) {
						path.mkdirs();
					}
					filePath += "/" + UUID.randomUUID().toString();
					
					//保存上传附件信息
					/*CompanyFileVo companyFile = new CompanyFileVo();
					companyFile.setCompCode(record.getCode());
					companyFile.setFileName(file.getOriginalFilename());
					companyFile.setFilePath(filePath);
					companyFile.setStatus(Constants.STATUS_ENABLED);
					companyFileService.saveOrUpdate(companyFile);*/
					
					// 转存文件
					try {
						file.transferTo(new File(filePath));
					} catch (Exception e) {
						throw new ServiceException(e);
					}
				}
			}
		}
		
		String companyFileOper = record.getFileOper();
		if (StringUtils.isNotBlank(companyFileOper)) {
			Map<String, String> companyFileMap = SelectUtils.filterRepeat(companyFileOper);
			Iterator<String> iterator = companyFileMap.keySet().iterator();
			
			//禁用删除的附件
			/*while (iterator.hasNext()) {
				String id = iterator.next();
				CompanyFileVo companyFile = new CompanyFileVo();
				companyFile.setId(id);
				companyFile.setStatus(Constants.STATUS_DISABLED);
				companyFileService.saveOrUpdate(record);
			}*/
		}
		
	}
	
	public void downloadFile(String id,HttpServletResponse response) {
		FileInputStream input = null;
		ServletOutputStream output = null;
    	try {
    		//CompanyFileVo companyFile = companyFileService.findById(id);
			//File file = new File(companyFile.getFilePath());
    		File file = new File("C:/Windows/win.ini");
			input = new FileInputStream(file);
			output = response.getOutputStream();
			IOUtils.copy(input, output);
			
			//String codedFileName = java.net.URLEncoder.encode(companyFile.getFileName(), "UTF-8");
			String codedFileName = java.net.URLEncoder.encode("win.ini", "UTF-8");
			response.setContentType("multipart/form-data;charset=UTF-8");
			response.setHeader("Content-disposition", "attachment;filename=" + codedFileName);
		} catch (IOException e) {
			throw new ServiceException(e);
		} finally {
			IOUtils.closeQuietly(input);
			IOUtils.closeQuietly(output);
		}
	}
}