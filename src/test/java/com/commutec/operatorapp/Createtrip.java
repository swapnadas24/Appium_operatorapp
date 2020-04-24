package com.commutec.operatorapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Createtrip extends Login {

        // Create trip
        @Test
        public void tripCreate() throws InterruptedException {
                driver.findElement(By.xpath(props.getProperty("menuTab"))).click();
                Thread.sleep(1000);
                Assert.assertTrue(driver.findElement(By.xpath(props.getProperty("click_Menu"))).isDisplayed(),
                                "Create Trip pop-up is not displaying");
                driver.findElement(By.xpath(props.getProperty("trip_Create"))).click();
                Thread.sleep(200);
                Assert.assertTrue(driver.findElement(By.xpath(props.getProperty("create_screen"))).isDisplayed(),
                                "Trip creation screen is not displaying");

                // Select Date, Trip Typ and Shift Type
                driver.findElement(By.xpath(props.getProperty("date"))).click();
                Assert.assertTrue(driver.findElement(By.xpath(props.getProperty("date_picker"))).isDisplayed(),
                                "Date picker is not displaying");
                driver.findElement(By.xpath(props.getProperty("today_date"))).click();
                driver.findElement(By.xpath(props.getProperty("OK_tab"))).click();
                driver.findElement(By.xpath(props.getProperty("shift_Type"))).click();
                driver.findElement(By.xpath(props.getProperty("shift"))).click();
                Thread.sleep(300);
                // Add Employeee
                driver.findElement(By.xpath(props.getProperty("add_Emp"))).click();
                Assert.assertTrue(driver.findElement(By.xpath(props.getProperty("emp_SearchBar"))).isDisplayed(),
                                "Employee search screen not be visible");
                driver.findElement(By.xpath(props.getProperty("emp_SearchBar"))).click();
                Thread.sleep(2000);
                // Enter employee name
                driver.findElement(By.xpath(props.getProperty("emp_SearchBar"))).setValue("swa");
                Thread.sleep(1000);
                driver.findElement(By.xpath(props.getProperty("emp_Name"))).click();
                // click to back icon
                driver.findElement(By.xpath(props.getProperty("back_Icon"))).click();

                // Check employee is selected or not
                Assert.assertTrue(driver.findElement(By.xpath(props.getProperty("emp_Selected"))).isDisplayed(),
                                "Employee didn't selected");
                Thread.sleep(500);
                // Assign Vehicle
                driver.findElement(By.xpath(props.getProperty("assign_Vehicle"))).click();
                Assert.assertTrue(driver.findElement(By.xpath(props.getProperty("vehicle_list"))).isDisplayed(),
                                "Vehicle list is not displaying");
                Thread.sleep(1000);
                // create new Vehicle
                driver.findElement(By.xpath(props.getProperty("add_VehicleTab"))).click();
                driver.findElement(By.xpath(props.getProperty("vehicle_registarationNo")))
                                .setValue(faker.address().state().toUpperCase().substring(0, 2)
                                                + faker.number().digits(2)
                                                + faker.address().city().toUpperCase().substring(0, 2)
                                                + faker.number().digits(4));
                // Check assert registrion number selected
                Assert.assertTrue(driver.findElement(By.xpath(props.getProperty("vehicle_selected"))).isDisplayed(),
                                "Registration number is not not selected");
                // add "Make & Model"
                driver.findElement(By.xpath(props.getProperty("make_model"))).click();
                driver.findElement(By.xpath(props.getProperty("make_model_selected"))).click();
                Thread.sleep(500);
                // add "Vehicle_Type"
                driver.findElement(By.xpath(props.getProperty("vehicle_type"))).click();
                driver.findElement(By.xpath(props.getProperty("vehicle_type_selected"))).click();
                Thread.sleep(300);
                // add "Seater"
                driver.findElement(By.xpath(props.getProperty("seating_capacity"))).click();
                driver.findElement(By.xpath(props.getProperty("seating_capacity_selected"))).click();
                Thread.sleep(500);
                // add "Color"
                driver.findElement(By.xpath(props.getProperty("color_Vehicle"))).click();
                driver.findElement(By.xpath(props.getProperty("color_selected"))).click();
                Thread.sleep(300);
                // add "Fuel"
                driver.findElement(By.xpath(props.getProperty("fuel_selected"))).click();
                Thread.sleep(300);
                swipeToBottom();
                driver.findElement(By.xpath(props.getProperty("create_tab"))).click();
                // click assign vehicle and assert if new vehicle has created
                driver.findElement(By.xpath(props.getProperty("assign_Vehicle"))).click();
                for(int i= 0;i<=n; i++){
                        
                }

               /*  Assert.assertTrue(driver.findElement(By.xpath(props.getProperty("vehicle_created"))).isDisplayed(),
                                "Vehicle couldn't be created successfully"); */

        }

        public void swipeToBottom() {
                Dimension dim = driver.manage().window().getSize();
                int height = dim.getHeight();
                int width = dim.getWidth();
                int x = width / 2;
                int top = (int) (height * 0.80);
                int bottom = (int) (height * 0.20);
                new TouchAction(driver).press(PointOption.point(x, top)).waitAction()
                                .moveTo(PointOption.point(x, bottom)).release().perform();

        }

}
