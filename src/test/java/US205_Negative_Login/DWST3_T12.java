package US205_Negative_Login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.User;
import utility.BaseDriver;
import utility.JSONHelper;

import java.time.Duration;

public class DWST3_T12 {
    public static void main(String[] args) {

             // test case: -> empty e-mail and current (true) password

            WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Actions actions = new Actions(driver);
            User user = JSONHelper.read("user2053");

        // 1. step
        WebElement logInButton = driver.findElement(By.cssSelector("a[href='/login']"));
        actions.moveToElement(logInButton).click().perform();

        // 2.step
        WebElement emailInput = driver.findElement(By.xpath("//input[@autofocus='autofocus']"));
        actions.moveToElement(emailInput).click().sendKeys(user.getEmail()).perform();

        // 3.step
        WebElement passwordInput = driver.findElement(By.xpath("//input[@class='password']"));
        actions.moveToElement(passwordInput).click().sendKeys(user.getPassword()).perform();

        // 4. step
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='buttons']/input[@class='button-1 login-button']"))));
        actions.moveToElement(loginBtn).click().perform();

        // 5. step
        WebElement errorText = driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));
        Assert.assertTrue("Kullanici login oldu", errorText.isDisplayed());

        driver.quit();
    }
    }

