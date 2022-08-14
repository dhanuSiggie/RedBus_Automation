//$Id$
package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automationvo.CasesVO;
import com.automationvo.CasesVOImpl;


public class CommonUtil {
	private static final String CLASSNAME=CommonUtil.class.getName();
	private static Logger logger = LogManager.getLogger(CLASSNAME);

	public static void loadProperties(String propFilePath) {
		final String mName = "loadProperties";
		logger.info(addClassNameAndMNameInLog(CLASSNAME, mName)+ "propFilePath >>"+ propFilePath);
		try {
			Properties props = new Properties();
			props.load(new FileInputStream(propFilePath));
			Set<String> propertyNames = props.stringPropertyNames();
			for (String propertyName : propertyNames) {
				System.setProperty(propertyName, props.getProperty(propertyName));
			}
		} catch (Exception ex) {
			logger.info(addClassNameAndMNameInLog(CLASSNAME, mName)+ "Exception Occured >>"+ex.getMessage());
		}
	}
	public static List<Properties> setProperties(String filePath) {
		List<Properties> propList = new ArrayList<Properties>();
		BufferedReader br = null;
		try {
			File file = new File(filePath);
			br = new BufferedReader(new FileReader(file));
			String str = null;
			Properties prop = new Properties();
			while ((str = br.readLine()) != null) {
				if (str.isEmpty()) {           
					propList.add(prop);                   
					prop = new Properties();
					continue;
				}
				if(str.contains("="))
				{
					String[] strArr = str.split("=",2);
					prop.setProperty(strArr[0], strArr[1]);
				}
			}
			propList.add(prop);
		} catch (Exception e2) {
			e2.printStackTrace();
			logger.info("Error while loading file " + filePath);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return propList;
	}

	public static String addClassNameAndMNameInLog(String className,String mName) {
		return className +", " + className + ", ";
	}
	public static List<CasesVO> getCasesVO(String filePath) {
		List<CasesVO> casesVO=new ArrayList<CasesVO>();
		List<Properties> casesProps=setProperties(filePath);
		for (Properties prop:casesProps) {
			String useCaseID=(String) prop.remove("useCaseID");
			String description=(String) prop.remove("description");
			Properties props=prop;
			CasesVO useCase=new CasesVOImpl()
					.setUseCaseId(useCaseID)
					.setDescription(description)
					.setProps(props)
					.build();
			casesVO.add(useCase);

		}
		return casesVO;		
	}

}
