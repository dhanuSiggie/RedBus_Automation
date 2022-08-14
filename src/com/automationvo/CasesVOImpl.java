//$Id$
package com.automationvo;

import java.util.Properties;

public class CasesVOImpl implements CasesVO{

	private String useCaseId;
	private String description;
	private Properties props;

	@Override
	public String getUseCaseID() {
		return useCaseId;
	}
	@Override
	public Properties getProperties() {
		return props;
	}

	public String getDescription() {
		return description;
	}

	public CasesVOImpl setUseCaseId(String useCaseId) {
		this.useCaseId = useCaseId;
		return this;
	}
	public CasesVOImpl setDescription(String description) {
		this.description = description;
		return this;
	}
	public CasesVOImpl setProps(Properties props) {
		this.props = props;
		return this;
	}
	
	public CasesVO build() {
		return this;
	}


}
