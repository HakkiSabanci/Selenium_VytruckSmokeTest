package SelfPractice.vytruck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;


public class VytruckData {
     String browserType;
    static String vyTruckUrl;
    static String truckDriverUserName;
    static String storeManagerUserName;
    static String salesManagerUserName;
    static String truckDriverPassword;
    static String storeManagerPassword;
    static String salesManagerPassword;
    static String truckDriverScreenShotPath;
    static String storeManagerScreenShotPath;
    static String salesManagerScreenShotPath;
    static{
        vyTruckUrl ="https://qa2.vytrack.com/user/login";

        truckDriverUserName="user171";
        truckDriverPassword="UserUser123";
        truckDriverScreenShotPath="C:/Users/catzi/OneDrive/Desktop/VYtruck Truck Driver smoke test";

        storeManagerUserName="storemanager221";
        storeManagerPassword="UserUser123";
        storeManagerScreenShotPath="C:/Users/catzi/OneDrive/Desktop/VYtruck Store Manager smoke test";

        salesManagerUserName="salesmanager271";
        salesManagerPassword="UserUser123";
        salesManagerScreenShotPath="C:/Users/catzi/OneDrive/Desktop/VYtruck Sales Manager smoke test";
                                 //"C:/Users/catzi/OneDrive/Desktop/New folder"
    }

    public static WebDriver getDriver(String browserType){
        //this.browserType=browserType;
        if (browserType.equalsIgnoreCase("chrome")){
            //System.setProperty("webdriver.chrome.driver", "path");

            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        }else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            System.out.println("Given browser does not exist. Driver = null!");
            return null;
        }

    }

    /*public File screenShotAsDriver(File nameOfFile,String screenShotName) throws IOException {
        WebDriver driver = getDriver(browserType);
        nameOfFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nameOfFile, new File(truckDriverScreenShotPath+"/"+screenShotName+" "+ LocalDate.now()+".png");
        return nameOfFile;
    }*/
/*
File loggedOutPagePic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(loggedOutPagePic, new File(truckDriverScreenShotPath+"/LoggedOutPagePic "+ LocalDate.now()+ ".png"));
 */

}
