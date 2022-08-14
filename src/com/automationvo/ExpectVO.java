//$Id$
package com.automationvo;

import java.util.Properties;
import java.util.Set;

public class ExpectVO {

	private String title;

	public String getTitle() {
		return title;
	}

	public ExpectVO setTitle(String title) {
		this.title = title;
		return this;
	}

	public static ExpectVO getExpectVO(Properties prop) {
		ExpectVO expectVO=new ExpectVO();

		Set<String> propertyNames=prop.stringPropertyNames();

		for(String propField:propertyNames) {

			String propVal=prop.getProperty(propField);

			if(propField.contains("expect_title")) {
				expectVO.setTitle(propVal);
			}
		}
		return expectVO;
	}

}
