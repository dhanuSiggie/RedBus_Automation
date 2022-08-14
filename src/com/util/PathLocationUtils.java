//$Id$
package com.util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathLocationUtils {
	
	  private static final String CLASSNAME=PathLocationUtils.class.getName();
	  private static Logger logger = LogManager.getLogger(CLASSNAME);
	  
	  
	  public static String getCommonPropFile() {
		  return "Location of Common Properties";
	  }

}
