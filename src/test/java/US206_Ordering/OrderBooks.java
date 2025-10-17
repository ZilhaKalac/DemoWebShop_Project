package US206_Ordering;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pojo.Creditcard;
import pojo.User;
import utility.BaseDriver;
import utility.JSONHelper;


import java.time.Duration;

public class OrderBooks {
    public static void main(String[] args) {
        WebDriver driver= BaseDriver.driver("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        User user= JSONHelper.read("user206");
        Creditcard user1 = JSONHelper.read1("user206(2)");
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(1));

        //Step 1
        WebElement loginButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='header-links']/ul/li[2]")));
        actions.
                click(loginButton)
                .build()
                .perform();

        //Step 2
        WebElement emailInput= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='inputs']/input[@id='Email']")));

        actions.click(emailInput)
                .sendKeys(user.getEmail())
                .build()
                .perform();


        // Step 3
        WebElement passwordInput= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='inputs']/input[@name='Password']")));

        actions.click(passwordInput)
                .sendKeys(user.getPassword())
                .build()
                .perform();

        // Step 4
        WebElement logInBttn= driver.findElement(By.xpath("//div[@class='buttons']/input[@class='button-1 login-button']"));

        actions
                .click(logInBttn)
                .build()
                .perform();


        // Step 5
       WebElement booksbuttn= driver.findElement(By.xpath("//ul[@class='top-menu']/li[1]/a"));

       actions
               .click(booksbuttn)
               .build()
               .perform();


       // Step 6
       WebElement addToCart= driver.findElement(By.xpath("//html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[3]/div[2]/input"));

       actions
               .click(addToCart)
               .build()
               .perform();

       // Step 7
       WebElement moveToShoppingCart= driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]"));

       actions
               .click(moveToShoppingCart)
               .build()
               .perform();


       // Step 8
      WebElement selectCountry=driver.findElement(By.xpath("//*[@id=\"CountryId\"]"));
      Select select=new Select(selectCountry);
      select.selectByVisibleText("Select country");
        select.selectByVisibleText("United States");
        actions
               .click(selectCountry)
               .build()
               .perform();


        // Step 9
        WebElement state= driver.findElement(By.xpath("//*[@id=\"StateProvinceId\"]"));
        Select select1=new Select(state);
        select1.selectByVisibleText("AA (Armed Forces Americas)");
        select1.selectByVisibleText("Alabama");
       actions
               .click(state)
               .build()
               .perform();

       // Step 10
       WebElement acceptedConditions= driver.findElement(By.xpath("//*[@id=\"termsofservice\"]"));

       actions
               .click(acceptedConditions)
               .build()
               .perform();

       // Step 11
       WebElement checkoutButton= driver.findElement(By.xpath("//*[@id=\"checkout\"]"));

       actions
               .click(checkoutButton)
               .build()
               .perform();

       // Step 12
       WebElement firstName= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"BillingNewAddress_FirstName\"]")));
      firstName.clear();
       actions
               .click(firstName)
               .sendKeys("baris")
               .build()
               .perform();
       // Step 13
       WebElement lastName= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"BillingNewAddress_LastName\"]")));
       lastName.clear();
       actions
               .click(lastName)
               .sendKeys("cansiz")
               .build()
               .perform();

     // Step 14
       WebElement email=  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"BillingNewAddress_Email\"]")));
       email.clear();
       actions
               .click(email)
               .sendKeys(user.getEmail())
               .build()
               .perform();




        // Step 15
       WebElement countrySelect= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]")));
       Select select2= new Select(countrySelect);
       select2.selectByVisibleText("Select country");
       select2.selectByVisibleText("United States");
       actions
               .click(countrySelect)
               .build()
               .perform();

       // Step 16
       WebElement stateSelect= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]")));
       Select select3= new Select(stateSelect);
       select3.selectByVisibleText("AA (Armed Forces Americas)");
       select3.selectByVisibleText("Alabama");
      actions
              .click(stateSelect)
              .build()
              .perform();

      // Step 17
      WebElement cityInput= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"BillingNewAddress_City\"]")));
      actions
              .click(cityInput)
              .sendKeys("Madison")
              .build()
              .perform();

      // Step 18
      WebElement adress1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"BillingNewAddress_Address1\"]")));

      actions
              .click(adress1)
              .sendKeys("Dayton Street WI 53706")
              .build()
              .perform();

      // Step 19
      WebElement zipCode= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]")));

      actions
              .click(zipCode)
              .sendKeys("2412323")
              .build()
              .perform();

      //  Step 20
      WebElement phoneNumber= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]")));

      actions
              .click(phoneNumber)
              .sendKeys("4245235131")
              .build()
              .perform();

      // Step 21
      WebElement continuebutton= driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input"));

      actions
              .click(continuebutton)
              .build()
              .perform();

      // Step 22
      WebElement inStorePickUp= driver.findElement(By.xpath("//*[@id=\"PickUpInStore\"]"));

      actions
              .click(inStorePickUp)
              .build()
              .perform();

      // Step 23
      WebElement continuebutton2= driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input"));
      actions
              .click(continuebutton2)
              .build()
              .perform();

      BaseDriver.threadWait(2);

      // Step 24
      WebElement creditCard= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"paymentmethod_2\"]")));

      actions.click(creditCard).build().perform();

      // Step 25
      WebElement continuebutton3= driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input"));

      actions.click(continuebutton3).build().perform();



      // Step 26
      WebElement cardHolderName= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"CardholderName\"]")));

      actions
              .click(cardHolderName)
              .sendKeys(user1.getCardholderName())
              .build()
              .perform();

      // Step 27
      WebElement cardNumber=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"CardNumber\"]")));
      actions
              .click(cardNumber)
              .sendKeys(user1.getCardNumber())
              .build()
              .perform();

      // Step 28
      WebElement lastDay= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ExpireMonth\"]")));
      Select select4=new Select(lastDay);
      select4.selectByVisibleText("03");

      actions
              .click(lastDay)
              .build()
              .perform();

      // Step 29
      WebElement lastYear= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ExpireYear\"]")));
      Select select5= new Select(lastYear);
      select5.selectByVisibleText("2032");

      actions.click(lastYear).build().perform();


      // Step 30
      WebElement cardCode= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"CardCode\"]")));
      actions
              .click(cardCode)
              .sendKeys(user1.getCardCode())
              .build()
              .perform();

      // Step 31
      WebElement continuebutton4= driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input"));

      actions.click(continuebutton4).build().perform();


      // Step 32
      WebElement confirmButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")));

      actions.click(confirmButton).build().perform();

      // Step 33
      WebElement thankYouLetter= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[1]/h1"));

        Assert.assertTrue("Thank you yazısı görünmüyor.", thankYouLetter.isDisplayed());

        // Step 34
        WebElement succesfullLetter= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong"));

        Assert.assertTrue("başarıyla sipariş oluşturdunuz yazısı görünmüyor", succesfullLetter.isDisplayed());

        driver.quit();

    }


}
