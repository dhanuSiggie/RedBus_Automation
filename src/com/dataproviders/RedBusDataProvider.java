//$Id$
package com.dataproviders;


import java.lang.reflect.Method;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

import com.automationvo.CasesVO;
import com.automationvo.ExpectVO;
import com.automationvo.InputVO;
import com.util.CommonUtil;

public class RedBusDataProvider {

	private static final String CLASSNAME=RedBusDataProvider.class.getName();
	private static Logger logger = LogManager.getLogger(CLASSNAME);

	@DataProvider(name = "data")
	public static Object[][] getData(Method method) throws Exception {
		final String mName = "getData";
		Object[][] obj = null;
		String methodName = method.getName();
		logger.info(CommonUtil.addClassNameAndMNameInLog(CLASSNAME, mName)+"Method Entered into Data Provider >> " +methodName);
		String proPath =setPropertyFile(methodName);
		List<CasesVO> casesVOS = CommonUtil.getCasesVO(proPath);
		if (methodName.contains("verify")){
			obj = new Object[casesVOS.size()][3];
			for (int i = 0; i < casesVOS.size(); i++) {
				CasesVO caseVO = casesVOS.get(i);
				obj[i][0] = caseVO;
				InputVO inputVO = InputVO.getInputVO(caseVO.getProperties());
				ExpectVO expectVO=ExpectVO.getExpectVO(caseVO.getProperties());
				obj[i][1] = inputVO;
				obj[i][2]=expectVO;
//				ObserveVO observeVO=ObserveVO.getObserveVO(caseVO.getProperties());
//				obj[i][3]=observeVO;
			}
		}else {
			logger.info(CommonUtil.addClassNameAndMNameInLog(CLASSNAME, mName)+"No Data  is Configured for this Method" +methodName);
		}
		return obj; 
	}

		private static String setPropertyFile(String methodName) {
			String prop="";
			if(methodName.contains("verify")) {
				prop="Location of Properties which can be used as Input for the Test Cases";
			}
			return prop;
		}
	}
