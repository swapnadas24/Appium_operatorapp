package com.commutec.operatorapp;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

class CreateNewVehicle extends Createtrip {
    // create new Vehicle
    @AfterMethod
    public void newVehicle() {
        driver.findElement(By.xpath(props.getProperty("add_VehicleTab"))).click();
    }

}