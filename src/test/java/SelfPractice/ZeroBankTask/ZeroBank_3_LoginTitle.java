package SelfPractice.ZeroBankTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
TC #3: Zero Bank login title verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Enter username: username
4. Enter password: password
5. Verify title changed to:
Expected: “Zero – Account Summary”
 */
public class ZeroBank_3_LoginTitle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.name("user_login")).sendKeys("username");
        Thread.sleep(2000);
        driver.findElement(By.name("user_password")).sendKeys("password"+ Keys.ENTER);
        Thread.sleep(2000);
        String expectedTitle = "Zero - Account Summary";
        String actualTitle=driver.getTitle();
        if (expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("Title Verification PASSED");
        }else{
            System.out.println("Title Verification FAILED");
        }
        Thread.sleep(5000);
        driver.quit();

    }
}
