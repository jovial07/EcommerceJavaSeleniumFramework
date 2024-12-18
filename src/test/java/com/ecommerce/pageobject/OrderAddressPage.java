package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAddressPage {

    WebDriver driver;

    public OrderAddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // this = object of the class
    }

    @FindBy(name = "processAddress")
    WebElement proceedFromAddressPage;

    public void clickOnProceedToCheckOut(){
        proceedFromAddressPage.click();
    }
}
