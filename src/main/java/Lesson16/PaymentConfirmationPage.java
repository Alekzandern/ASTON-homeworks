package Lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

class PaymentConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentConfirmationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getAmountText() {
        return driver.findElement(By.cssSelector(".payment-details__value")).getText();
    }

    public String getPhoneNumberText() {
        return driver.findElement(By.cssSelector(".payment-details__item:nth-child(2) .payment-details__value")).getText();
    }

    public String getCardNumberInputPlaceholder() {
        return driver.findElement(By.cssSelector("input[placeholder='Номер карты']")).getAttribute("placeholder");
    }

    public String getCardExpirationDateInputPlaceholder() {
        return driver.findElement(By.cssSelector("input[placeholder='Срок действия']")).getAttribute("placeholder");
    }

    public String getCardCvvInputPlaceholder() {
        return driver.findElement(By.cssSelector("input[placeholder='CVV/CVC']")).getAttribute("placeholder");
    }

    public List<String> getPaymentSystemIcons() {
        List<WebElement> icons = driver.findElements(By.cssSelector(".payment-details__cards img"));
        List<String> iconNames = new ArrayList<>();
        for (WebElement icon : icons) {
            String src = icon.getAttribute("src");
            if (src.contains("visa")) {
                iconNames.add("visa");
            } else if (src.contains("mastercard")) {
                iconNames.add("mastercard");
            }
        }
        return iconNames;
    }
}