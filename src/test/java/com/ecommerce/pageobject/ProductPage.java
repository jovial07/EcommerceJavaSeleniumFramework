package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // this = object of the class
    }

    //Identify web elements present in the page
    @FindBy(id = "group_1")
    WebElement size;

    @FindBy(id = "quantity_wanted")
    WebElement quantityWanted;

    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCart;

    @FindBy(linkText = "Proceed to checkout")
    WebElement proceed;

    //Create Actions methods


    public void setQuantityWanted(String quantity) {
        quantityWanted.clear();
        quantityWanted.sendKeys(quantity);
    }

    public void setSize(String sizeType) {
        //Aas its a dropdown hence, use select class
        Select oSelect = new Select(size);
        oSelect.selectByVisibleText(sizeType);

    }

    public void clickOnAddToCart(){
        addToCart.click();
    }

    public void clickOnProceed(){
        proceed.click();
    }
}
