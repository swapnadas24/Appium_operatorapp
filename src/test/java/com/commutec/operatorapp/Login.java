package com.commutec.operatorapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;

import com.github.javafaker.Faker;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Login{
    AndroidDriver<AndroidElement> driver;
    public Properties props;
    public Faker faker;
    
    @BeforeTest
    public void lunch() throws InterruptedException, IOException {
        // Load the properties File
        props = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "//application.properties");
        props.load(objfile);
        faker=new Faker(new Locale("en-IND"));
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "W89DN7UGWWPBHUJZ");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.commutec.operatorapplication");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.commutec.operatorapplication.MainActivity");
        caps.setCapability("unicodeKeyboard", "true");
        caps.setCapability("resetKeyboard", "false");

        // lunch app
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(500);
    }

    @BeforeMethod
    public void userlogin() throws InterruptedException, IOException {

        // input credential
        driver.findElement(By.xpath(props.getProperty("mobileNo"))).setValue("7678046095");
        driver.findElement(By.xpath(props.getProperty("password"))).setValue("123456");
        driver.findElement(By.xpath(props.getProperty("signIn"))).click();
        Thread.sleep(500);
        Assert.assertTrue(driver.findElement(By.xpath(props.getProperty("homeScreen"))).isDisplayed(),"Homescreen is not displayed");
        Thread.sleep(1000);
    }
   
   /*  @AfterMethod
    public void logout() {

        WebElement profile = driver.findElement(By.xpath(props.getProperty("logout_profile")));
        WebElement logout = driver.findElement(By.xpath(props.getProperty("logoutTab")));

        Actions log = new Actions(driver);
        log.moveToElement(profile).moveToElement(logout).click().build().perform();

    } */

    @AfterTest
    public void close() {
        // driver.quit();

    }

}
