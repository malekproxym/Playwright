package base;

import com.aventstack.extentreports.*;
import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentManager;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setUp(Method method) {
        // Reporting
        test = extent.createTest(method.getName());

        // Playwright setup
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        // Reporting status
        if(result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());

            String screenshotPath = ScreenshotUtil.takeScreenshot(page, result.getName());

            System.out.println("screenshotPath : "+screenshotPath);
            String projectPath = System.getProperty("user.dir");

            String absoluteScreenshotPath = projectPath+"/"+screenshotPath;
            System.out.println("absoluteScreenshotPath : "+absoluteScreenshotPath);

            test.addScreenCaptureFromPath(absoluteScreenshotPath, "screenshot");

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else {
            test.skip("Test Skipped");
        }

        // Flush report
        extent.flush();

        // Cleanup
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (extent != null) {
            extent.flush();
        }
    }
}
