package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage {
    WebDriver driver;

    public OrderPaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // this = object of the class
    }
    @FindBy(xpath = "//a[@title='Pay by check.']")
    WebElement payByCheque;

    @FindBy(linkText = "Pay by bank wire")
    WebElement payByWire;

    public void clickOnPayByCheque(){
        payByCheque.click();
    }

    public void clickOnPayByWire(){
        payByWire.click();
    }

}
