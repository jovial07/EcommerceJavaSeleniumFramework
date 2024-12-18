package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
    WebDriver driver;

    public OrderSummaryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // this = object of the class
    }

    @FindBy(linkText = "Proceed to checkout")
    WebElement proceed;

    public void clickOnProceedToCheckOut(){
        proceed.click();
    }
}
