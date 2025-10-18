package US207_Survey_Response;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.User;
import utility.BaseDriver;
import utility.JSONHelper;

import java.time.Duration;

public class DWST3_T8 {
    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='ico-login']"));
        actions.moveToElement(loginBtn).click().perform();

        WebElement emailInput = driver.findElement(By.id("Email"));
        WebElement passwordInput = driver.findElement(By.id("Password"));

        User user = JSONHelper.read("user207");
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());

        WebElement login = driver.findElement(By.cssSelector("input[value='Log in']"));
        actions.moveToElement(login).click().perform();

        WebElement surveyTitle = driver.findElement(By.xpath("//div[@class='block block-poll']/div[1]"));
        Assert.assertTrue("Anket bulunamadı", surveyTitle.isDisplayed());

        try {
            WebElement voteButton = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
            System.out.println("Henüz oy kullanılmamış, oy verme işlemi yapılabilir.");

            WebElement goodOption = driver.findElement(By.xpath("//input[@id='pollanswers-2']"));
            actions.moveToElement(goodOption).click().perform();

            actions.moveToElement(voteButton).click().perform();

        } catch (NoSuchElementException e) {

            System.out.println("Daha önce oy kullanmış, sonuç sayfası gösteriliyor.");
        }

        WebElement resultPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='poll-results']")));
        Assert.assertTrue("Sonuç sayfası açılmadı", resultPage.isDisplayed());

        System.out.println("Anket sonuç sayfası doğrulandı.");

        driver.quit();

    }
}
