package SelfPractice.DropDownTasks;

import SelfPractice.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_5 {
    //TC #5: Selecting value from non-select dropdown
    WebDriver driver;
    @BeforeMethod
    public void setUpDriver(){
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    @Test
    public void nonSelectedDropDownTest() throws InterruptedException {
        //3. Click to non-select dropdown
        //4. Select Facebook from dropdown
        //5. Verify title is “Facebook - Log In or Sign Up”
        WebElement nonSelectedDropDown = driver.findElement(By.cssSelector("a#dropdownMenuLink"));
        Thread.sleep(2000);
        nonSelectedDropDown.click();
        WebElement faceBookLink = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a[4]"));
        Thread.sleep(2000);
        faceBookLink.click();
        Thread.sleep(2000);
        String expectedTitle="Facebook - Log In or Sign Up";
        String actualTitle=driver.getTitle();
       Assert.assertEquals(actualTitle,expectedTitle);
    }



}
