package SelfPractice.Facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

/*
TC #2: Facebook incorrect login title verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Enter incorrect username
4. Enter incorrect password
5. Verify title changed to:
Expected: “Log into Facebook | Facebook”
*/
public class Facebook_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

       driver.findElement(By.id("email")).sendKeys("hebehbeheheh");
       driver.findElement(By.id("pass")).sendKeys("zziezezezezeze"+Keys.ENTER);
        Thread.sleep(3000);
       String expectedTitle = "Log into Facebook | Facebook";
       String actualTitle = driver.getTitle();

       if (expectedTitle.equals(actualTitle)){
           System.out.println("PASSED");
       }else{
           System.out.println("FAILED");
       }
        System.out.println(actualTitle);
       Thread.sleep(3000);
       driver.quit();



    }
}
