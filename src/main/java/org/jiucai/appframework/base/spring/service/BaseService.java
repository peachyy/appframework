package org.jiucai.appframework.base.spring.service;

import org.jiucai.appframework.common.util.LogUtil;
import org.jiucai.appframework.common.util.Logs;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 业务层基础类，提供 TransactionTemplate 允许在业务层使用编程式事务控制
 * 
 * @author zhaidw
 * 
 */
public abstract class BaseService {
	protected Logs log = LogUtil.getLog(getClass());

	protected TransactionTemplate transactionTemplate;

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public abstract void setTransactionTemplate(TransactionTemplate transactionTemplate);

}
