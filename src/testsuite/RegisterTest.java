package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){ openBrowser(baseUrl);}

    @Test
    public void verifyThatSigningUpPageDisplay(){
        // Requested information to create registration
        WebElement register = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        register.click();

        String expectedText = "Signing up is easy!";
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]")).getText();

        WebElement firstname = driver.findElement(By.xpath("//input[@id='customer.firstName']"));
        firstname.sendKeys("Vimal");

        WebElement lastname = driver.findElement(By.xpath("//input[@id='customer.lastName']"));
        lastname.sendKeys("Patel");

        WebElement address = driver.findElement(By.xpath("//input[@id='customer.address.street']"));
        address.sendKeys("138 Church Street");

        WebElement city = driver.findElement(By.xpath("//input[@id='customer.address.city']"));
        city.sendKeys("London");

        WebElement state = driver.findElement(By.xpath("//input[@id='customer.address.state']"));
        state.sendKeys("Middx");

        WebElement postcode = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
        postcode.sendKeys("NW8 8EX");

        WebElement phoneno = driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
        phoneno .sendKeys("020 7723 5205");

        WebElement ssn = driver.findElement(By.xpath("//input[@id='customer.ssn']"));
        ssn.sendKeys("VP 37 95 95 D");

        WebElement username = driver.findElement(By.xpath("//input[@id='customer.username']"));
        username .sendKeys("vpatel47");

        WebElement password = driver.findElement(By.xpath("//input[@id='customer.password']"));
        password .sendKeys("123456");

        WebElement confirm = driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
        confirm .sendKeys("123456");

        WebElement REGISTER = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        REGISTER.click();

       String actualTest = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]")).getText();
       String expectedTest = "Your account was created successfully. You are now logged in.";

        Assert.assertEquals("Your account was created successfully. You are now logged in.", expectedText, actualText);

       driver.quit();


    }


}
