package SelfPractice.vytruck;

import SelfPractice.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.http.WebSocket;
import java.util.concurrent.TimeUnit;

public class vYTruckEvent extends VytruckData{
    WebDriver driver;
    @BeforeMethod
    public void setUpDrive(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(vyTruckUrl);
        WebElement userNameBoxLocation=driver.findElement(By.name("_username"));
        WebElement userPasswordBoxLocation=driver.findElement(By.name("_password"));
        userNameBoxLocation.sendKeys(truckDriverUserName);
        userPasswordBoxLocation.sendKeys(truckDriverPassword);
        WebElement submitButtonLocation=driver.findElement(By.id("_submit"));
        submitButtonLocation.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        /*
         Actions actions = new Actions(driver);

        WebElement fleetModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")); //
        String actualFleetModuleName=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).getText();
        String expectedFleetModuleName= "Fleet";
         */

    }
    @Test
    public void test() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement activitiesModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span"));
        actions.moveToElement(activitiesModule).perform();
        Thread.sleep(2000);
        WebElement calenderEvent = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/div/div/ul/li[3]/a/span"));
        calenderEvent.click();
        Thread.sleep(2000);
        WebElement createCalenderEventButton = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createCalenderEventButton.click();
        Thread.sleep(3000);
        WebElement boxToWrite = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
        driver.switchTo().frame(boxToWrite);
        //boxToWrite.click();

        driver.findElement(By.xpath("//*[@id=\"oro_calendar_event_form_description-uid-5f654b4d8573c_ifr\"]")).sendKeys("Hello How are you");
        Thread.sleep(5000);
    }
    /*@AfterMethod
    public void closing(){
        driver.close();
    }
*/

}
