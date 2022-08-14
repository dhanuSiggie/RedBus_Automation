//$Id$
package com.automationvo;

import java.util.Properties;
import java.util.Set;

public class InputVO {

	private String userName;
	private String baseURL;



	public String getBaseURL() {
		return baseURL;
	}


	public InputVO setBaseURL(String baseURL) {
		this.baseURL = baseURL;
		return this;
	}


	public String getTitle() {
		return userName;
	}


	public InputVO setUserName(String userName) {
		this.userName = userName;
		return this;
	}


	public static InputVO getInputVO(Properties props) {
		InputVO inputVO=new InputVO();
		Set<String> propertyNames=props.stringPropertyNames();
		for(String propField:propertyNames) {
			String propVal=props.getProperty(propField);
			if(propField.contains("input_baseURL")) {
				inputVO.setBaseURL(propVal);
			}
		}
		return inputVO;

	}
}
