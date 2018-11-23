package com.ey.piit.basebpm.common;

public class Constants {

    public static final String NOT_FOUND_EXCEPTION = "此任务已经被提交";
    
    /**
     * 业务主键
     */
    public static final String VAR_KEY_ID = "id";
    
    /**
     * 编码
     */
    public static final String VAR_KEY_CODE = "code";
    
    /**
     * 主数据类型
     */
    public static final String VAR_KEY_TYPE = "type";
    
    /**
     * 实体名称
     */
    public static final String VAR_KEY_NAME = "name";
    
    /**
     * 流程名称
     */
    public static final String VAR_KEY_PROCESS_NAME = "processName";
    
    /**
     * 流程类型
     */
    public static final String VAR_KEY_PROCESS_TYPE = "processType";
    
    /**
     * 流程发起人
     */
    public static final String VAR_KEY_APPLY_USER = "applyUser";
    
    /**
     * 流程发起时间
     */
    public static final String VAR_KEY_APPLY_TIME = "applyTime";
    
    /**
     * 批注
     */
    public static final String VAR_KEY_COMMENT = "comment";
    
    /**
     * 批注类型
     */
    public static final String VAR_KEY_COMMENT_TYPE = "commentType";
    
    /**
     * 批注类型：申请
     */
    public static final String VAR_KEY_COMMENT_TYPE_APPLY = "apply";
    
    /**
     * 批注类型：审批
     */
    public static final String VAR_KEY_COMMENT_TYPE_APPROVE = "approve";
    
    /**
     * 审批类型：同意
     */
    public static final String VAR_KEY_APPROVE_TYPE_AGREE = "agree";
    
    /**
     * 审批类型：不同意
     */
    public static final String VAR_KEY_APPROVE_TYPE_DISAGREE = "disagree";
    
    /**
     * 审批类型：驳回
     */
    public static final String VAR_KEY_APPROVE_TYPE_REJECT = "reject";
    
    /**
     * 审批类型：关闭
     */
    public static final String VAR_KEY_APPROVE_TYPE_CLOSE = "close";
    
    /**
     * 线条件变量
     */
    public static final String VAR_KEY_LINE_OUT = "out";
    
    /**
     * 历史查询：操作类型
     */
    public static final String HIS_SEARCH_KEY_OPER = "oper";
    
    /**
     * 历史查询：操作类型值：流程发起
     */
    public static final String HIS_SEARCH_KEY_OPER_START = "start";
    
    /**
     * 历史查询：操作类型值：流程参与
     */
    public static final String HIS_SEARCH_KEY_OPER_PART = "part";
    
    /**
     * 历史查询：流程状态
     */
    public static final String HIS_SEARCH_KEY_STATUS = "status";
    
    /**
     * 历史查询：流程状态：正在运行
     */
    public static final String HIS_SEARCH_KEY_STATUS_RUN = "run";
    
    /**
     * 历史查询：流程状态：已完成
     */
    public static final String HIS_SEARCH_KEY_STATUS_FINISH = "finish";
    
    /**
     * 历史查询：编码
     */
    public static final String HIS_SEARCH_KEY_CODE = "code";
    
    /**
     * 历史查询：主数据类型
     */
    public static final String HIS_SEARCH_KEY_TYPE = "type";
    
    /**
     * 历史查询：实体名称
     */
    public static final String HIS_SEARCH_KEY_NAME = "name";
    
    /**
     * 历史查询：流程发起人
     */
    public static final String HIS_SEARCH_KEY_APPLY_USER = "applyUser";
    
    /**
     * 历史查询：流程参与人
     */
    public static final String HIS_SEARCH_KEY_PART_USER = "partUser";
    
    /**
     * 任务名称
     */
    public static final String VAR_KEY_TASK_NAME = "taskName";
    
    /**
     * url地址
     */
    public static final String VAR_KEY_FORM_KEY = "formKey";
    
    /**
     * 驳回节点ID，用于驳回后再提交时直接提交到此节点
     */
    public static final String VAR_KEY_JUMP_ACTIVITY_ID = "jumpActivityId";
    
    /**
     * 驳回节点IDs，用于保存驳回时被删除的Task
     */
    public static final String VAR_KEY_DEL_ACTIVITY_IDS = "delActivityIds";
    
    /**
     * 用于重新提交时选择路径节点
     */
    public static final String VAR_KEY_SEL_ACTIVITY_IDS = "selActivityIds";
    
    /**
     * 用于重新提交时选择路径节点，继续
     */
    public static final String VAR_KEY_REJECT_SEL_CONTINUE = "continue";
    
    /**
     * 用于重新提交时选择路径节点，重新开始
     */
    public static final String VAR_KEY_REJECT_SEL_RESTART = "restart";
    
    /**
     * 申请节点ID
     */
    public static final String VAR_KEY_APPLY_NODE = "applyNode";
    
}
