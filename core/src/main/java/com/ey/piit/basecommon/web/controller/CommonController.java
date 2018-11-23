package com.ey.piit.basecommon.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.basesys.para.service.ParaConfigService;
import com.ey.piit.basesys.para.vo.ParaConfigVo;
import com.ey.piit.core.utils.HttpUtils;
import com.ey.piit.core.web.controller.base.BaseController;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 
 * @author Kevin-Y.Xu
 *
 */
@Controller
@RequestMapping("/base/common")
public class CommonController extends BaseController{
	
	@Autowired
	private ParaConfigService paraConfigService;

	@RequestMapping(value = "/selectName", method = RequestMethod.POST)
	@ResponseBody
	public ObjectNode selectName(String type,String code) {
		ObjectNode objectNode = jacksonObjectMapper.createObjectNode();
		StringBuilder sb = new StringBuilder();
		sb.append("<option value=\"\">&nbsp;</option>");
		sb.append("<option value=\"AL\">Alabama</option>");
		sb.append("<option value=\"AK\">Alaska</option>");
		sb.append("<option value=\"AZ\">Arizona</option>");
		sb.append("<option value=\"AR\">Arkansas</option>");
		sb.append("<option value=\"CA\">California</option>");
		sb.append("<option value=\"CO\">Colorado</option>");
		sb.append("<option value=\"CT\">Connecticut</option>");
		sb.append("<option value=\"DE\">Delaware</option>");
		sb.append("<option value=\"FL\">Florida</option>");
		sb.append("<option value=\"GA\">Georgia</option>");
		sb.append("<option value=\"HI\">Hawaii</option>");
		sb.append("<option value=\"ID\">Idaho</option>");
		sb.append("<option value=\"IL\">Illinois</option>");
		sb.append("<option value=\"IN\">Indiana</option>");
		sb.append("<option value=\"IA\">Iowa</option>");
		sb.append("<option value=\"KS\">Kansas</option>");
		sb.append("<option value=\"KY\">Kentucky</option>");
		sb.append("<option value=\"LA\">Louisiana</option>");
		sb.append("<option value=\"ME\">Maine</option>");
		sb.append("<option value=\"MD\">Maryland</option>");
		sb.append("<option value=\"MA\">Massachusetts</option>");
		sb.append("<option value=\"MI\">Michigan</option>");
		sb.append("<option value=\"MN\">Minnesota</option>");
		sb.append("<option value=\"MS\">Mississippi</option>");
		sb.append("<option value=\"MO\">Missouri</option>");
		sb.append("<option value=\"MT\">Montana</option>");
		sb.append("<option value=\"NE\">Nebraska</option>");
		sb.append("<option value=\"NV\">Nevada</option>");
		sb.append("<option value=\"NH\">New Hampshire</option>");
		sb.append("<option value=\"NJ\">New Jersey</option>");
		sb.append("<option value=\"NM\">New Mexico</option>");
		sb.append("<option value=\"NY\">New York</option>");
		sb.append("<option value=\"NC\">North Carolina</option>");
		sb.append("<option value=\"ND\">North Dakota</option>");
		sb.append("<option value=\"OH\">Ohio</option>");
		sb.append("<option value=\"OK\">Oklahoma</option>");
		sb.append("<option value=\"OR\">Oregon</option>");
		sb.append("<option value=\"PA\">Pennsylvania</option>");
		sb.append("<option value=\"RI\">Rhode Island</option>");
		sb.append("<option value=\"SC\">South Carolina</option>");
		sb.append("<option value=\"SD\">South Dakota</option>");
		sb.append("<option value=\"TN\">Tennessee</option>");
		sb.append("<option value=\"TX\">Texas</option>");
		sb.append("<option value=\"UT\">Utah</option>");
		sb.append("<option value=\"VT\">Vermont</option>");
		sb.append("<option value=\"VA\">Virginia</option>");
		sb.append("<option value=\"WA\">Washington</option>");
		sb.append("<option value=\"WV\">West Virginia</option>");
		sb.append("<option value=\"WI\">Wisconsin</option>");
		sb.append("<option value=\"WY\">Wyoming</option>");
		objectNode.putObject(sb.toString());
		return objectNode;
	}
	
	@RequestMapping(value = "/autoName", method = RequestMethod.GET)
	@ResponseBody
	public ArrayNode autoName(String term) {
		ArrayNode arrayNode = jacksonObjectMapper.createArrayNode();
		arrayNode.add("ActionScript");
		arrayNode.add("AppleScript");
		arrayNode.add("Asp");
		arrayNode.add("BASIC");
		arrayNode.add("C");
		arrayNode.add("C++");
		arrayNode.add("Clojure");
		arrayNode.add("COBOL");
		arrayNode.add("ColdFusion");
		arrayNode.add("Erlang");
		arrayNode.add("Fortran");
		arrayNode.add("Groovy");
		arrayNode.add("Haskell");
		arrayNode.add("Java");
		arrayNode.add("JavaScript");
		arrayNode.add("Lisp");
		arrayNode.add("Perl");
		arrayNode.add("PHP");
		arrayNode.add("Python");
		arrayNode.add("Ruby");
		arrayNode.add("Scala");
		arrayNode.add("Scheme");
		return arrayNode;
	}
	
	/**
	 * 刷新缓存（对外）
	 * @return
	 */
	@RequestMapping(value = "/refreshCache")
	@ResponseBody
	public Object refreshCache(String type){
		//获得各服务器请求地址
		ParaConfigVo paraConfig = paraConfigService.findByKey("SERVER_ADDRESS");
		String addressArr = paraConfig.getValue();
		String[] split = addressArr.split(",");
		for (int i = 0; i < split.length; i++) {
			String address = split[i];
			HttpUtils.postRequest(address + "/base/common/clearCache", "type="+type);
		}
		return "OK";
	}
	
}
