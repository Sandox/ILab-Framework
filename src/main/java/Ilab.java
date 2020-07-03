import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;

public class Ilab extends BaseClass{


    public static void getURL(WebDriver driver){
        driver.get("https://www.ilabquality.com/");
    }

    @DataProvider
    public static Iterator<Object[]> getData() throws Exception {
        try {
            ArrayList<Object[]> data = TestData.getData();
            return data.iterator();
        }catch (Exception e) {
            throw new Exception(e);
        }

    }

    public static void navigateCareers(WebDriver driver){
        try {
            driver.findElement(By.id("menu-item-1373")).click();
        }catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void clickSA(WebDriver driver){
        try {
            sleepTime(2000);
            WebElement sa = driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div[3]/div[2]/div/div/div[4]/a"));
            sleepTime(2000);
            sa.click();
        }catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void job(WebDriver driver){
        try {
            WebElement jobName = driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div[1]/a"));
            sleepTime(3000);
            jobName.click();
        }catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public static void apply(WebDriver driver){
        try {
            WebElement applyIlab = driver.findElement(By.xpath("//*[@id=\"wpjb-scroll\"]/div[1]/a"));
            scroll(driver,applyIlab);
            sleepTime(3000);
            applyIlab.click();
            sleepTime(3000);
        }catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void scroll(WebDriver driver, WebElement element){
        try {
            sleepTime(2000);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
        }catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void enterName(WebDriver driver,String stName) {
        try {
            Reporter.log("Capture name");
            Reporter.log("<br>");
            WebElement name = driver.findElement(By.id("applicant_name"));
            sleepTime(2000);
           name.sendKeys(stName);
            sleepTime(2000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    public static void enterEmail(WebDriver driver, String stEmail) {
        try {
            Reporter.log("Capture Email address");
            Reporter.log("<br>");
            WebElement email = driver.findElement(By.id("email"));
            sleepTime(2000);
            email.sendKeys(stEmail);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void phone(WebDriver driver, String number) {
        try {
            Reporter.log("Capture Phone Number");
            Reporter.log("<br>");
            WebElement num = driver.findElement(By.id("phone"));
            sleepTime(2000);
            scroll(driver,num);
            num.sendKeys(number);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void ilabMessage(WebDriver driver, String strMessage) {
        try {
            Reporter.log("Capture message");
            Reporter.log("<br>");
            WebElement message = driver.findElement(By.id("message"));
            sleepTime(2000);
            message.sendKeys(strMessage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static boolean fileValidatition(WebDriver driver) {
        boolean validation=false;
        try {
            Reporter.log("File Validation > ");

            WebElement button = driver.findElement(By.id("wpjb_submit"));
            sleepTime(2000);
            button.click();
            sleepTime(6000);
           // scroll(driver,button);
            if (driver.getPageSource().contains("You need to upload at least one file.")){
                scroll(driver,driver.findElement(By.id("wpjb-upload-browse-file")));
              captureScreenShot();
                validation=true;
            }else validation=false;
            System.out.println(validation);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return validation;

    }


    public static void captureScreenShot() {

        try {
          System.setProperty("org.uncommons.reportng.escape-output","false");
            TestUtil.Report();
            Reporter.log("<a href=\"C:\\Users\\Admin\\Downloads\\springbootDataApp\\Project\\src\\main\\resources\\"+TestUtil.screenName+"\">View Screenshot</a>");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static String genNumber() {
        String [] numbers = {"08"};
        int lower = 10000000;
        int upper = 89999999;
        double x = Math.random();
        String randomNumber = numbers[0]+(int)(lower+ (x * upper));
        return randomNumber;
    }

}
