import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class IlabTest extends BaseClass {


    public void goToChrome(){
        Ilab.getURL(chromeDriver);
        Ilab.navigateCareers(chromeDriver);
        Ilab.clickSA(chromeDriver);
        Ilab.job(chromeDriver);
        Ilab.apply(chromeDriver);
    }

    public void goToFireFox(){
        Ilab.getURL(fireFoxDriver);
        Ilab.navigateCareers(fireFoxDriver);
        Ilab.clickSA(fireFoxDriver);
        Ilab.job(fireFoxDriver);
        Ilab.apply(fireFoxDriver);
    }

   @Test
    public void test1(){
        goToChrome();
        Ilab.enterName(fireFoxDriver,"Sandile");
        Ilab.enterEmail(fireFoxDriver,"Email@gmail.com");
        Ilab.phone(fireFoxDriver,Ilab.genNumber());
        Ilab.ilabMessage(fireFoxDriver,"Ilab is a great testing house");
        Ilab.fileValidatition(fireFoxDriver);
        sleepTime(5000);
    }

    @Test(dataProvider ="getData", dataProviderClass = Ilab.class)
    public void test2(String name, String number, String email, String message) throws IOException {
        goToChrome();
        Ilab.enterName(chromeDriver,name);
        Ilab.enterEmail(chromeDriver,email);
        Ilab.phone(chromeDriver,number);
        Ilab.ilabMessage(chromeDriver,message);
        Ilab.fileValidatition(chromeDriver);
        sleepTime(5000);

    }

    @AfterTest
    public void closeConnection(){
        chromeDriver.close();
        chromeDriver.manage().deleteAllCookies();

    }
}
