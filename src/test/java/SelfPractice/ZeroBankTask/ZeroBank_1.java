package SelfPractice.ZeroBankTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

/*
Zero Bank title verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify title
Expected: “Zero - Log in”
 */
public class ZeroBank_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        String expectedTitle = "Zero - Log in";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("TITLE PASSED");
        }else{
            System.out.println("TITLE FAILED");
        }
        Thread.sleep(3000);
        driver.quit();

    }
}
