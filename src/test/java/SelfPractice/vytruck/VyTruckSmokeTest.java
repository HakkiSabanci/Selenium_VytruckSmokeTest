package SelfPractice.vytruck;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;



public class VyTruckSmokeTest extends VytruckData{
    public static void truckDriver() throws InterruptedException, IOException {
        WebDriver driver=getDriver("chrome");
        //"C:/Users/catzi/OneDrive/Desktop/test"
        //ScreenShot Directory's path: C:/Users/catzi/OneDrive/Desktop/VYtruck Truck Driver smoke test

        assert driver != null;
        driver.get(vyTruckUrl);
        driver.manage().window().maximize();


        String expectedTitle = "Login";
        String actualTitle = driver.getTitle();

        Thread.sleep(3000);
        //TEST #1
        File loginPagePic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        if (actualTitle.equals(expectedTitle)){
            FileUtils.copyFile(loginPagePic, new File(truckDriverScreenShotPath+"/Test#1 LoginPagePic_PASSED "+LocalDate.now()+ ".png"));
        }else{
            FileUtils.copyFile(loginPagePic, new File(truckDriverScreenShotPath+"/Test#1 LoginPagePic_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);
        //Locates the username and password input box
        WebElement userNameBoxLocation=driver.findElement(By.name("_username"));
        WebElement userPasswordBoxLocation=driver.findElement(By.name("_password"));
        //Sends the given data to user name and password
        userNameBoxLocation.sendKeys(truckDriverUserName);
        userPasswordBoxLocation.sendKeys(truckDriverPassword);
        //Locates the submit button after entered given user data
        WebElement submitButtonLocation=driver.findElement(By.id("_submit"));

        submitButtonLocation.click();
        Thread.sleep(3000);

        //Expected Dashboard Title must match actual Dashboard
        String expectedTitleDashboard = "Dashboard";
        String actualTitleDashboard = driver.getTitle();

        Thread.sleep(3000);
        //TEST #2
        File userHomePage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (actualTitleDashboard.equals(expectedTitleDashboard)) {
            FileUtils.copyFile(userHomePage, new File(truckDriverScreenShotPath+"/Test#2 UserHomePage_PASSED "+LocalDate.now()+".png"
            ));
        }else{
            FileUtils.copyFile(userHomePage, new File(truckDriverScreenShotPath+"/Test#2 UserHomePage_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);
        //Locates the logged in account's username
        WebElement userNameLocation = driver.findElement(By.className("dropdown-toggle"));
        userNameLocation.click();
        Thread.sleep(2000);
        //Locates User's Profile Account Link
        WebElement userProfileLocation=driver.findElement(By.linkText("My User"));
        userProfileLocation.click();
        Thread.sleep(3000);

        String expectedProfileTitle = "Lilla Kertzmann - View - Users - User Management - System";
        String actualProfileTitle = driver.getTitle();

        //Takes the Screen Shot to proof Truck Driver user account is stable
        //Test#3
        File userProfilePage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (actualProfileTitle.equals(expectedProfileTitle)) {
            FileUtils.copyFile(userProfilePage, new File(truckDriverScreenShotPath+"/Test#3 UserProfilePage_PASSED "+LocalDate.now()+".png"
            ));
        }else{
            FileUtils.copyFile(userProfilePage, new File(truckDriverScreenShotPath+"/Test#3 UserProfilePage_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(2000);
        //Goes back to Dashboard
        driver.navigate().back();


        //Actions Class: code block to simulate mouseHover and display options on fleet module
        // to get the xpath: when you inspecting a module you will see three dots right side of the html code click>copy>copy xpath


        Actions actions = new Actions(driver);

        WebElement fleetModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")); //

        String actualFleetModuleName=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).getText();
        String expectedFleetModuleName="Fleet";

        actions.moveToElement(fleetModule).perform();//to perform the mouseHover

        Thread.sleep(3000);
        //TEST #4
        File fleetDropDownMenu = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (expectedFleetModuleName.equals(actualFleetModuleName)) {
            FileUtils.copyFile(fleetDropDownMenu, new File(truckDriverScreenShotPath+"/Test#4 FleetDropDown_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(fleetDropDownMenu, new File(truckDriverScreenShotPath+"/Test#4 FleetDropDown_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);

        // to find  and click ont the webElement Vehicles
        WebElement vehiclesInFleetModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span"));

        vehiclesInFleetModule.click();
        Thread.sleep(2000);

        String expectedVehiclesPageTitle = "Car - Entities - System - Car - Entities - System";
        String actualVehiclesPageTitle = driver.getTitle();
        Thread.sleep(3000);
        //TEST #5
        File VehiclesPage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (expectedVehiclesPageTitle.equals(actualVehiclesPageTitle)) {
            FileUtils.copyFile(VehiclesPage, new File(truckDriverScreenShotPath+"/Test#5 VehiclesPage_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(VehiclesPage, new File(truckDriverScreenShotPath+"/Test#5 VehiclesPage_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);

        //to mouse hover on Fleet Module
        actions.moveToElement(fleetModule).perform();//to perform the mouseHover

        //to find web element Vehicle Odometer
        WebElement vehicleOdometerInFleetModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[4]/a/span"));

        vehicleOdometerInFleetModule.click();
        Thread.sleep(3000);

        String expectedVehicleOdometerTitle = "Vehicle Odometer - Entities - System - Car - Entities - System";
        String actualVehicleOdometerTitle = driver.getTitle();
        //TEST #6
        Thread.sleep(3000);
        File odometerPage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        if (expectedVehicleOdometerTitle.equals(actualVehicleOdometerTitle)){
            FileUtils.copyFile(odometerPage, new File(truckDriverScreenShotPath+"/Test#6 VehiclesOdometerPage_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(odometerPage, new File(truckDriverScreenShotPath+"/Test#6 VehiclesOdometerPage_FAILED "+LocalDate.now()+".png"));
        }

        Thread.sleep(3000);
        driver.close();
    }

    public static void storeManager() throws InterruptedException, IOException {
        WebDriver driver=getDriver("chrome");
        //"C:/Users/catzi/OneDrive/Desktop/test"
        //ScreenShot Directory's path: C:/Users/catzi/OneDrive/Desktop/VYtruck Truck Driver smoke test

        driver.get(vyTruckUrl);
        driver.manage().window().maximize();


        String expectedTitle = "Login";
        String actualTitle = driver.getTitle();

        Thread.sleep(3000);
        //TEST #1
        File loginPagePic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        if (actualTitle.equals(expectedTitle)){
            FileUtils.copyFile(loginPagePic, new File(storeManagerScreenShotPath+"/Test#1 LoginPagePic_PASSED "+LocalDate.now()+ ".png"));
        }else{
            FileUtils.copyFile(loginPagePic, new File(storeManagerScreenShotPath+"/Test#1 LoginPagePic_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);
        //Locates the username and password input box
        WebElement userNameBoxLocation=driver.findElement(By.name("_username"));
        WebElement userPasswordBoxLocation=driver.findElement(By.name("_password"));
        //Sends the given data to user name and password
        userNameBoxLocation.sendKeys(storeManagerUserName);
        userPasswordBoxLocation.sendKeys(storeManagerPassword);
        //Locates the submit button after entered given user data
        WebElement submitButtonLocation=driver.findElement(By.id("_submit"));

        submitButtonLocation.click();
        Thread.sleep(3000);

        //Expected Dashboard Title must match actual Dashboard
        String expectedTitleDashboard = "Dashboard";
        String actualTitleDashboard = driver.getTitle();

        Thread.sleep(3000);
        //TEST #2
        File userHomePage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (actualTitleDashboard.equals(expectedTitleDashboard)) {
            FileUtils.copyFile(userHomePage, new File(storeManagerScreenShotPath+"/Test#2 UserHomePage_PASSED "+LocalDate.now()+".png"
            ));
        }else{
            FileUtils.copyFile(userHomePage, new File(storeManagerScreenShotPath+"/Test#2 UserHomePage_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);
        //Locates the logged in account's username
        WebElement userNameLocation = driver.findElement(By.className("dropdown-toggle"));
        userNameLocation.click();
        Thread.sleep(2000);
        //Locates User's Profile Account Link
        WebElement userProfileLocation=driver.findElement(By.linkText("My User"));
        userProfileLocation.click();
        Thread.sleep(3000);

        String expectedProfileTitle = "Stanton Towne - View - Users - User Management - System";
        String actualProfileTitle = driver.getTitle();

        //Takes the Screen Shot to proof Truck Driver user account is stable
        //Test#3
        File userProfilePage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (actualProfileTitle.equals(expectedProfileTitle)) {
            FileUtils.copyFile(userProfilePage, new File(storeManagerScreenShotPath+"/Test#3 UserProfilePage_PASSED "+LocalDate.now()+".png"
            ));
        }else{
            FileUtils.copyFile(userProfilePage, new File(storeManagerScreenShotPath+"/Test#3 UserProfilePage_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(2000);
        //Goes back to Dashboard
        driver.navigate().back();


        //Actions Class: code block to simulate mouseHover and display options on fleet module
        // to get the xpath: when you inspecting a module you will see three dots right side of the html code click>copy>copy xpath


        Actions actions = new Actions(driver);

        WebElement fleetModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")); //

        String actualFleetModuleName=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).getText();
        String expectedFleetModuleName= "Fleet";


        actions.moveToElement(fleetModule).perform();//to perform the mouseHover

        Thread.sleep(3000);
        //TEST #4
        File fleetDropDownMenu = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (expectedFleetModuleName.equals(actualFleetModuleName)) {
            FileUtils.copyFile(fleetDropDownMenu, new File(storeManagerScreenShotPath+"/Test#4 FleetDropDown_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(fleetDropDownMenu, new File(storeManagerScreenShotPath+"/Test#4 FleetDropDown_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);

        // to find  and click ont the webElement Vehicles
        WebElement vehiclesInFleetModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span"));

        vehiclesInFleetModule.click();
        Thread.sleep(2000);

        String expectedVehiclesPageTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualVehiclesPageTitle = driver.getTitle();
        Thread.sleep(3000);
        //TEST #5
        File VehiclesPage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (expectedVehiclesPageTitle.equals(actualVehiclesPageTitle)) {
            FileUtils.copyFile(VehiclesPage, new File(storeManagerScreenShotPath+"/Test#5 VehiclesPage_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(VehiclesPage, new File(storeManagerScreenShotPath+"/Test#5 VehiclesPage_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);

        //to mouse hover on Fleet Module
        actions.moveToElement(fleetModule).perform();//to perform the mouseHover

        //to find web element Vehicle Odometer
        WebElement vehicleOdometerInFleetModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[4]/a/span"));

        vehicleOdometerInFleetModule.click();
        Thread.sleep(3000);

        String expectedVehicleOdometerTitle = "You do not have permission to perform this action.";
        String actualVehicleOdometerTitle = driver.findElement(By.className("message")).getText();
        //TEST #6
        Thread.sleep(3000);
        File odometerPage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        if (expectedVehicleOdometerTitle.equals(actualVehicleOdometerTitle)){
            FileUtils.copyFile(odometerPage, new File(storeManagerScreenShotPath+"/Test#6 VehiclesOdometerPage_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(odometerPage, new File(storeManagerScreenShotPath+"/Test#6 VehiclesOdometerPage_FAILED "+LocalDate.now()+".png"));
        }

        Thread.sleep(3000);
        driver.close();
    }

    public static void salesManager() throws InterruptedException, IOException {
        WebDriver driver=getDriver("chrome");

        //ScreenShot Directory's path: C:/Users/catzi/OneDrive/Desktop/VYtruck Sales Manager smoke test

        driver.get(vyTruckUrl);
        driver.manage().window().maximize();


        String expectedTitle = "Login";
        String actualTitle = driver.getTitle();

        Thread.sleep(3000);
        //TEST #1
        File loginPagePic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        if (actualTitle.equals(expectedTitle)){
            FileUtils.copyFile(loginPagePic, new File(salesManagerScreenShotPath+"/Test#1 LoginPagePic_PASSED "+LocalDate.now()+ ".png"));
        }else{
            FileUtils.copyFile(loginPagePic, new File(salesManagerScreenShotPath+"/Test#1 LoginPagePic_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);
        //Locates the username and password input box
        WebElement userNameBoxLocation=driver.findElement(By.name("_username"));
        WebElement userPasswordBoxLocation=driver.findElement(By.name("_password"));
        //Sends the given data to user name and password
        userNameBoxLocation.sendKeys(salesManagerUserName);
        userPasswordBoxLocation.sendKeys(salesManagerPassword);
        //Locates the submit button after entered given user data
        WebElement submitButtonLocation=driver.findElement(By.id("_submit"));

        submitButtonLocation.click();
        Thread.sleep(3000);

        //Expected Dashboard Title must match actual Dashboard
        String expectedTitleDashboard = "Dashboard";
        String actualTitleDashboard = driver.getTitle();

        Thread.sleep(3000);
        //TEST #2
        File userHomePage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (actualTitleDashboard.equals(expectedTitleDashboard)) {
            FileUtils.copyFile(userHomePage, new File(salesManagerScreenShotPath+"/Test#2 UserHomePage_PASSED "+LocalDate.now()+".png"
            ));
        }else{
            FileUtils.copyFile(userHomePage, new File(salesManagerScreenShotPath+"/Test#2 UserHomePage_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);
        //Locates the logged in account's username
        WebElement userNameLocation = driver.findElement(By.className("dropdown-toggle"));
        userNameLocation.click();
        Thread.sleep(2000);
        //Locates User's Profile Account Link
        WebElement userProfileLocation=driver.findElement(By.linkText("My User"));
        userProfileLocation.click();
        Thread.sleep(3000);

        String expectedProfileTitle = "Brad Schmitt - View - Users - User Management - System";
        String actualProfileTitle = driver.getTitle();

        //Takes the Screen Shot to proof Truck Driver user account is stable
        //Test#3
        File userProfilePage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (actualProfileTitle.equals(expectedProfileTitle)) {
            FileUtils.copyFile(userProfilePage, new File(salesManagerScreenShotPath+"/Test#3 UserProfilePage_PASSED "+LocalDate.now()+".png"
            ));
        }else{
            FileUtils.copyFile(userProfilePage, new File(salesManagerScreenShotPath+"/Test#3 UserProfilePage_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(2000);
        //Goes back to Dashboard
        driver.navigate().back();


        //Actions Class: code block to simulate mouseHover and display options on fleet module
        // to get the xpath: when you inspecting a module you will see three dots right side of the html code click>copy>copy xpath


        Actions actions = new Actions(driver);

        WebElement fleetModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")); //

        String actualFleetModuleName=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).getText();
        String expectedFleetModuleName= "Fleet";


        actions.moveToElement(fleetModule).perform();//to perform the mouseHover

        Thread.sleep(3000);
        //TEST #4
        File fleetDropDownMenu = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (expectedFleetModuleName.equals(actualFleetModuleName)) {
            FileUtils.copyFile(fleetDropDownMenu, new File(salesManagerScreenShotPath+"/Test#4 FleetDropDown_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(fleetDropDownMenu, new File(salesManagerScreenShotPath+"/Test#4 FleetDropDown_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);

        // to find  and click ont the webElement Vehicles
        WebElement vehiclesInFleetModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span"));

        vehiclesInFleetModule.click();
        Thread.sleep(2000);

        String expectedVehiclesPageTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualVehiclesPageTitle = driver.getTitle();
        Thread.sleep(3000);
        //TEST #5
        File VehiclesPage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (expectedVehiclesPageTitle.equals(actualVehiclesPageTitle)) {
            FileUtils.copyFile(VehiclesPage, new File(salesManagerScreenShotPath+"/Test#5 VehiclesPage_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(VehiclesPage, new File(salesManagerScreenShotPath+"/Test#5 VehiclesPage_FAILED "+LocalDate.now()+".png"));
        }
        Thread.sleep(3000);

        //to mouse hover on Fleet Module
        actions.moveToElement(fleetModule).perform();//to perform the mouseHover

        //to find web element Vehicle Odometer
        WebElement vehicleOdometerInFleetModule = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[4]/a/span"));

        vehicleOdometerInFleetModule.click();
        Thread.sleep(3000);

        String expectedVehicleOdometerTitle = "All - Vehicle Odometer - Entities - System - Car - Entities - System";
        String actualVehicleOdometerTitle = driver.getTitle();
        //TEST #6
        Thread.sleep(3000);
        File odometerPage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        if (expectedVehicleOdometerTitle.equals(actualVehicleOdometerTitle)){
            FileUtils.copyFile(odometerPage, new File(salesManagerScreenShotPath+"/Test#6 VehiclesOdometerPage_PASSED "+LocalDate.now()+".png"));
        }else{
            FileUtils.copyFile(odometerPage, new File(salesManagerScreenShotPath+"/Test#6 VehiclesOdometerPage_FAILED "+LocalDate.now()+".png"));
        }

        Thread.sleep(3000);
        driver.close();
    }

}
