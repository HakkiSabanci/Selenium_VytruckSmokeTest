package SelfPractice.Facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
TC #4: Facebook header verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Verify “Create a page” link href value contains text:
Expected: “registration_form”
•
 */
public class Facebook_4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        String actualLink = driver.findElement(By.className("_8esh")).getAttribute("href");
        String expectedText = "registration_form";
        if (actualLink.contains(expectedText)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }





    }
}
