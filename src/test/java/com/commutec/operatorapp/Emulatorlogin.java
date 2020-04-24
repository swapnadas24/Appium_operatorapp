package com.commutec.operatorapp;

import java.io.File;
import java.io.IOException;

import java.net.URL;

import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class Emulatorlogin {
    AndroidDriver<MobileElement> driver;
    Properties props;

    @Test
    public void lunch() throws InterruptedException, IOException {
        // Load the properties File
       /*  props = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "//application.properties");
        props.load(objfile); */

       //Users/swapnamudradas/Documents/JavaProjects/qa_appium/src/test/app-release.apk

        File f=new File("src");
        File apk=new File(f,"app-release.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.56.118:5555");
        caps.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());
        caps.setCapability("appWaitActivity", "*");
        // lunch app
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(1000);
       /*  // input credential
        driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Mobile Number']")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Mobile Number']")).setValue("7678046095");
        driver.findElement(By.xpath("//android.widget.EditText[@NAF='true']")).setValue("123456");
        Thread.sleep(300);
        driver.findElement(By.className("android.widget.ImageButton")).click();
        Thread.sleep(500); */
    
    }
}
