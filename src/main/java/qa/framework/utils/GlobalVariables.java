package qa.framework.utils;

import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;

public class GlobalVariables {
public static String browserName;
public static String driverName;
public static int waitTime=30;
public static String applicationName;
public static PropertyFileUtils configProp=null;
public static String applicationUrl=null;

public static ExtentReportManager extentReportManagerObj;
public static ExtentReports extentReport;
public static String portfolioName;
public static String selectedTitle;
public static String firstName;
public static String lastName;
public static String preferredName;
public static String color = "#0000CD";
public static String im;
public static String ima;
public static List<String> list = new ArrayList<String>();
}
	