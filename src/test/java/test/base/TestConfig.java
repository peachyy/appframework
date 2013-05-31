package test.base;

import org.jiucai.appframework.base.util.ConfigUtil;

public class TestConfig {

	public static void main(String[] args) {
		ConfigUtil.addConfig("config");
		String value = ConfigUtil.getString("common.app.env.timestamp");
		
		System.out.println(value);
	}
}
