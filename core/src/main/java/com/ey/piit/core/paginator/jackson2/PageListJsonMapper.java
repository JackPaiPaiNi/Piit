package com.ey.piit.core.paginator.jackson2;

import java.util.TimeZone;

import com.ey.piit.core.paginator.domain.PageList;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author Yingjie.Wu
 * 
 * @ResponseBody
	@RequestMapping(value = "/findByCity.json")
	public List findByCity(@RequestParam String city,
	                 @RequestParam(required = false,defaultValue = "1") int page,
	                 @RequestParam(required = false,defaultValue = "30") int limit,
	                 @RequestParam(required = false) String sort,
	                 @RequestParam(required = false) String dir) {
	    return userService.findByCity(city, new PageBounds(page, limit, Order.create(sort,dir)));
	}
	
	然后序列化后的JSON字符串就会变成这样的：
{
    "items":[
        {"NAME":"xiaoma","AGE":30,"GENDER":1,"ID":3,"CITY":"BeiJing"},
        {"NAME":"xiaoli","AGE":30,"SCORE":85,"GENDER":1,"ID":1,"CITY":"BeiJing"},
        {"NAME":"xiaowang","AGE":30,"SCORE":92,"GENDER":0,"ID":2,"CITY":"BeiJing"},
        {"NAME":"xiaoshao","AGE":30,"SCORE":99,"GENDER":0,"ID":4,"CITY":"BeiJing"}
    ],
    "slider": [1, 2, 3, 4, 5, 6, 7],
    "hasPrePage": false,
    "startRow": 1,
    "offset": 0,
    "lastPage": false,
    "prePage": 1,
    "hasNextPage": true,
    "nextPage": 2,
    "endRow": 30,
    "totalCount": 40351,
    "firstPage": true,
    "totalPages": 1346,
    "limit": 30,
    "page": 1
}

 */
public class PageListJsonMapper extends ObjectMapper{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5836462294888668169L;

	public PageListJsonMapper() {
    	this.setSerializationInclusion(Include.NON_NULL);
    	
        SimpleModule module = new SimpleModule("PageListJSONModule", new Version(1, 0, 0, null, null, null));
        module.addSerializer(PageList.class, new PageListJsonSerializer(this));
        this.registerModule(module);
        
        // 设置时区
        this.setTimeZone(TimeZone.getDefault());//getTimeZone("GMT+8:00")
    }
}
