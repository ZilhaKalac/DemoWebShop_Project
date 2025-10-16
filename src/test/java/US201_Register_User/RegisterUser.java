package US201_Register_User;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.User;
import utility.BaseDriver;
import utility.JSONHelper;

import java.time.Duration;

public class RegisterUser {
    public static void main(String[] args) {

        //UYARI:Kodları çalıştırmadan önce user201.json dosyasındaki, kayıt için gerekli olan ve
        // daha önceden kullanılmamış bilgileri giriniz.

        // Step 1
        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        Actions actions = new Actions(driver);
        User user = JSONHelper.read("user201");

        //Step 2

        WebElement registerBtn1 = driver.findElement(By.xpath("//a[@class='ico-register']"));
        actions.moveToElement(registerBtn1).click().perform();

        //Step 3
        WebElement genderFemaleInput = driver.findElement(By.xpath("//input[@id='gender-female']"));
        actions.moveToElement(genderFemaleInput).click().perform();

        BaseDriver.threadWait(2);

        WebElement genderMaleInput = driver.findElement(By.xpath("//input[@id='gender-male']"));
        actions.moveToElement(genderMaleInput).click().perform();

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='FirstName']"));
        actions.moveToElement(firstNameInput).click().perform();
        firstNameInput.sendKeys(user.getFirstname());

        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='LastName']"));
        actions.moveToElement(lastNameInput).click().perform();
        lastNameInput.sendKeys(user.getLastname());

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='Email']"));
        actions.moveToElement(emailInput).click().perform();
        emailInput.sendKeys(user.getEmail());

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='Password']"));
        actions.moveToElement(passwordInput).click().perform();
        passwordInput.sendKeys(user.getPassword());

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        actions.moveToElement(confirmPasswordInput).click().perform();
        confirmPasswordInput.sendKeys(user.getPassword());

        //Step 4
        WebElement registerBtn2 = driver.findElement(By.xpath("//input[@id='register-button']"));
        actions.moveToElement(registerBtn2).click().perform();

        //Step 5
        WebElement successfulRegistrationMessage=driver.findElement(By.xpath("//div[@class='result']"));
        Assert.assertTrue("Kaydınız tamamlanmıştır mesajı görüntülenmedi ",successfulRegistrationMessage.isDisplayed());


        driver.quit();
    }
}
