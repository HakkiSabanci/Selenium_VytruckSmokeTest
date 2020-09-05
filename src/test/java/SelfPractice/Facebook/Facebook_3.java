package SelfPractice.Facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #3: Facebook header verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Verify header text is as expected:
Expected: “Connect with friends and the world around you on Facebook.”
 */
public class Facebook_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        String expectedText = "Connect with friends and the world around you on Facebook.";
        String actualText = driver.findElement(By.className("_8eso")).getText();
        if (expectedText.equals(actualText)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        Thread.sleep(3000);
        driver.quit();



    }
}
