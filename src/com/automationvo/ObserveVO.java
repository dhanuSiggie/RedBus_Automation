//$Id$
package com.automationvo;

import java.util.Properties;
import java.util.Set;

public class ObserveVO {

	private boolean title;

	public boolean getTitle() {
		return title;
	}

	public ObserveVO setTitle(boolean title) {
		this.title = title;
		return this;
	}

	public static ObserveVO getObserveVO(Properties prop) {
		ObserveVO observeVO=new ObserveVO();

		Set<String> propertyNames=prop.stringPropertyNames();

		for(String propField:propertyNames) {

			String propVal=prop.getProperty(propField);
			if(propField.contains("observe_title")) {
				observeVO.setTitle(Boolean.parseBoolean(propVal));
			}
		}
		return observeVO;
	}
}
