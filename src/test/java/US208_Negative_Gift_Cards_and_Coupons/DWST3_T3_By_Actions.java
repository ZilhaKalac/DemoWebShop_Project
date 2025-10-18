package US208_Negative_Gift_Cards_and_Coupons;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.User;
import utility.BaseDriver;
import utility.JSONHelper;

import java.time.Duration;

public class DWST3_T3_By_Actions {

    public static void main(String[] args) {
        WebDriver driver= BaseDriver.driver("https://demowebshop.tricentis.com/");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        Actions actions=new Actions(driver);

        WebElement elementHomePage= driver.findElement(By.xpath("//div[@class='header-logo']/a/img"));
        wait.until(ExpectedConditions.visibilityOf(elementHomePage));
        Assert.assertTrue("Home page acilmadi!", elementHomePage.isDisplayed());

        WebElement loginBtn= driver.findElement(By.xpath("//a[@class='ico-login']"));
        actions.moveToElement(loginBtn).click().perform();
        WebElement loginPageText= driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertTrue("Login Sayfasi acilmadi",loginPageText.isDisplayed());

        User user= JSONHelper.read("user208");
        final String email=user.getEmail();
        final String password= user.getPassword();
        final String firstName= user.getFirstname();

        WebElement emailInput= driver.findElement(By.id("Email"));
        WebElement passwordInput= driver.findElement(By.id("Password"));
        WebElement loginBtn2=driver.findElement(By.xpath("//div[@class='form-fields']/form/div[@class='buttons']/input"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBtn2.click();

        String expectedText= user.getEmail();
        WebElement actualTextElement=driver.findElement(By.xpath("//div[@class='header-links-wrapper']/div/ul/li/a"));
        String actualText= actualTextElement.getText();
        Assert.assertEquals("Email uyumsuz!",expectedText,actualText);

        WebElement computersBtn=driver.findElement(By.xpath("//ul[@class='top-menu']/li[2]/a"));
        actions.moveToElement(computersBtn).click().perform();
        WebElement computerPageText=driver.findElement(By.xpath("//div[@class='breadcrumb']/ul/li[2]/strong"));
        Assert.assertTrue("Bilgisayarlar sayfasi acilmadi",computerPageText.isDisplayed());

        //div[@class='page category-page']/div[@class='page-body']/div[@class='sub-category-grid']/div[@class='item-box']/following-sibling::div/div/h2/a
        WebElement notebooksBtn=driver.findElement(By.xpath("//div[@class='page category-page']/div[@class='page-body']/div[@class='sub-category-grid']/div[@class='item-box']/following-sibling::div/div/h2/a"));
        actions.moveToElement(notebooksBtn).click().perform();
        WebElement notebooksPage=driver.findElement(By.xpath("//div[@class='breadcrumb']/ul/li[3]/strong"));
        Assert.assertTrue("Notebook sayfasi acilmadi",notebooksPage.isDisplayed());

        WebElement addToCartBtn= driver.findElement(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']"));
        actions.moveToElement(addToCartBtn).click().perform();
        WebElement shoppingCartBtn= driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        actions.moveToElement(shoppingCartBtn).click().perform();
        WebElement shoppingcartPAGEtext= driver.findElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertTrue("Shopping cart page acilmadi !",shoppingcartPAGEtext.isDisplayed());

        WebElement applyCuponBtn=driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        actions.moveToElement(applyCuponBtn).click().perform();
        WebElement applyMessageText=driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue("Kupon mesaji goruntulenmedi!",applyMessageText.isDisplayed());

        WebElement giftCardBtn= driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        actions.moveToElement(giftCardBtn).click().perform();
        WebElement giftCardMessageText=driver.findElement(By.xpath("//div[@class='message']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message']")));
        Assert.assertTrue("Gift kart mesaji goruntulenmedi",giftCardMessageText.isDisplayed());

        WebElement termsOfServiceBox= driver.findElement(By.xpath("//input[@id='termsofservice']"));
        actions.moveToElement(termsOfServiceBox).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(termsOfServiceBox));
        WebElement checkOutBtn= driver.findElement(By.xpath("//button[@id='checkout']"));
        checkOutBtn.click();
        BaseDriver.threadWait(3);

        WebElement checkOutPAGEtext= driver.findElement(By.xpath("//h1[contains(text(),Checkout)]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),Checkout)]")));
        Assert.assertTrue("Checkout page acilmadi",checkOutPAGEtext.isDisplayed());

        WebElement billingAddressContinueBtn= driver.findElement(By.xpath("//input[@onclick='Billing.save()']"));
        wait.until(ExpectedConditions.visibilityOf(billingAddressContinueBtn));
        actions.moveToElement(billingAddressContinueBtn).click().perform();

        WebElement shippingAddressContinueBtn=driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
        wait.until(ExpectedConditions.visibilityOf(shippingAddressContinueBtn));
        actions.moveToElement(shippingAddressContinueBtn).click().perform();

        WebElement shippingMethodContinueBtn=driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));
        wait.until(ExpectedConditions.visibilityOf(shippingMethodContinueBtn));
        actions.moveToElement(shippingMethodContinueBtn).click().perform();

        WebElement creditCardBox=driver.findElement(By.xpath("//input[@value='Payments.Manual']"));
        wait.until(ExpectedConditions.visibilityOf(creditCardBox));
        BaseDriver.threadWait(3);
        actions.moveToElement(creditCardBox).click().perform();

        BaseDriver.threadWait(3);
        WebElement paymentMethodContinueBtn=driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        paymentMethodContinueBtn.click();

        BaseDriver.threadWait(3);
        WebElement dropdownPaymentLIST = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
        wait.until(ExpectedConditions.visibilityOf(dropdownPaymentLIST));

        Select select=new Select(dropdownPaymentLIST);
        select.selectByValue("Visa");
        WebElement cardHolderNameBox=driver.findElement(By.xpath("//input[@id='CardholderName']"));

        cardHolderNameBox.sendKeys(firstName);
        WebElement cardNumberBox=driver.findElement(By.xpath("//input[@id='CardNumber']"));
        cardNumberBox.sendKeys("4242424242424242");
        WebElement exDateMonth=driver.findElement(By.xpath("//select[@id='ExpireMonth']"));
        Select select1=new Select(exDateMonth);
        select1.selectByVisibleText("01");
        WebElement exDateYear=driver.findElement(By.xpath("//select[@id='ExpireYear']"));
        Select select2=new Select(exDateYear);
        select2.selectByVisibleText("2032");
        WebElement cardCodeBox=driver.findElement(By.xpath("//input[@id='CardCode']"));
        cardCodeBox.sendKeys("123");
        WebElement paymentInfoContinue= driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));
        wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinue));
        actions.moveToElement(paymentInfoContinue).click().perform();

        WebElement confirmOrderBtn=driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn));
        actions.moveToElement(confirmOrderBtn).click().perform();

        String expectedTextFinal="Your order has been successfully processed!";
        WebElement actualTextFinalElement=driver.findElement(By.xpath("//strong[contains(text(),'Your')]"));
        String actualTextFinal=actualTextFinalElement.getText();
        Assert.assertEquals("Siparis tamamlanamadi!",expectedTextFinal,actualTextFinal);

        WebElement orderFinishContinueBtn=driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']"));
        wait.until(ExpectedConditions.elementToBeClickable(orderFinishContinueBtn));
        actions.moveToElement(orderFinishContinueBtn).click().perform();

        driver.quit();
    }
    
}
