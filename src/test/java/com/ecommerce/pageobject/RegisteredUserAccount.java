package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
    WebDriver driver;

    public RegisteredUserAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // this = object of the class
    }

    //Identify user
    @FindBy(xpath = "//a[@title='View my customer account']")
    WebElement userName;

    @FindBy(linkText = "Sign out")
    WebElement signOut;

    @FindBy(name ="search_query")
    WebElement searchBox;

    @FindBy(name ="submit_search")
    WebElement submit_search;

    @FindBy(linkText = "Women")
    WebElement WomenMenu;

    @FindBy(linkText="Blouses")
    WebElement Blouses;


    public String getUserName(){
        String userNameText = userName.getText();
        return userNameText;
    }
    public void clickOnSignOut(){
        signOut.click();
    }

    public void EnterDataInSearchBox(String searchKey)
    {
        searchBox.sendKeys(searchKey);
    }

    public void ClickOnSearchButton()
    {
        submit_search.click();

    }

    public void MouseOverTShirtMenu()
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(WomenMenu).moveToElement(Blouses).click().perform();
    }

}
