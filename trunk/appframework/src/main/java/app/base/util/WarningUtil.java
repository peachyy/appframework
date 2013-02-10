package app.base.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报警工具类
 * 
 * @author zhujinju
 * 
 */
public class WarningUtil {

	private static final Logger log = LoggerFactory.getLogger(WarningUtil.class);

	// 节点状态警告
	public static final int WARN_TYPE_NODE_STATUS = 1;

	public static void sentWarnInfo(String info, int warnType) {
		log.error("warn info : " + info);
	}

}
