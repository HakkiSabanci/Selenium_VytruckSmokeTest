package SelfPractice.DropDownTasks;

import SelfPractice.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_2 {
    WebDriver driver;
//#2: Selecting state from State dropdown and verifying result
//1. Open Chrome browser
//2. Go to http://practice.cybertekschool.com/dropdown
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

//3. Select Illinois
//4. Select Virginia
//5. Select California
//6. Verify final selected option is California.
//Use all Select options. (visible text, value, index)
    @Test
    public void dropDowns() throws InterruptedException {
     Select stateDropDowns=new Select(driver.findElement(By.id("state")));
     stateDropDowns.selectByValue("IL");
     Thread.sleep(2000);
     stateDropDowns.selectByVisibleText("Virginia");
     Thread.sleep(2000);
     stateDropDowns.selectByIndex(5);
     WebElement california = driver.findElement(By.xpath("//*[@id=\"state\"]/option[6]"));
     Assert.assertTrue(california.isSelected(),"Wrong State is Selected");
    }
    @AfterMethod
    public void tearDownDriver(){

        driver.close();

    }




}
