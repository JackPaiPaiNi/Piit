package com.ey.piit.core.common;

public class Constants {
	/**
	 * 系统用户session保存名称
	 */
	public static final String CURRENT_USER = "user";
	public static final String CURRENT_EMP = "emp";
	public static final String CURRENT_MENUS = "menus";
	public static final String CURRENT_ROLES = "roles";
	public static final String CURRENT_ORGS = "orgs";
	public static final String CURRENT_ORG_CODES = "orgCodes";
	public static final String CURRENT_TOKEN = "token";

	/**
	 * quartz相关数据对象字段定义
	 */
	public static final String QUARTZ_SCHEDULER_BEAN_NAME = "quartzScheduler";
	public static final String JOB_NAME = "jobName";
	public static final String JOB_DESC = "jobDesc";
	public static final String SCHEDULER_ID = "schedulerId";
	public static final String TRIGGER_NAME = "triggerName";
	public static final String TRIGGER_GROUP = "triggerGroup";
	public static final String START_TIME = "startTime";
	public static final String END_TIME = "endTime";
	public static final String REPEAT_COUNT = "repeatCount";
	public static final String REPEAT_INTERVEL = "repeatInterval";
	public static final String PARAM_1 = "param1";
	public static final String PARAM_2 = "param2";

	public static enum MisFireHandling {
		// 利用构造函数传参
		withMisfireHandlingInstructionDoNothing(1), 
		withMisfireHandlingInstructionIgnoreMisfires(2), 
		withMisfireHandlingInstructionFireAndProceed(3),
		withMisfireHandlingInstructionFireNow(4),
		withMisfireHandlingInstructionNextWithExistingCount(5),
		withMisfireHandlingInstructionNowWithExistingCount(6),
		withMisfireHandlingInstructionNextWithRemainingCount(7),
		withMisfireHandlingInstructionNowWithRemainingCount(8);

		// 定义私有变量
		private int code;

		// 构造函数，枚举类型只能为私有
		private MisFireHandling(int code) {
			this.setCode(code);
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

	}
	
//	/**
//     * 正常数据
//     */
//    public static final String STATUS_NORMAL = "1";
//
//    /**
//     * 已删除数据
//     */
//    public static final String STATUS_DELETE = "0";
//    
//	/**
//     * 有效数据
//     */
//    public static final String STATUS_VALID = "1";
//    
//    /**
//     * 无效数据
//     */
//    public static final String STATUS_INVALID = "0";
    
    /**
     * 启用
     */
    public static final String STATUS_ENABLED = "1";

    /**
     * 禁用
     */
    public static final String STATUS_DISABLED = "0";
    
    /*组织*/
    /**
     * 组织类型：公司
     */
    public static final String ORGANIZATION_TYPE_COMPANY = "01";
    /**
     * 组织类型：部门
     */
    public static final String ORGANIZATION_TYPE_DEPT = "02";
    
    /**
     * 防止查询IN函数报错最大记录数
     */
    public static final int TREE_QUERY_CODE_IN_MAX_COUNT = 1000;
    
    /**
     * 树节点搜索高亮颜色
     */
    public static final String TREE_NODE_HIGH_LIGHT_COLOR_KEY = "color";
    public static final String TREE_NODE_HIGH_LIGHT_COLOR_VALUE = "red";
    
    /**
     * 用户类型：内部用户
     */
    public static final String USER_TYPE_INTERNAL = "01";
    
    /**
     * 用户类型：外部用户
     */
    public static final String USER_TYPE_EXTERNAL = "02";
    
    /**
     * 
     * 外部用户账号前缀
     */
    public static final String EXTERNAL_USER_ACCT_PREFIX = "mdm-";
    
    public static final String SEQUENCE_NAME_EXTERNAL_USER_EMP_CODE = "SEQ_EXTERNAL_USER_EMP_CODE";
    
}
