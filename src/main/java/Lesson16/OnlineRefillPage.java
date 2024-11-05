package Lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

class OnlineRefillPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String serviceTypeLocatorTemplate = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2";

    public OnlineRefillPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public List<String> getLabelsForServiceType(String serviceType) {
        selectServiceType(serviceType);
        return getServiceLabelsText();
    }

    public void fillRefillForm(String serviceType, String phoneNumber, String amount) {
        selectServiceType(serviceType);
        enterPhoneNumber(phoneNumber);
        enterAmount(amount);
        clickContinueButton();
    }

    public void clickMoreDetailsLink(By locator) {
        WebElement moreDetailsLink = wait.until(ExpectedConditions.elementToBeClickable(locator));
        moreDetailsLink.click();
    }

    private void selectServiceType(String serviceType) {
        String locator = String.format(serviceTypeLocatorTemplate, serviceType);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
    }

    private void enterPhoneNumber(String phoneNumber) {
        WebElement input = driver.findElement(By.cssSelector("input[placeholder='Номер телефона']"));
        input.sendKeys(phoneNumber);
    }

    private void enterAmount(String amount) {
        WebElement input = driver.findElement(By.cssSelector("input[placeholder='Сумма']"));
        input.sendKeys(amount);
    }

    private List<String> getServiceLabelsText() {
        List<WebElement> labels = driver.findElements(By.cssSelector(".payment-form__label"));
        List<String> labelsText = new ArrayList<>();
        for (WebElement label : labels) {
            labelsText.add(label.getText());
        }
        return labelsText;
    }

    private void clickContinueButton() {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        button.click();
    }
}