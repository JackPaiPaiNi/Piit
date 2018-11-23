package com.ey.piit.basebpm.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessDefinitionService {
	
	@Autowired
	private RepositoryService repositoryService;

	/**
	 * 部署流程定义（从zip）
	 * @param zipPath
	 * @param name 流程名称
	 * @return 部署ID
	 */
	public String deploymentProcessDefinition(String zipPath,String name){
		try {
			InputStream in = new FileInputStream(zipPath);
			ZipInputStream zipInputStream = new ZipInputStream(in);
			Deployment deployment = repositoryService//与流程定义和部署对象相关的Service
					.createDeployment()//创建一个部署对象
					.name(name)//添加部署的名称
					.addZipInputStream(zipInputStream)//指定zip格式的文件完成部署
					.deploy();//完成部署
			return deployment.getId();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 部署流程定义（从zip）
	 * @param in
	 * @param name 流程名称
	 * @return 部署ID
	 */
	public String deploymentProcessDefinition(InputStream in,String name){
		if(in == null) {
            throw new NullPointerException("in is null");
        }
		ZipInputStream zipInputStream = new ZipInputStream(in);
		Deployment deployment = repositoryService//与流程定义和部署对象相关的Service
					.createDeployment()//创建一个部署对象
					.name(name)//添加部署的名称
					.addZipInputStream(zipInputStream)//指定zip格式的文件完成部署
					.deploy();//完成部署
		
		return deployment.getId();
	}
	
	/**
	 * 查询流程定义
	 */
	public List<ProcessDefinition> findProcessDefinitionAll(){
		List<ProcessDefinition> list = repositoryService//与流程定义和部署对象相关的Service
						.createProcessDefinitionQuery()//创建一个流程定义的查询
						
						/**排序*/
						.orderByProcessDefinitionName().desc()//按照流程定义的名称降序排列
						
						/**返回的结果集*/
						.list();//返回一个集合列表，封装流程定义
		return list;
	}
	
	/**
	 * 删除流程定义
	 * @param deploymentId
	 * @param cascade 
	 * 		true:级联删除(不管流程是否启动，都能可以删除)
	 * 		false:不带级联的删除(只能删除没有启动的流程，如果流程启动，就会抛出异常)
	 */
	public void deleteProcessDefinition(String deploymentId,boolean cascade){
		repositoryService
				.deleteDeployment(deploymentId, cascade);
	}
	
	/**
	 * 查看流程图
	 * @param deploymentId
	 * @return
	 */
	public InputStream findProcessPicture(String deploymentId){
		//获取图片资源名称
		List<String> list = repositoryService
						.getDeploymentResourceNames(deploymentId);
		//定义图片资源的名称
		String resourceName = "";
		if(list!=null && list.size()>0){
			for(String name:list){
				if(name.indexOf(".png")>=0){
					resourceName = name;
				}
			}
		}
		
		
		//获取图片的输入流
		InputStream in = repositoryService
						.getResourceAsStream(deploymentId, resourceName);
		return in;
	}
	
	/**
	 * 查询最新版本的流程定义
	 * @return
	 */
	public List<ProcessDefinition> findLastVersionProcessDefinition(){
		List<ProcessDefinition> list = repositoryService//
						.createProcessDefinitionQuery()//
						.orderByProcessDefinitionVersion().asc()//使用流程定义的版本升序排列
						.list();
		/**
		 * Map<String,ProcessDefinition>
		 * map集合的key：流程定义的key
		 * map集合的value：流程定义的对象
		 * map集合的特点：当map集合key值相同的情况下，后一次的值将替换前一次的值
		 */
		Map<String, ProcessDefinition> map = new LinkedHashMap<String, ProcessDefinition>();
		if(list!=null && list.size()>0){
			for(ProcessDefinition pd:list){
				map.put(pd.getKey(), pd);
			}
		}
		List<ProcessDefinition> pdList = new ArrayList<ProcessDefinition>(map.values());
		return pdList;
	}
	
	/**
	 * 删除流程定义（删除key相同的所有不同版本的流程定义）
	 * @param processDefinitionKey
	 * @param cascade 
	 * 		true:级联删除(不管流程是否启动，都能可以删除)
	 * 		false:不带级联的删除(只能删除没有启动的流程，如果流程启动，就会抛出异常)
	 */
	public void deleteProcessDefinitionByKey(String processDefinitionKey,boolean cascade){
		//先使用流程定义的key查询流程定义，查询出所有的版本
		List<ProcessDefinition> list = repositoryService//
						.createProcessDefinitionQuery()//
						.processDefinitionKey(processDefinitionKey)//使用流程定义的key查询
						.list();
		//遍历，获取每个流程定义的部署ID
		if(list!=null && list.size()>0){
			for(ProcessDefinition pd:list){
				//获取部署ID
				String deploymentId = pd.getDeploymentId();
				repositoryService
							.deleteDeployment(deploymentId, cascade);
			}
		}
	}

}
