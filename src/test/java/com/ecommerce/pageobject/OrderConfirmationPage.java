package com.ecommerce.pageobject;

import org.checkerframework.common.reflection.qual.ForName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    WebDriver driver;

    public OrderConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // this = object of the class
    }

    @FindBy(xpath = "//span[normalize-space()='I confirm my order']")
    WebElement confirmOrder;

    @FindBy(xpath = "//div[@id='center_column']/p[@class='alert alert-success']")
    WebElement successAlert;

    @FindBy(linkText = "Sign out")
    WebElement signOut;

    public void clickOnConfirmOrder(){
        confirmOrder.click();
    }

    public String getOrderSuccessMessage(){
        String successMessage = successAlert.getText();
        return successMessage;
    }

    public void clickOnSignOut(){
        signOut.click();
    }
}
