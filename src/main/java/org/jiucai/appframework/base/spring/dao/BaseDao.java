package org.jiucai.appframework.base.spring.dao;

import org.jiucai.appframework.common.util.LogUtil;
import org.jiucai.appframework.common.util.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcOperations;

public class BaseDao {

	protected Logs log = LogUtil.getLog(getClass());

	@Autowired
	private JdbcOperations jdbcTemplate;

	@Autowired
	private SimpleJdbcOperations simpleJdbcTemplate;

	/**
	 * @see JdbcTemplate
	 * @see org.springframework.jdbc.core.JdbcOperations
	 * 从 Spring 3.1 JdbcTemplate 和 NamedParameterJdbcTemplate 包含了 SimpleJdbcTemplate 的所有功能，但还不完善，不能完全替代
	 */
	public SimpleJdbcOperations getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	/**
	 * @see JdbcTemplate
	 * @see org.springframework.jdbc.core.JdbcOperations
	 * 从 Spring 3.1 JdbcTemplate 和 NamedParameterJdbcTemplate 包含了 SimpleJdbcTemplate 的所有功能，但还不完善，不能完全替代
	 */
	public void setSimpleJdbcTemplate(SimpleJdbcOperations simpleJdbcTemplate) {
		this.simpleJdbcTemplate = simpleJdbcTemplate;
		log.info(" simpleJdbcOperations injected.");
	}

	public JdbcOperations getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		log.info(" jdbcTemplate injected.");
	}

	/**
	 * 获取Oracle序列值
	 * 
	 * @param seqName
	 *            序列表名
	 * @return 序列值
	 */
	protected Long getId(String seqName) {
		String sql = "select  " + seqName + ".nextval from dual ";
		return getJdbcTemplate().queryForLong(sql);
	}

}
