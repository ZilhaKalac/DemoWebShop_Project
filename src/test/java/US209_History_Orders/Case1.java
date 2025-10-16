package US209_History_Orders;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.User;
import utility.BaseDriver;
import utility.JSONHelper;
import java.time.Duration;

public class Case1 {
    public static void main(String[] args) {

        // 1.step
        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        //2.step
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ico-login']")));
        actions.moveToElement(loginBtn).click().perform();

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password")));

        User user = JSONHelper.read("user203");
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-1 login-button']")));
        actions.moveToElement(login).click().perform();

        WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ico-logout']")));
        Assert.assertTrue("Logout link should not be visible.", logoutBtn.isDisplayed());

        // 3.step
        WebElement myAccountLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header-links']/ul/li/a[@class='account']")));
        actions.moveToElement(myAccountLink).click().perform();

        WebElement accountInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(.,'My account - Customer info')]")));
        Assert.assertTrue("Account info should not be visible", accountInfo.isDisplayed());

        // 4.step
        WebElement ordersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='list']/li[3]/a")));
        actions.moveToElement(ordersLink).click().perform();

        WebElement ordersCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(.,'My account - Orders')]")));
        Assert.assertTrue("Orders should not be visible",ordersCheck.isDisplayed());

        // 5.step
        WebElement orderListCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.order-list")));
        Assert.assertTrue("Order list should not be visible",orderListCheck.isDisplayed());

        WebElement ordersSectionCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-list .section.order-item")));
        Assert.assertTrue("Orders Section should not be visible",ordersSectionCheck.isDisplayed());

        // 6.step

        WebElement orderDetails = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.button-2.order-details-button")));
        actions.moveToElement(orderDetails).click().perform();

        WebElement detailsCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(.,'Order information')]")));
        Assert.assertTrue("Details should not be visible",detailsCheck.isDisplayed());

        WebElement areaCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-details-area")));
        Assert.assertTrue("Area should not be visible",areaCheck.isDisplayed());

        // 7.step
        WebElement invoiceDownload = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button-2 pdf-order-button']")));
        actions.moveToElement(invoiceDownload).click().perform();

        driver.quit();

    }
}
