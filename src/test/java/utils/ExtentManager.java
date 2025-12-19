package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            try {
                Path reportsDir = Paths.get("test-output", "extent-reports");
                Files.createDirectories(reportsDir);

                String timestamp = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

                String reportPath = reportsDir.resolve("ExtentReport_" + timestamp + ".html").toString();

                ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

                extent = new ExtentReports();
                extent.attachReporter(reporter);

            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize Extent report", e);
            }
        }
        return extent;
    }
}
