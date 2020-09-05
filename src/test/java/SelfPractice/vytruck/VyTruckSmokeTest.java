package SelfPractice.vytruck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;



public class VyTruckSmokeTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //ScreenShot Directory's path: C:/Users/catzi/OneDrive/Desktop/VYtruck smoke test

        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();


        String expectedTitle = "Login";
        String actualTitle = driver.getTitle();

        Thread.sleep(3000);
        //TEST #1
        File loginPagePic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        if (actualTitle.equals(expectedTitle)){
            FileUtils.copyFile(loginPagePic, new File("C:/Users/catzi/OneDrive/Desktop/VYtruck smoke test/Test#1 LoginPagePic_PASSED "+LocalDate.now()+ ".png"));
        }else{
            FileUtils.copyFile(loginPagePic, new File("C:/Users/catzi/OneDrive/Desktop/VYtruck smoke test/Test#1 LoginPagePic_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);

        driver.findElement(By.name("_username")).sendKeys("user171");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000);

        //Expected Dashboard Title must match actual Dashboard
        String expectedTitleDashboard = "Dashboard";
        String actualTitleDashboard = driver.getTitle();

        Thread.sleep(3000);
        //TEST #2
        File userHomePage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (actualTitleDashboard.equals(expectedTitleDashboard)) {
            FileUtils.copyFile(userHomePage, new File("C:/Users/catzi/OneDrive/Desktop/VYtruck smoke test/Test#2 UserHomePage_PASSED "+LocalDate.now()+".png"
            ));
        }else{
            FileUtils.copyFile(userHomePage, new File("C:/Users/catzi/OneDrive/Desktop/VYtruck smoke test/Test#2 UserHomePage_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);

        //Actions Class: code block to simulate mouseHover and display options on fleet module
        // to get the xpath: when you inspecting a module you will see three dots right side of the html code click>copy>copy xpath

        Actions actions = new Actions(driver);

        WebElement fleetModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")); //

        String actualFleetModuleName=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).getText();
        String expectedFleetModuleName="Fleet";

        actions.moveToElement(fleetModule).perform();//to perform the mouseHover

        Thread.sleep(3000);
        //TEST #3
        File fleetDropDownMenu = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (expectedFleetModuleName.equals(actualFleetModuleName)) {
            FileUtils.copyFile(fleetDropDownMenu, new File("C:/Users/catzi/OneDrive/Desktop/VYtruck smoke test/Test#3 FleetDropDown_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(fleetDropDownMenu, new File("C:/Users/catzi/OneDrive/Desktop/VYtruck smoke test/Test#3 FleetDropDown_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);

        // to find  and click ont the webElement Vehicles
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span")).click();
        Thread.sleep(2000);

        String expectedVehiclesPageTitle="Car - Entities - System - Car - Entities - System";
        String actualVehiclesPageTitle=driver.getTitle();
        Thread.sleep(3000);
        //TEST #4
        File VehiclesPage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (expectedVehiclesPageTitle.equals(actualVehiclesPageTitle)) {
            FileUtils.copyFile(VehiclesPage, new File("C:/Users/catzi/OneDrive/Desktop/VYtruck smoke test/Test#4 VehiclesPage_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(VehiclesPage, new File("C:/Users/catzi/OneDrive/Desktop/VYtruck smoke test/Test#4 VehiclesPage_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);

        //to mouse hover on Fleet Module
        actions.moveToElement(fleetModule).perform();//to perform the mouseHover

        //to find web element Vehicle Odometer
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[4]/a/span")).click();
        Thread.sleep(3000);
        String expectedVehicleOdometerTitle = "Vehicle Odometer - Entities - System - Car - Entities - System";
        String actualVehicleOdometerTitle = driver.getTitle();
        //TEST #5
        Thread.sleep(3000);
        File odometerPage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        if (expectedVehicleOdometerTitle.equals(actualVehicleOdometerTitle)){
            FileUtils.copyFile(odometerPage, new File("C:/Users/catzi/OneDrive/Desktop/VYtruck smoke test/Test#5 VehiclesOdometerPage_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(odometerPage, new File("C:/Users/catzi/OneDrive/Desktop/VYtruck smoke test/Test#5 VehiclesOdometerPage_FAILED "+LocalDate.now()+".png"));
        }

        Thread.sleep(3000);
        driver.close();
    }

}
