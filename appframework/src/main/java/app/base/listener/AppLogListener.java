package app.base.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.impl.Log4jMDCAdapter;
import org.slf4j.spi.MDCAdapter;

import app.base.util.IpUtil;
import app.common.util.LogUtil;
import app.common.util.Logs;

public class AppLogListener implements ServletRequestListener {

	protected MDCAdapter adapter;
	protected Logs log = LogUtil.getLog(getClass());

	public AppLogListener() {
		super();
		log.info("AppLogListener inited.");
		adapter = new Log4jMDCAdapter();
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		HttpServletRequest request = (HttpServletRequest) event
				.getServletRequest();

		String ip = IpUtil.getIp(request);

		adapter.put("ip", ip);

	}

	@Override
	public void requestDestroyed(ServletRequestEvent event) {

		adapter.remove("ip");

	}

}
