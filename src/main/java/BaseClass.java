import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseClass {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static WebDriver chromeDriver;
    public static WebDriver fireFoxDriver ;
    public static TakesScreenshot tsChrome = (TakesScreenshot) chromeDriver;
    public static TakesScreenshot tsFireFore = (TakesScreenshot) fireFoxDriver;


    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidMail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }


    @BeforeSuite(alwaysRun = true)
    public void setup()
    {
        getChromeDriver();
    //    getFireFoxDriver();
        try { loading();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter("report/extent.html");
        // initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void getFireFoxDriver(){
        System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
        fireFoxDriver = new FirefoxDriver();
        fireFoxDriver.manage().window().maximize();
    }

    public static void getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/springbootDataApp/Project/src/main/resources/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    public static void loading() throws InterruptedException {
        System.out.println("ILab Website Loading...");
        sleepTime(5000);
    }

    @AfterSuite(alwaysRun = true)
    public void finishUp() throws InterruptedException {
        extent.flush();
        sleepTime(20000);
    }

    public static void sleepTime(int time){
        try {
            Thread.currentThread();
            Thread.sleep(time);
        }catch (InterruptedException e1) {
            e1.printStackTrace();
        }

    }
}
