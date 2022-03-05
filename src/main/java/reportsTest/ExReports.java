package reportsTest;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExReports {
	
	static ExtentReports er;
	
	
	public static ExtentReports reports() {
		
		
		String path=System.getProperty("user.dir")+"\\reports\\index1.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(path);
		
		esr.config().setReportName("WEB Report");
		esr.config().setDocumentTitle("Test Results");
		
		
		er= new ExtentReports();
		er.attachReporter(esr);
	    er.setSystemInfo("Tester", "Shohom");
	    
	    return er;
	}

}
