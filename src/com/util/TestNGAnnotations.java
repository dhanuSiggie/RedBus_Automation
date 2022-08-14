//$Id$
package com.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class TestNGAnnotations {
    private static final String CLASSNAME=TestNGAnnotations.class.getName();

	private static Logger logger = LogManager.getLogger(CLASSNAME);
	
	@BeforeClass
    public void setUpBeforeClass() throws Exception {
		final String mName="setUpBeforeClass";
        try {
        	//Use this if you need to set any Common Properties as System Property
        	CommonUtil.loadProperties(PathLocationUtils.getCommonPropFile());
        	
        } catch (Exception ex) {
            logger.info(CommonUtil.addClassNameAndMNameInLog(CLASSNAME, mName)+ "Exception Occured >>"+ex.getMessage());
        }
    }
}
