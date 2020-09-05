package SelfPractice.ZeroBankTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
TC #4: Zero Bank login title verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Enter username: username
4. Enter password: password
5. Click to “Account Activity” link
6. Verify title changed to:
Expected: “Zero – Account Activity”
7. Click to “Transfer Funds” link
8. Verify title changed to:
Expected: “Zero – Transfer Funds”
9. Click to “Pay Bills” link
10. Verify title changed to:
Expected: “Zero - Pay Bills”
11. Click to “My Money Map” link
12. Verify title changed to:
Expected: “Zero – My Money Map”
13. Click to “Online Statements” link
14. Verify title changed to:
Expected: “Zero – Online Statements” */
public class ZeroBank_3_LoginTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.name("user_login")).sendKeys("username");

        driver.findElement(By.name("user_password")).sendKeys("password"+ Keys.ENTER);

       // ACCOUNT ACTIVITY TITLE VERIFICATION
        driver.findElement(By.linkText("Account Activity")).click();

        String actualAccountActivityTitle = driver.getTitle();
        String expectedAccountActivityTitle = "Zero - Account Activity";

        if (actualAccountActivityTitle.equals(expectedAccountActivityTitle)){
            System.out.println("Account Activity Title Result: PASSED");
        }else {
            System.out.println("Account Activity Title Result: FAILED");
        }
        Thread.sleep(1000);

        //TRANSFER FUNDS TITLE VERIFICATION
        driver.findElement(By.linkText("Transfer Funds")).click();

        String actualTransferFundsTitle = driver.getTitle();
        String expectedTransferFundsTitle = "Zero - Transfer Funds";

        if (actualTransferFundsTitle.equalsIgnoreCase(expectedTransferFundsTitle)){
            System.out.println("Transfer Funds Title Result: PASSED");
        }else{
            System.out.println("Transfer Funds Title Result: FAILED");
        }
        Thread.sleep(1000);
        //PAY BILLS TITLE VERIFICATION
        driver.findElement(By.linkText("Pay Bills")).click();

        String actualPayBillsTitle = driver.getTitle();
        String expectedPayBillsTitle = "Zero - Pay Bills";

        if (actualPayBillsTitle.equals(expectedPayBillsTitle)){
            System.out.println("Pay Bills Title Result: PASSED");
        }else {
            System.out.println("Pay Bills Title Result: FAILED");
        }


        Thread.sleep(1000);
        //MY MONEY MAP TITLE VERIFICATION
        driver.findElement(By.linkText("My Money Map")).click();

        String actualMyMoneyMapTitle = driver.getTitle();
        String expectedMyMoneyMapTitle = "Zero - My Money Map";

        if(actualMyMoneyMapTitle.equals(expectedMyMoneyMapTitle)){
            System.out.println("My Money Map Title Result: PASSED");
        }else{
            System.out.println("My Money Map Title Result: FAILED");
        }


        Thread.sleep(1000);
        //ONLINE STATEMENTS VERIFICATION
        driver.findElement(By.linkText("Online Statements")).click();

        String actualOnlineStatementsTitle = driver.getTitle();
        String expectedOnlineStatementsTitle = "Zero - Online Statements";

        if (actualOnlineStatementsTitle.equals(expectedOnlineStatementsTitle)){
            System.out.println("Online Statements Title Result: PASSED");
        }else{
            System.out.println("Online Statements Title Result: FAILED");
        }







    }
}
