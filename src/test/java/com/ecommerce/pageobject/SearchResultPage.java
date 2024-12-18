package com.ecommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    WebDriver driver;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);//driver that will be used to lookup the web element
    }
    //Identify the elements present in search result page
    @FindBy(xpath = "//a[@title='Blouse'][normalize-space()='Blouse']")
    WebElement searchResultProduct;

    @FindBy(xpath = "//img[@title='Blouse']")
    WebElement blouseImage;


    //action methods on web elements of search result page

    public String getSearchResultProductName()
    {
        String resultProduct = searchResultProduct.getText();
        return resultProduct;
    }
    public void ClickOnMore(){
//        Actions actions = new Actions(driver);
//        actions.moveToElement(more).perform();
        blouseImage.click();

    }

}
