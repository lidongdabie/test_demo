package com.core;

/**
 * @author jin wei
 */
public class BaseURL {

	public String env;
    public String env_1;


	public BaseURL() {
        this.env = Common.setTestConfigFromPropertyFile();
        this.env_1 = Common.setTestConfigFromPropertyFile();
	}

}
