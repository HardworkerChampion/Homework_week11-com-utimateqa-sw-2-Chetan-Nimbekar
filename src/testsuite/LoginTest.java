package testsuite;

//3. Write down the following test into ‘LoginTest’ class

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {


    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test

    //userShouldNavigateToLoginPageSuccessfully *
    public void userShouldNavigateToLoginPageSuccessfully() {


        WebElement loginPagelink = driver.findElement(By.xpath("//ul/li//a[@href='/users/sign_in']"));
        loginPagelink.click();
        //* Verify the text ‘Welcome Back!’

        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2")).getText();

        Assert.assertEquals(expectedText, actualText);
        System.out.println(actualText);


    }

    //2. verifyTheErrorMessage
    @Test
    public void verifyTheErrorMessage() {
        //* click on the ‘Sign In’ link
        WebElement loginPagelink = driver.findElement(By.xpath("//ul/li//a[@href='/users/sign_in']"));
        loginPagelink.click();

        //* Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("Robert@gmail.com");
        //* Enter invalid password
        driver.findElement(By.name("user[password]")).sendKeys("Robert123");
        //* Click on Login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        //* Verify the error message ‘Invalid email or password.’


        String expectedErrorTextMessage = "Invalid email or password";
        String actualErrorTextMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals(expectedErrorTextMessage, actualErrorTextMessage);
        System.out.println(actualErrorTextMessage);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
