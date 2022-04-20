package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){ openBrowser(baseUrl);}

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials(){
        // Valid username in username field
        WebElement username = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"));
        username.sendKeys("vpatel47");
        // Valid password in password field
        WebElement password = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"));
        password.sendKeys("123456");
        // Click the login button
        WebElement loginbutton = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        loginbutton.click();
        // Expected text upon opening an account successfully
        String expectedText = "Accounts Overview";
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]")).getText();
        // Verify the expected and actual text
        Assert.assertEquals("Accounts Overview", expectedText, actualText);
        driver.close();
    }
    @Test
    public void verifyUserShouldNotLoginSuccessfullyWithInvalidCredentials(){
        // Invalid username in username field
        WebElement username = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"));
        username.sendKeys("xyz1");
        // Invalid password in password field
        WebElement password = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"));
        password.sendKeys("abcd12345");
        // Click the login button
        WebElement loginbutton = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        loginbutton.click();
        // Expected text upon clicking login button
        String actualText = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]")).getText();
        String expectedText = "The username and password could not be verified.";
        // Verify the expected and actual text
        Assert.assertEquals("The username and password could not be verified.", expectedText, actualText);
        driver.close();
    }
    @Test
    public void verifyUserShouldLogoutSuccessfullyWithValidCredentials() {
        // Valid username in username field
        WebElement username = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"));
        username.sendKeys("vpatel47");
        // Valid password in password field
        WebElement password = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"));
        password.sendKeys("123456");
        // Click the login button
        WebElement loginbutton = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        loginbutton.click();
        // Click the logout button
        WebElement logoutbutton = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        logoutbutton.click();
        // Expected text upon logout an account successfully
        String expectedText = "Customer Login";
        String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]")).getText();
        // Verify the expected and actual text
        Assert.assertEquals("Customer Login", expectedText, actualText);
        // Close the browser
       driver.close();
    }

}
