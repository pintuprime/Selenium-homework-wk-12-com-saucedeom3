package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl ="https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //* Enter “standard_user” username
       sendTextToElement(By.id("user-name"),"standard_user");

       //* Enter “secret_sauce” password
        sendTextToElement(By.name("password"),"secret_sauce");

        //click on login button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        //* Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = getTextFromElement(By.xpath("//span[@class='title']"));
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //* Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");

        //* Enter “secret_sauce” password
        sendTextToElement(By.name("password"), "secret_sauce");

        //click on login button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        verifyNumberFromElement(By.className("inventory_item"),6);


    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
