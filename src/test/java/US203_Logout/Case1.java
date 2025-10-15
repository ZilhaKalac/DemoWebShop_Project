package US203_Logout;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.User;
import utility.JSONHelper;
import utility.BaseDriver;

import java.time.Duration;

public class Case1 {
    public static void main(String[] args) {
        // 1.step
        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='ico-login']"));
        actions.moveToElement(loginBtn).click().perform();

        WebElement emailInput = driver.findElement(By.id("Email"));
        WebElement passwordInput = driver.findElement(By.id("Password"));

        User user = JSONHelper.read("user203");
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());

        WebElement login = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(login).click().perform();

        // 2.step
        WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ico-logout']")));
        Assert.assertTrue("Logout link should not be visible.", logoutBtn.isDisplayed());

        actions.moveToElement(logoutBtn).click().perform();


        // 3.step
        WebElement loginCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ico-login']")));
        Assert.assertTrue("Login link should not be visible.", loginCheck.isDisplayed());

        // 4.step
        WebElement registerLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ico-register']")));
        Assert.assertTrue("Register link should not be visible.", registerLink.isDisplayed());

        driver.quit();
    }
}
