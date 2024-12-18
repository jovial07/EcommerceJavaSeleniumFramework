package com.ecommerce.testcases;

import com.ecommerce.pageobject.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_ProductPageTest extends BaseClass{
    @Test(enabled=true)
    public void VerifySearchProduct() throws IOException, InterruptedException {
        String searchKey = "Blouse";
        logger.info("\n***************TestCase Search Product started*****************");

        // Sign in to the page click on Sign in, which is defined in IndexPage class
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();
        logger.info("Clicked on Sigin");
        /*after clicking on login, it will go to myAccount page,create an object of myAccount class
        for the page and enter emailaddress to create an account
        */

        MyAccount myAcc = new MyAccount(driver);
        myAcc.registeredEmailAddress(readconfigObj.getUserName());
        logger.info("Entered registered email address");
        myAcc.registeredPassword(readconfigObj.getPassword());
        logger.info("Entered registered password");
        myAcc.clickOnSubmitLogin();
        logger.info("Clicked on submit button");

        //Enter searchkey in search box
        RegisteredUserAccount productPg = new RegisteredUserAccount(driver);
        productPg.EnterDataInSearchBox(searchKey);
        productPg.ClickOnSearchButton();
        Thread.sleep(5000);

        // Get Name of Searched Product
        SearchResultPage resultPg = new SearchResultPage(driver);

        String SearchResultProductname = resultPg.getSearchResultProductName();


        //Verify that correct Product is displaying after search

        if(SearchResultProductname.contains(searchKey))
        {
            logger.info("Search Product testcase - Passed");
            Assert.assertTrue(true);
            productPg.clickOnSignOut();

        }
        else
        {
            logger.info("Search Product testcase - Failed");
            captureScreenShot(driver,"VerifySearchProduct");
            Assert.assertTrue(false);

        }
        logger.info("***************TestCase Search Product ends*****************");
    }

    @Test(enabled = true)
    public void VerifyBuyProduct() throws InterruptedException, IOException {
        logger.info("\n***************TestCase Buy Product started*****************");
        String searchKey = "Blouse";

        // Sign in to the page click on Sign in, which is defined in IndexPage class
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();
        logger.info("Clicked on Sigin");
        /*after clicking on login, it will go to myAccount page,create an object of myAccount class
        for the page and enter emailaddress to create an account
        */

        MyAccount myAcc = new MyAccount(driver);
        myAcc.registeredEmailAddress(readconfigObj.getUserName());
        logger.info("Entered registered email address");
        myAcc.registeredPassword(readconfigObj.getPassword());
        logger.info("Entered registered password");
        myAcc.clickOnSubmitLogin();
        logger.info("Clicked on submit button");

        //Enter searchkey in search box
        RegisteredUserAccount productPg = new RegisteredUserAccount(driver);
        productPg.EnterDataInSearchBox(searchKey);
        productPg.ClickOnSearchButton();
        logger.info("Clicked on search button");
        Thread.sleep(5000);

        // Get Name of Searched Product
        SearchResultPage resultPg = new SearchResultPage(driver);
        //to perform Scroll on application using Selenium
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,450)", "");
//        Thread.sleep(5000);


        resultPg.ClickOnMore();
        logger.info("Clicked image");

        Thread.sleep(2000);

        //Enter Product page
        ProductPage productPage = new ProductPage(driver);

        productPage.setSize("L");
        Thread.sleep(2000);
        logger.info("size L is entered");

        productPage.setQuantityWanted("2");
        Thread.sleep(2000);
        logger.info("Quantity 2 is entered");

        productPage.clickOnAddToCart();
        Thread.sleep(5000);

       // to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        logger.info("Clicked on Add to cart");
        productPage.clickOnProceed();
        Thread.sleep(5000);
        logger.info("Clicked on proceed to checkout on product page");

        //Enter order summary page
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(driver);
        orderSummaryPage.clickOnProceedToCheckOut();
        Thread.sleep(5000);
        logger.info("Clicked on proceed to checkout on order summary page");

        //Enter order address page
        OrderAddressPage orderAddressPage = new OrderAddressPage(driver);
        orderAddressPage.clickOnProceedToCheckOut();
        Thread.sleep(5000);
        logger.info("Clicked on proceed to checkout on order address page");

        //Enter order shipping page
        OrderShippingPage orderShippingPage = new OrderShippingPage(driver);
        orderShippingPage.selectTermsOfServices();
        Thread.sleep(5000);
        logger.info("Clicked on selectTermsOfServices checkbox on Shipping page");

        orderShippingPage.clickOnProceedToCheckOut();
        Thread.sleep(5000);
        logger.info("Clicked on proceed to checkout on order Shipping page");

        OrderPaymentPage orderPaymentPage = new OrderPaymentPage(driver);
        orderPaymentPage.clickOnPayByCheque();
        Thread.sleep(5000);
        logger.info("Clicked on pay by cheque order payment page");

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.clickOnConfirmOrder();
        Thread.sleep(5000);
        logger.info("Clicked on confirmed order");

        String successMessage = orderConfirmationPage.getOrderSuccessMessage();
        System.out.println(successMessage);
        //String message = "Your order on My Shop is complete";
        orderConfirmationPage.clickOnSignOut();
        logger.info("User has logged out ");
       // System.out.println(driver.getTitle());
        System.out.println("Page title:"+indexPage.getPageTitle());
        if (indexPage.getPageTitle().equalsIgnoreCase("Login - My Shop")){
            Assert.assertTrue(true);
            logger.info("Page title is as expected");
        }else {
            logger.info("Page title does not match");
            captureScreenShot(driver, "VerifyBuyProduct");
            Assert.assertTrue(false);
        }

//        if (successMessage.equalsIgnoreCase(message)){
//            logger.info("VerifyBuyProduct passed ");
//            Assert.assertTrue(true);
//            Thread.sleep(5000);
////            orderConfirmationPage.clickOnSignOut();
////            logger.info("User logged out");
//        }else {
//            logger.info("VerifyBuyProduct failed ");
//            captureScreenShot(driver, "VerifyBuyProduct");
//            Assert.assertTrue(false);
//        }
        logger.info("\n***************TestCase Buy Product stopped*****************");
    }
}
