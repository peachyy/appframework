package app.base.spring.helper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.simple.SimpleJdbcOperations;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 从 ServletContext 获取spring相关
 * 
 * @author zhaidw
 * 
 */
public class SpringHelper {

	/**
	 * 从 ServletContext 获取 ApplicationContext
	 * @param request
	 * @return
	 */
	public static ApplicationContext getApplicationContext(HttpServletRequest request) {

		ServletContext servletContext = request.getSession().getServletContext();
		
		// java.lang.IllegalStateException: BeanFactory not initialized or
		// already closed -
		// call 'refresh' before accessing beans via the ApplicationContext
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);

		return context;

	}

	/**
	 * 获取操作数据的 SimpleJdbcOperations
	 * 
	 * @param request
	 * @return
	 */
	public static SimpleJdbcOperations getSimpleJdbcTemplate(
			HttpServletRequest request) {

		SimpleJdbcOperations template = getApplicationContext(request).getBean("simpleJdbcTemplate", SimpleJdbcOperations.class);

		return template;
	}

	/**
	 * 获取操作数据的 指定ID 的 SimpleJdbcOperations
	 * 
	 * @param request
	 * @return
	 */
	public static SimpleJdbcOperations getSimpleJdbcTemplate(
			HttpServletRequest request, String beanId) {

		SimpleJdbcOperations template = getApplicationContext(request).getBean(beanId,
				SimpleJdbcOperations.class);

		return template;
	}

}
