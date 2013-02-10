package app.base.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

import app.common.util.LogUtil;
import app.common.util.Logs;

/**
 * 业务层基础类，提供 TransactionTemplate 允许在业务层使用编程式事务控制
 * @author zhaidw
 *
 */
public class BaseService {
	protected Logs log = LogUtil.getLog(getClass());
	
	@Autowired
	protected TransactionTemplate transactionTemplate;

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
		log.info(" transactionTemplate injected.");
	}
	
}

