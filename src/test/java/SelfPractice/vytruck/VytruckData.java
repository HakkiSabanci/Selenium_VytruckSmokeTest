package SelfPractice.vytruck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VytruckData {
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
    }

    public static WebDriver getDriver(String browserType){

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
}
