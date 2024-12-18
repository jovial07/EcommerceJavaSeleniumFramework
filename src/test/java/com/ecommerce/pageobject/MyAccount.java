package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

    WebDriver driver;
    public MyAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // this = object of the class
    }

    // Identify all Webelements
    @FindBy(id = "email_create")
    WebElement createEmailId;

    @FindBy(id = "SubmitCreate")
    WebElement createAnAccountButton;

    @FindBy(id = "email")
    WebElement registeredUserEmail;

    @FindBy(id = "passwd")
    WebElement registeredUserPassword;

    @FindBy(id = "SubmitLogin")
    WebElement submitLogin;

    // Actions on the webelemets
    // Enter email in Email Address field to register an account
    public void enterEmailAddress(String email) {

        createEmailId.sendKeys(email);
    }

    // Click on SubmitCreate button
    public void clickOnSubmitCreate() {

        createAnAccountButton.click();
    }

    // Enter registered email in ALREADY REGISTERED? email address field
    public void registeredEmailAddress(String email) {
        registeredUserEmail.sendKeys(email);
    }

    // Enter registered password in ALREADY REGISTERED? password field
    public void registeredPassword(String password) {
        registeredUserPassword.sendKeys(password);
    }

    // Click on Sign in button
    public void clickOnSubmitLogin() {
        submitLogin.click();
    }
}
