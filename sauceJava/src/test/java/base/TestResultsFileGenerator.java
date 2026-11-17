package base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TestResultsFileGenerator implements ITestListener {
    private FileWriter fileWriter;

    @Override
    public void onStart(ITestContext context) {
        try {
            // Initialize the report file
            File reportFile = new File("TestCasesResults.html");
            if (!reportFile.exists()) {
                reportFile.createNewFile();
            }
            fileWriter = new FileWriter(reportFile, true);
            fileWriter.write("<html><head><title>Test Execution Report</title></head><body>");
            fileWriter.write("<h1>Test Execution Report</h1>");
            fileWriter.write("<table border='1'><tr><th>Test Name</th><th>Status</th><th>Time</th></tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            fileWriter.write("<tr><td>" + result.getName() +
                    "</td><td style='color:green;'>Passed</td><td>" + new Date(result.getEndMillis()) + "</td></tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            fileWriter.write("<tr><td>" + result.getName() +
                    "</td><td style='color:red;'>Failed</td><td>" + result.getEndMillis() + "</td></tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            fileWriter.write("<tr><td>" + result.getName() +
                    "</td><td style='color:orange;'>Skipped</td><td>" + result.getEndMillis() + "</td></tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onFinish(ITestContext context) {
        try {
            fileWriter.write("</table></body></html>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestStart(ITestResult result) {}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
}
