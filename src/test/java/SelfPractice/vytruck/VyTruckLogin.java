package SelfPractice.vytruck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTruckLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //Given user in on VyTruck web page
        driver.get("https://qa2.vytrack.com/user/login");
        //And has valid user name and password
        driver.findElement(By.id("prependedInput")).sendKeys("user171");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        //
        driver.findElement(By.className("title title-level-1")).getAttribute("href");

        driver.findElement(By.className("title title-level-2")).click();



    }
}
