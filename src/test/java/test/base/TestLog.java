package test.base;

import org.jiucai.appframework.common.util.LogUtil;
import org.jiucai.appframework.common.util.Logs;

public class TestLog {

	protected static Logs logger = LogUtil.getLog(TestLog.class);

	protected Logs log = LogUtil.getLog(getClass());

	public void testLog() {
		log.info("method testLog.");
	}

	public static void testLogger() {
		logger.info("method testLogger.");
	}

	public static void main(String[] args) {

		testLogger();

		TestLog t1 = new TestLog();

		t1.testLog();
	}

}
