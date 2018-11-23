import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Before;
import org.junit.Test;

import com.ey.piit.basebpm.service.ProcessInstanceService;
import com.ey.piit.basebpm.service.ProcessTaskService;


public class TestProcessDelete {
	private TaskService taskService;
	private RuntimeService runtimeService;
	private IdentityService identityService;
	
	private ProcessInstanceService processInstanceService;
	private ProcessTaskService processTaskService;
	
	@Before
	public void init(){
		// 获取流程引擎配置对象实例
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		// 数据库相关配置
		configuration.setJdbcUrl("jdbc:oracle:thin:@172.20.99.87:1521:HWSDO");
		configuration.setJdbcDriver("oracle.jdbc.driver.OracleDriver");
		configuration.setJdbcUsername("SDO_USER");
		configuration.setJdbcPassword("Aa123456");
		/*configuration.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		configuration.setJdbcDriver("oracle.jdbc.driver.OracleDriver");
		configuration.setJdbcUsername("cre_mdm");
		configuration.setJdbcPassword("cre_mdm");*/
		// 配置建表策略,默认情况下false
		configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		// 使用配置对象实例创建ProcessEngine
		ProcessEngine processEngine = configuration.buildProcessEngine();
		runtimeService = processEngine.getRuntimeService();
		taskService = processEngine.getTaskService();
		identityService = processEngine.getIdentityService();
		
		processInstanceService = new ProcessInstanceService();
		processInstanceService.setIdentityService(identityService);
		processInstanceService.setRuntimeService(runtimeService);
		processInstanceService.setTaskService(taskService);
		
		processTaskService = new ProcessTaskService();
		processTaskService.setIdentityService(identityService);
		processTaskService.setRuntimeService(runtimeService);
		processTaskService.setTaskService(taskService);
	}
	
	@Test
	public void test(){
		//删除某个流程实例(需传入processID)
		processInstanceService.deleteProcessInstance("2472977");
	}
}
