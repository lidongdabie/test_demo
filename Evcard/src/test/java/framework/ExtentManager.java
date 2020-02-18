package framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Created by jinwei on 2018/5/21.
 */
public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance(String filePath) {
        if (extent == null)
            createInstance(filePath);
        return extent;
    }


    public static void createInstance(String filePath) {
        extent = new ExtentReports();
        extent.attachReporter();
//        extent.setSystemInfo("os", "Linux");
        //关联extentx服务端
        extent.attachReporter(createHtmlReporter(filePath));
      //  <!--extent.attachReporter(createHtmlReporter(filePath), createExtentXReporter());-->
                //关联klov服务端
              //  extent.attachReporter(createHtmlReporter(filePath), createKlovReporter());
    }

    public static ExtentHtmlReporter createHtmlReporter(String filePath){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
        //报表位置
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        //使报表上的图表可见
        htmlReporter.config().setDocumentTitle("ExtentReports");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setFilePath(filePath);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Evcard接口自动化测试报告");
//      如果cdn.rawgit.com访问不了，可以设置为：ResourceCDN.EXTENTREPORTS或者ResourceCDN.GITHUB
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
//      htmlReporter.views().dashboard().setSection("Sample", SectionSize.S4, header, list); pro-only
        return htmlReporter;
    }

/*    public static ExtentXReporter createExtentXReporter() {
        ExtentXReporter extentx = new ExtentXReporter("127.0.0.1",27017);
        extentx.config().setProjectName("PlatClientTest");
        extentx.config().setReportName("PlatClientTest Reports");
        extentx.config().setServerUrl("http://localhost:1337");
        return extentx;
    }*/

  /*  public static KlovReporter createKlovReporter() {
        KlovReporter klov = new KlovReporter();
        klov.initMongoDbConnection("localhost", 27017);
        klov.setKlovUrl("http://localhost:80");
        klov.setProjectName("PlatClientTest");
        klov.setReportName("buildName");
        return klov;
    }*/
}
