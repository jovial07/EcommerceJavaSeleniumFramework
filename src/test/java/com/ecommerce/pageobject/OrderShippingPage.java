package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage {

    WebDriver driver;

    public OrderShippingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // this = object of the class
    }

    @FindBy(id = "cgv")
    WebElement termsOfService;

    @FindBy(name = "processCarrier")
    WebElement proceedShipping;

    public void selectTermsOfServices(){
        termsOfService.click();
    }

    public void clickOnProceedToCheckOut(){
        proceedShipping.click();
    }

}
