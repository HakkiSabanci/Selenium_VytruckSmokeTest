package SelfPractice.vytruck;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class LoginFactuality extends VytruckData{
    public static void main(String[] args) throws InterruptedException, IOException {
        //WebDriver driver = getDriver("chrome");
        WebDriver driver = new ChromeDriver();
        driver.get(vyTruckUrl);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //Take screen shot
        File loginPagePic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(loginPagePic, new File(truckDriverScreenShotPath+"/LoginPagePic "+ LocalDate.now()+ ".png"));
        //Locates the username and password input box
        WebElement userNameBoxLocation=driver.findElement(By.name("_username"));
        WebElement userPasswordBoxLocation=driver.findElement(By.name("_password"));
        //Sends the given data to user name and password
        userNameBoxLocation.sendKeys(truckDriverUserName);
        userPasswordBoxLocation.sendKeys(truckDriverPassword);
        //Locates the submit button after entered given user data
        WebElement submitButtonLocation=driver.findElement(By.id("_submit"));
        submitButtonLocation.click();
        Thread.sleep(3000);
        //Takes the screen shot
        File dashBoard = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(dashBoard, new File(truckDriverScreenShotPath+"/TruckDriverDashBoard "+LocalDate.now()+".png"));
        //Locates the UserName location on dashboard
        WebElement userNameButton = driver.findElement(By.className("dropdown-toggle"));
        userNameButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        logOutButton.click();

        Thread.sleep(3000);

        File loggedOutPagePic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(loggedOutPagePic, new File(truckDriverScreenShotPath+"/LoggedOutPagePic "+ LocalDate.now()+ ".png"));

        Thread.sleep(2000);
        driver.close();



    }
}
