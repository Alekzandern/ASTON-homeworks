package Lesson15;
//Задание:15
//Необходимо написать авто тесты для сайта mts.by. Суть
//тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
//1. Проверить название указанного блока;
//2. Проверить наличие логотипов платёжных систем;
//3. Проверить работу ссылки «Подробнее о сервисе»;
//4. Заполнить поля и проверить работу кнопки
//«Продолжить» (проверяем только вариант «Услуги
//связи», номер для теста 297777777)

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsPageTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://mts.by/");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testOnlineRefillBlock() {
        // 1. Проверка названия блока
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение ')]"));
        assertTrue(blockTitle.isDisplayed(), "Название блока не отображается");

        // 2. Проверка наличия логотипов платежных систем
        List<WebElement> paymentLogos = driver.findElements(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners"));
        assertTrue(paymentLogos.size() > 0, "Логотипы платежных систем не найдены");

        // 3. Проверка работы ссылки "Подробнее о сервисе"
        WebElement detailsLink = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > a"));
        String originalWindow = driver.getWindowHandle();
        detailsLink.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(ExpectedConditions.urlToBe("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        driver.close();


        // 4. Заполнение полей и проверка работы кнопки "Продолжить"
        WebElement paySection = driver.findElement(By.cssSelector("#connection-phone"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", paySection);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-button")));
        driver.findElement(By.id("cookie-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".payment-form")));
    }
}