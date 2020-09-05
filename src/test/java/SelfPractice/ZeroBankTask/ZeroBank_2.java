package SelfPractice.ZeroBankTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #2: Zero Bank link text verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify link text from top left:
Expected: “Zero Bank”
4. Verify link href attribute value contains:
Expected: “index.html”
 */
public class ZeroBank_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        String expectedLinkText = "Zero Bank";
        String actualLinkText = driver.findElement(By.className("brand")).getText();
        if (expectedLinkText.equalsIgnoreCase(actualLinkText)){
            System.out.println("Expected Link Text Name is PASSED");
        }else{
            System.out.println("Expected Link Text Name is FAILED");
        }
        String expectedContainedValue = "index.html";
        WebElement actualLinkHref = driver.findElement(By.className("brand"));
        String actualHref = actualLinkHref.getAttribute("href");
        if (actualHref.contains(expectedContainedValue)){
            System.out.println("Zero Bank link text verification PASSED");
        }else{
            System.out.println("Zero Bank link text verification FAILED");
        }
        Thread.sleep(3000);
        driver.quit();






    }
}
