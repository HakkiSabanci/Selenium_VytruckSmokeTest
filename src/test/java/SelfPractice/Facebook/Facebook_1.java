package SelfPractice.Facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #1: Facebook title verification
        1. Open Chrome browser
        2. Go to https://www.facebook.com
        3. Verify title:
        Expected: “Facebook - Log In or Sign Up”
*/
public class Facebook_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        Thread.sleep(4000);
        driver.quit();


    }
}
