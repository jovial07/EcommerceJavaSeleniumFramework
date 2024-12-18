package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    //Create object of WebDriver
    WebDriver driver;

    //When an object of a class is created then constructor is invoked
    public IndexPage(WebDriver driver) {
        this.driver = driver;
        //driver is used to search webelements
        PageFactory.initElements(driver, this); //this = object of the page
    }

    //Identify all web elements on the page
    //In pagefactory, @FindBy() is used to identify webelements
    @FindBy(xpath = "//a[normalize-space()='Sign in']")//linkText=locator type
    WebElement signIn;

    //Perform Actions on the respective webelements on the page
    public void clickOnSignIn() {

        signIn.click();
    }
    public String getPageTitle(){
        return driver.getTitle();
    }

}
