import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class TestUtil extends BaseClass {
    public static TakesScreenshot tsChrome = (TakesScreenshot) chromeDriver;
    public static TakesScreenshot tsFireFore = (TakesScreenshot) fireFoxDriver;

    public static String screenShotPath="";
    public static String screenName="";

    public static void Report() throws IOException {
        Date d = new Date();

        screenName = d.toString().replace(":","_").replace(" ", "_")+".jpg";
        screenShotPath = "C:/Users/Admin/Downloads/springbootDataApp/Project/src/main/resources/" +screenName;
        File scrFile = tsChrome.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File(screenShotPath)) ;
    }
}
