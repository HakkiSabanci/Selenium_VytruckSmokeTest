package SelfPractice.vytruck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class VyTruckTestRun {
    public static void main(String[] args) throws IOException, InterruptedException {
        VyTruckSmokeTest truckDriver =new VyTruckSmokeTest();
        VyTruckSmokeTest storeManager=new VyTruckSmokeTest();
        truckDriver.truckDriver();
        storeManager.storeManager();

    }
}
