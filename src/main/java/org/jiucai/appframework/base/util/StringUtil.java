package org.jiucai.appframework.base.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理类
 * @author dingning
 *
 */
public class StringUtil{
	
	/**
	 * 判断字符串是否为数字
	 * @param str
	 * @return Boolean
	 */
	public static Boolean isNumber(String str){
		if(str == null){
			return false;
		}
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher match = pattern.matcher(str.trim());
        if(match.matches() == false){
        	return false;
        }else{
            return true;
        }
    }
	
	/**
	 * 转义正则特殊符号
	 * @param searchStr
	 * @return String
	 */
	public static String chuanyiPipei(String searchStr){
		String[] reg={"*","^","$",".","?","+","(",")","[","]","{","}","<",">","|"};
		for(int i=0;i<reg.length;i++){
			searchStr =searchStr.replace(reg[i],"\\"+reg[i] );
		}
		
		return searchStr;
	}
	
}