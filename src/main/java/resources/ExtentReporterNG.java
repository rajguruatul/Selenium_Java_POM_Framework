package resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	static ExtentReports extentreport;

	public static ExtentReports getExtentReport()
	{
		String path = System.getProperty("user.dir")+"\\reports\\AutomationReport_"+System.currentTimeMillis()+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Reportname : Automation Results");
		reporter.config().setDocumentTitle("Document Title : Test Results");
		
		extentreport = new ExtentReports();
		extentreport.attachReporter(reporter);
		extentreport.setSystemInfo("QA Head", "Atul Rajguru");
		
		return extentreport;
		
	}
}
