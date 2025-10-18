package US208_Negative_Gift_Cards_and_Coupons;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.User;
import utility.BaseDriver;
import utility.JSONHelper;

import java.time.Duration;

public class DWST3_T3 {

    public static void main(String[] args) {
        WebDriver driver= BaseDriver.driver("https://demowebshop.tricentis.com/");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement elementHomePage= driver.findElement(By.xpath("//div[@class='header-logo']/a/img"));
        wait.until(ExpectedConditions.visibilityOf(elementHomePage));
        Assert.assertTrue("Home page acilmadi!", elementHomePage.isDisplayed());

        WebElement loginBtn= driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginBtn.click();
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
        computersBtn.click();
        WebElement computerPageText=driver.findElement(By.xpath("//div[@class='breadcrumb']/ul/li[2]/strong"));
        Assert.assertTrue("Bilgisayarlar sayfasi acilmadi",computerPageText.isDisplayed());

        //div[@class='page category-page']/div[@class='page-body']/div[@class='sub-category-grid']/div[@class='item-box']/following-sibling::div/div/h2/a
        WebElement notebooksBtn=driver.findElement(By.xpath("//div[@class='page category-page']/div[@class='page-body']/div[@class='sub-category-grid']/div[@class='item-box']/following-sibling::div/div/h2/a"));
        notebooksBtn.click();
        WebElement notebooksPage=driver.findElement(By.xpath("//div[@class='breadcrumb']/ul/li[3]/strong"));
        Assert.assertTrue("Notebook sayfasi acilmadi",notebooksPage.isDisplayed());

        WebElement addToCartBtn= driver.findElement(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']"));
        addToCartBtn.click();
        WebElement shoppingCartBtn= driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        shoppingCartBtn.click();
        WebElement shoppingcartPAGEtext= driver.findElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertTrue("Shopping cart page acilmadi !",shoppingcartPAGEtext.isDisplayed());

        WebElement applyCuponBtn=driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        applyCuponBtn.click();
        WebElement applyMessageText=driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue("Kupon mesaji goruntulenmedi!",applyMessageText.isDisplayed());

        WebElement giftCardBtn= driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        giftCardBtn.click();
        WebElement giftCardMessageText=driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue("Gift kart mesaji goruntulenmedi",giftCardMessageText.isDisplayed());

        WebElement termsOfServiceBox= driver.findElement(By.xpath("//input[@id='termsofservice']"));
        termsOfServiceBox.click();
        WebElement checkOutBtn= driver.findElement(By.xpath("//button[@id='checkout']"));
        checkOutBtn.click();
        WebElement checkOutPAGEtext= driver.findElement(By.xpath("//h1[contains(text(),Checkout)]"));
        Assert.assertTrue("Checkout page acilmadi",checkOutPAGEtext.isDisplayed());

        WebElement billingAddressContinueBtn= driver.findElement(By.xpath("//input[@onclick='Billing.save()']"));
        billingAddressContinueBtn.click();
        WebElement shippingAddressContinueBtn=driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
        shippingAddressContinueBtn.click();
        WebElement shippingMethodContinueBtn=driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));
        shippingMethodContinueBtn.click();
        WebElement creditCardBox=driver.findElement(By.xpath("//input[@value='Payments.Manual']"));
        creditCardBox.click();
        WebElement paymentMethodContinueBtn=driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        paymentMethodContinueBtn.click();
        WebElement dropdownPaymentLIST = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
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
        paymentInfoContinue.click();
        WebElement confirmOrderBtn=driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        confirmOrderBtn.click();
        String expectedTextFinal="Your order has been successfully processed!";
        WebElement actualTextFinalElement=driver.findElement(By.xpath("//strong[contains(text(),'Your')]"));
        String actualTextFinal=actualTextFinalElement.getText();
        Assert.assertEquals("Siparis tamamlanamadi!",expectedTextFinal,actualTextFinal);

        WebElement orderFinishContinueBtn=driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']"));
        orderFinishContinueBtn.click();
        driver.quit();
    }
    
}
