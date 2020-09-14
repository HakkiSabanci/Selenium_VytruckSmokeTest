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

import java.util.concurrent.TimeUnit;

public class TC_3 {
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    //3. Select “December 1st, 1921” and verify it is selected.
    //Select year using : visible text
    //Select month using : value attribute
    //Select day using : index number
    @Test
    public void DateDropDownTest() throws InterruptedException {
        Select yearDropDown=new Select(driver.findElement(By.id("year")));
        Select monthDropDown=new Select(driver.findElement(By.id("month")));
        Select dayDropDown=new Select(driver.findElement(By.id("day")));
        Thread.sleep(2000);
        yearDropDown.selectByVisibleText("1921");
        Thread.sleep(2000);
        monthDropDown.selectByValue("11");
        Thread.sleep(2000);
        dayDropDown.selectByIndex(0);
        boolean yearIsSelected = driver.findElement(By.xpath("//select[@id='year']/option[100]")).isSelected();
        boolean monthIsSelected = driver.findElement(By.xpath("//select[@id='month']/option[12]")).isSelected();
        boolean dayIsSelected = driver.findElement(By.xpath("//select[@id='day']/option[1]")).isSelected();
        Assert.assertTrue(yearIsSelected&&monthIsSelected&&dayIsSelected,"Verification FAILED!!");
    }
    @AfterMethod
    public void closeDriver(){
        driver.close();
    }


}
