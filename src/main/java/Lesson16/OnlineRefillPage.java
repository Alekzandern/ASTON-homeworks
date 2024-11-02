package Lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class OnlineRefillPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String serviceTypeLocatorTemplate = "//div[contains(@class, 'payment-type__item') and contains(., '%s')]";

    public OnlineRefillPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<String> getServiceLabelsText() {
        List<WebElement> labels = driver.findElements(By.cssSelector(".payment-form__label"));
        List<String> labelsText = new ArrayList<>();
        for (WebElement label : labels) {
            labelsText.add(label.getText());
        }
        return labelsText;
    }

    public void selectServiceType(String serviceType) {
        String locator = String.format(serviceTypeLocatorTemplate, serviceType);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click(); // Изменил проверку на visibilityOfElementLocated
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement input = driver.findElement(By.cssSelector("input[placeholder='Номер телефона']"));
        input.sendKeys(phoneNumber);
    }

    public void enterAmount(String amount) {
        WebElement input = driver.findElement(By.cssSelector("input[placeholder='Сумма']"));
        input.sendKeys(amount);
    }

    public void clickContinueButton() {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        button.click();
    }
}