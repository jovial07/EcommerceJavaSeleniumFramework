package com.ecommerce.testcases;

import com.ecommerce.pageobject.AccountCreation;
import com.ecommerce.pageobject.IndexPage;
import com.ecommerce.pageobject.MyAccount;
import com.ecommerce.pageobject.RegisteredUserAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_MyAccount extends BaseClass{
    @Test(enabled = false)
    public void verifyRegistrationandLogin(){
        //Open URL
//        driver.get(url);// This is common for all the test cases hence shifted to base class, this is defined in base class
//        logger.info("URL opened");

        // Sign in to the page click on Sign in, which is defined in IndexPage class
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();
        logger.info("Clicked on Sigin");
        /*after clicking on login, it will go to myAcacount page,create an object of myAccount class
        for the page and enter emailaddress to create an account
        */
        MyAccount myAcc = new MyAccount(driver);
        myAcc.enterEmailAddress("1022y001@alp.com");
        logger.info("Entered email address");

        // click on Create and Account button
        myAcc.clickOnSubmitCreate();
        logger.info("Clicked on Submitcreate button");

        //Enter personal details of the user
        //-----------------------------------
        AccountCreation accountCreation = new AccountCreation(driver);

        accountCreation.selectTitle();
        logger.info("Mr. title selected");

        accountCreation.enterFirstname("Ajay");
        logger.info("First name entered");

        accountCreation.enterLastname("Puri");
        logger.info("Last name entered");

        accountCreation.enterPassword("123456");
        logger.info("Password entered");

        accountCreation.clickOnRegister();
        logger.info("Clicked on Register button");
    }
    //Verify Login user
    @Test(enabled = true)
    public void verifyLogin() throws IOException {
        logger.info("Verify registered user is able to login");

        IndexPage indexPg = new IndexPage(driver);
        indexPg.clickOnSignIn();
        logger.info("Clicked on Sigin");

        // create an object of myAccount class for the page
        MyAccount myAcc = new MyAccount(driver);
        myAcc.registeredEmailAddress(readconfigObj.getUserName());
        logger.info("Entered registered email address");
        myAcc.registeredPassword(readconfigObj.getPassword());
        logger.info("Entered registered password");
        myAcc.clickOnSubmitLogin();
        logger.info("Clicked on submit button");

        // --confirm message is displayed
//        confirmAccountEcommerce cAccount = new confirmAccountEcommerce(driver);
//        String messageDisplayed = cAccount.messageDisplayed();
//        if (messageDisplayed.equals("Welcome to your account. Here you can manage all of your personal information and orders.")) {
//            logger.info("Verified New Account created");
//            Assert.assertTrue(true);
//        } else {
//            logger.info("Verified New Account not created");
//            captureScreenShot(driver, "verifyLogin");
//            Assert.assertTrue(false);
//        }
        //Verify Username
        RegisteredUserAccount userAccount = new RegisteredUserAccount(driver);
        String userName = userAccount.getUserName();
//        Assert.assertEquals(userName, "Jyotipal Hira");
//        logger.info("Username verification");
        if (userName.equalsIgnoreCase("Jyotipal Hira")){
            logger.info("Verify Login passed");
            captureScreenShot(driver, "verifyLogin");
            Assert.assertTrue(true);
        }else {
            logger.info("Verify login failed");
            captureScreenShot(driver, "verifyLogin");
            Assert.assertTrue(false);
        }
    }
}
