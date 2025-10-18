package US207_Survey_Response;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class DWST3_T7 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        WebElement surveyTitle = driver.findElement(By.xpath("//div[@class='block block-poll']/div[1]"));
        Assert.assertTrue("Anket bulunamadı", surveyTitle.isDisplayed());

        WebElement goodOption = driver.findElement(By.xpath("//input[@id='pollanswers-2']"));
        actions.moveToElement(goodOption).click().perform();

        WebElement voteButton = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        actions.moveToElement(voteButton).click().perform();

        Thread.sleep(2000);
        WebElement warningMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='block-poll-vote-error-1']")));
        String messageActual = warningMessage.getText();

        Assert.assertTrue("Uyarı mesajı görüntülenmedi",messageActual.contains("Only registered users can vote."));

        System.out.println("Mesaj başarıyla görüntülendi: " + messageActual);

        driver.quit();

    }
}
