package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreation {
    WebDriver driver;

    public AccountCreation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // this = object of the class
    }
    //Identify Webelements
    @FindBy(id = "id_gender1")
    WebElement titleMr;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    //Actions methods for operation on all the webelements
    public void selectTitle()
    {
        titleMr.click();
    }

    public void enterFirstname(String fName)
    {
        firstName.clear();
        firstName.sendKeys(fName);
    }
    public void enterLastname(String lName)
    {
        lastName.clear();
        lastName.sendKeys(lName);
    }
    public void enterPassword(String pwd)
    {
        password.clear();
        password.sendKeys(pwd);
    }
    public void clickOnRegister()
    {
        registerButton.click();
    }
}
