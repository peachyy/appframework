package org.jiucai.appframework.base.spring.service;

import java.util.Map;

/**
 * 数据服务接口
 * 
 * 实现类 serviceId 命名规则 xxxDataService
 * 
 * @author zhaidw
 * 
 */
public interface IDataService {
	
	public static final String DATA_TYPE_XML 	= "xml";
	public static final String DATA_TYPE_JSON 	= "json";
	public static final String DATA_TYPE_HTML 	= "html";

	/**
	 * 
	 * @param param  请求参数map，里面包含所有的 request pararamter 参数，多个重名的参数取出后需要转换为List使用
	 * @return 结果数据字符串
	 */
	public abstract String handleRequest(Map<String, Object> param);

	/***
	 * 返回数据 ContentType： html ? xml ? json ? 
	 * 
	 * @return String
	 */
	public abstract String getContentType(Map<String, Object> param);
	
}
