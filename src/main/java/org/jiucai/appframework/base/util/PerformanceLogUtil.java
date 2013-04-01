/**
 * 
 */
package org.jiucai.appframework.base.util;

import java.util.List;

/**
 * PerformanceLogUtil
 * @author wangbo
 * @version 1.0
 */
public class PerformanceLogUtil {
	
	/**
	 * 格式化性能日志
	 * @param moduleName 值：关键词竞价, 关键词报表
	 * @param timeType 计时分类：数据库, 应用, 页面
	 * @param projectId
	 * @param accountList
	 * @param start_time
	 * @param end_time
	 * @param all_time
	 * @return String
	 */
	public static String formatPerformanceLog(String moduleName,String timeType, Long projectId,List<Long> accountList,String start_time,String end_time,Long all_time ){
		//service计时输出开始 by wangbo
		StringBuilder time_log  = new StringBuilder();
		time_log.append(projectId).append(",");//项目ID
		for(int i=0;accountList!=null && i<accountList.size();i++){//帐号ID
			Long accountid = accountList.get(i);
			time_log.append(accountid);
			if(i+1<accountList.size()){
				time_log.append("_");
			}
		}
		time_log.append(",").append(moduleName).append(",");//功能模块
		if( accountList==null ||accountList.size()==0){//查询类型
			time_log.append("项目总计").append(",");
		}else if(accountList.size()>=2){//查询类型
			time_log.append("多账户查询").append(",");			
		}else{
			time_log.append("单账户查询").append(",");
		}
		time_log.append(start_time).append(",");//查询开始日期
		time_log.append(end_time).append(",");//查询结束日期
		time_log.append(timeType).append(",");//计时分类
		time_log.append(all_time).append("ms");//花费时间
		//service计时输出结束 by wangbo
		return time_log.toString();
	}

}
