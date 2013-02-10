package app.base.spring.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import app.base.domain.PageInfo;
import app.base.util.CommonUtil;
import app.common.util.LogUtil;
import app.common.util.Logs;

/**
 * 控制器的基类
 * 
 * @author zhaidw
 * 
 */
public class BaseController {

	protected Logs log = LogUtil.getLog(getClass());

	/**
	 * 操作成功标识
	 */
	protected static final String SUCCESS = "1";

	/**
	 * 操作失败标识
	 */
	protected static final String FAILED = "0";

	/**
	 * 直接输出时的字符编码
	 */
	protected static final String CHARSET = "UTF-8";

	/**
	 * 请求参数 分页页码
	 */

	public static final String REQ_KEY_PAGE = "p";

	/**
	 * 定义一个标注 @InitBinder 注解的方法，在该方法中向 Controller 了注册若干个属性编辑器 nitBinder
	 * 注解的方法必须拥有一个 WebDataBinder 类型的入参， 以便 Spring MVC 框架将注册属性编辑器的 WebDataBinder
	 * 对象传递进来
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
		binder.registerCustomEditor(String.class,
				new StringTrimmerEditor(false));

	}

	/**
	 * 获取分页信息对象
	 * 
	 * @param resultSize
	 *            总记录数
	 * @param request
	 * @return
	 */
	public PageInfo getPageInfo(Long resultSize, HttpServletRequest request) {
		// 分页信息
		String pageNo = request.getParameter(REQ_KEY_PAGE);
		Long pNo = 1L;
		if (null != pageNo) {
			try {
				pNo = Long.parseLong(pageNo);
			} catch (NumberFormatException e) {
				log.error("Error pageNo value, goto first page: "
						+ e.getMessage());
			}

		}

		Long pageSize = CommonUtil.getPageSize();
		Long pageCount = CommonUtil.getPageCount(resultSize, pageSize);

		PageInfo page = new PageInfo();
		page.setPageNo(pNo);
		page.setResultSize(resultSize);
		page.setPageCount(pageCount);
		page.setPageSize(pageSize);

		return page;
	}

}
