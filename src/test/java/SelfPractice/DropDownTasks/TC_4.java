package SelfPractice.DropDownTasks;

import SelfPractice.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_4 {
    //Selecting value from multiple select dropdown
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
    public void multipleSelectTest() throws InterruptedException {
        //3. Select all the options from multiple select dropdown.
        //4. Print out all selected values.
        //5. Deselect all values.
        List<WebElement> listOfLanguages = driver.findElements(By.name("Languages"));
        Select multipleLanguages = new Select(driver.findElement(By.name("Languages")));
        Thread.sleep(2000);
        multipleLanguages.selectByValue("java");
        Thread.sleep(1000);
        multipleLanguages.selectByValue("js");
        Thread.sleep(1000);
        multipleLanguages.selectByValue("c#");
        Thread.sleep(1000);
        multipleLanguages.selectByValue("python");
        Thread.sleep(1000);
        multipleLanguages.selectByValue("ruby");
        Thread.sleep(1000);
        multipleLanguages.selectByValue("c");
        Thread.sleep(2000);
        for (WebElement eachElement: listOfLanguages){
            System.out.println(eachElement.getText());
        }
        Thread.sleep(1000);
        multipleLanguages.deselectAll();
    }
    @AfterMethod
    public void tearDownDriver(){
        driver.close();
    }




}
