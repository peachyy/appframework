package org.jiucai.appframework.base.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.jiucai.appframework.base.domain.KeyValuePair;
import org.jiucai.appframework.common.util.BaseUtil;

import com.csvreader.CsvWriter;

public class CsvDownloadUtil extends BaseUtil {

	 static String fileCharset = "GBK";
	
	/**
	 * 
	 * @param filePath 输出文件路径
	 * @param headList 表头列表
	 * @param dataList 数据列表
	 * @param sumList 总计列表
	 * @param isAppend 是否文件追加数据
	 * @return 生成的文件全路径
	 * @author zhangyadong
	 */
	public static final String saveFile(String filePath,String fileName ,List<KeyValuePair> headList,
			List<Map<String,Object>> dataList, List<Map<String,Object>> sumList, Boolean isAppend) {
		
		//默认存储空间地址
		if(StringUtils.isEmpty(filePath)){
			filePath = "/tmp/report";
			log.info("use default download path:  " + filePath );
		}
		if(!filePath.endsWith("/")){
			filePath += "/";
		}
		
		if(!fileName.endsWith(".csv")){
			fileName+=".csv";
		}
		
		//用于创建没有的文件夹
		final	String  createFilePath =filePath;
		
		//生成文件名称
		filePath += fileName;
		try {
			
			File  file = new File(createFilePath);
			//判断文件夹是否存在
			if(!file.isDirectory()){
				file.mkdirs();
			}
			
			OutputStream	out = new FileOutputStream(filePath,
					isAppend); // 是否追加
			CsvWriter wr = new CsvWriter(out, ',',Charset.forName(fileCharset));
			wr.setForceQualifier(true);
			
			//添加表头信息
			if(CollectionUtils.isNotEmpty(headList)&&!isAppend){
				List<String> headNamesList = new ArrayList<String>();
				for(KeyValuePair kvp : headList){
					headNamesList.add(convertMapValue(kvp.getText()));
				}
				
				//防止生成sylk文件时，首行内容出现ID字符而导致文件无法打开问题
				for(int i=0;i<headNamesList.size();i++){
					headNamesList.set(i, headNamesList.get(i));
				}
				String[] data =  headNamesList.toArray(new String[headNamesList.size()]);
				wr.writeRecord(data);
			}
			
			//添加总计信息
			if(CollectionUtils.isNotEmpty(sumList)&&!isAppend){
				List<List<String>> datas = accountDataBody(headList, sumList);
				List<String>[] data = datas.toArray(new ArrayList[datas.size()]);
				for(List<String> da : data){
					for(int i=0;i<da.size();i++){
						da.set(i, convertMapValue(da.get(i)));
					}
					String[] endDa = (String[]) da.toArray(new String[da.size()]);
					wr.writeRecord(endDa);
				}
			}
			
			//添加列表数据信息
			if(CollectionUtils.isNotEmpty(dataList)){
				List<List<String>> datas = accountDataBody(headList, dataList);
				List<String>[] data = datas.toArray(new ArrayList[datas.size()]);
				for(List<String> da : data){
					for(int i=0;i<da.size();i++){
						da.set(i, convertMapValue(da.get(i)));
					}
					String[] endDa = (String[]) da.toArray(new String[da.size()]);
					wr.writeRecord(endDa);
				}
			}
			wr.close();
			out.close();
		} catch (FileNotFoundException e) {
			log.info("文件不存在:"+filePath+e.getMessage());
		} catch (IOException e) {
			log.info("下载文件异常:"+e.getMessage());
		}
		return filePath;
	}
	
	/**
	 * @param displayName
	 * @return
	 */
	public static String getFileName(String displayName){
		//显示下载文件名称
		String displayFileName = displayName;
		SimpleDateFormat  df = new SimpleDateFormat("MMddHHmmss");
		String   dateStr  = df.format(new Date());
		displayFileName += "_"+dateStr;
		
		//如果现实名称为空 则使用fileName
		if(!displayFileName.endsWith(".csv")){
			displayFileName+=".csv";
		}
		return displayFileName;
	};
	
	/**
	 * 
	 * @author：耿志新
	 * @Description：根据用户所选表头进行筛选
	 *
	 */
	private static List<List<String>> accountDataBody(List<KeyValuePair> headList,List<Map<String,Object>> dataList){
		
		List<List<String>> dataBody = new ArrayList<List<String>>();
		List<String> data = null;
		
		List<String> headCode = new ArrayList<String>();
		
		if(null != headList){
			for(KeyValuePair kvp : headList){
				headCode.add(kvp.getCode().toLowerCase());
			}
		}
		
		for(Map<String,Object> map : dataList){
			data = new ArrayList<String>();
			for(String code : headCode){
				data.add(String.valueOf(map.get(code)));
			}
			dataBody.add(data);
		}
		
		return dataBody;
	}
}
