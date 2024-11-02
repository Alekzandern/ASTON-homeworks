package Lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OnlineRefillPage {

    private final String serviceTypeLocatorTemplate = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div";
    private WebDriver driver;
    private WebDriverWait wait;

    public OnlineRefillPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickMoreDetailsLink() {
        WebElement moreDetailsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")));
        moreDetailsLink.click();
    }

    public List<String> getServiceLabelsText() {
        List<WebElement> labels = driver.findElements(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__form > div.select > div.select__wrapper > button"));
        List<String> labelsText = new ArrayList<>();
        for (WebElement label : labels) {
            labelsText.add(label.getText());
        }
        return labelsText;
    }

    public void selectServiceType(String serviceType) {
        String locator = String.format(serviceTypeLocatorTemplate, serviceType);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click(); // проверка на visibilityOfElementLocated
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement input = driver.findElement(By.cssSelector("#connection-phone"));
        input.sendKeys(phoneNumber);
    }

    public void enterAmount(String amount) {
        WebElement input = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        input.sendKeys(amount);
    }

    public void clickContinueButton() {
        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        button.click();
    }
}