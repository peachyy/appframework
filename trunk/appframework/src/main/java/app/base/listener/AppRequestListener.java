package app.base.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import app.base.util.AppHolder;
import app.common.util.LogUtil;
import app.common.util.Logs;

/***
 * 请求监听器，把 request 对象放在静态类中供java类调用
 * 
 * @author zhaidw
 * 
 */
public class AppRequestListener implements ServletRequestListener {

	protected Logs log = LogUtil.getLog(getClass());

	public AppRequestListener() {
		super();
		log.info("AppRequestListener inited.");

	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {

		HttpServletRequest request = (HttpServletRequest) event
				.getServletRequest();

		AppHolder.setRequest(request);

	}

	@Override
	public void requestDestroyed(ServletRequestEvent event) {

		AppHolder.getRequestHolder().remove();

	}

}
