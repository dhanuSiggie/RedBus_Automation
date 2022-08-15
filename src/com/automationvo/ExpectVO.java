//$Id$
package com.automationvo;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.util.CommonUtil;

public class ExpectVO {

	private String title;
	private List <String> manageDdValues;


	public List<String> getManageDdValues() {
		return manageDdValues;
	}

	public ExpectVO setManageDdValues(List<String> manageDdValues) {
		this.manageDdValues = manageDdValues;
		return this;
	}

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
			}else if(propField.contains("expect_manageDropDownValues")) {
				expectVO.setManageDdValues(CommonUtil.convertTOList(propVal));
			}
		}
		return expectVO;
	}

}
