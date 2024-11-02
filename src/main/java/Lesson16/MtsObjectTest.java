package Lesson16;
//Задание16:
//Продолжим работу над блоком «Онлайн пополнение без
//комиссии» сайта mts.by. Перевести ранее написанный тест
//на использование паттерна PageObject и добавить
//следующие проверки:
//1. Проверить надписи в незаполненных полях каждого
//варианта оплаты услуг: услуги связи, домашний
//интернет, рассрочка, задолженность;
//2. Для варианта «Услуги связи» заполнить поля в
//соответствии с пререквизитами из предыдущей темы,
//нажать кнопку «Продолжить» и в появившемся окне
//проверить корректность отображения суммы (в том
//числе на кнопке), номера телефона, а также надписей в
//незаполненных полях для ввода реквизитов карты,
//наличие иконок платёжных систем.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OnlineRefillTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // добавил неявное ожидание
        driver.get("https://mts.by/");
        // Подтверждение куки
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cookie-agree\"]"))); // Локатор кнопки подтверждения куки
        cookieButton.click();
    }

    @Test
    public void testOnlineRefill() {
        OnlineRefillPage refillPage = new OnlineRefillPage(driver);

        // 1. Проверка надписей в незаполненных полях
        checkLabels(refillPage, "mobile", Arrays.asList("Номер телефона", "Сумма"));
        checkLabels(refillPage, "home-internet", Arrays.asList("Номер лицевого счета", "Сумма"));
        checkLabels(refillPage, "installment", Arrays.asList("Номер договора", "Сумма"));
        checkLabels(refillPage, "debt", Arrays.asList("Номер телефона", "Сумма"));

        // 2. Проверка пополнения услуг связи
        refillPage.selectServiceType("mobile");
        refillPage.enterPhoneNumber("+375291234567");
        refillPage.enterAmount("10");
        refillPage.clickContinueButton();

        PaymentConfirmationPage confirmationPage = new PaymentConfirmationPage(driver);

        assertEquals("10.00 BYN", confirmationPage.getAmountText());
        assertEquals("+375291234567", confirmationPage.getPhoneNumberText());

        assertEquals("Номер карты", confirmationPage.getCardNumberInputPlaceholder());
        assertEquals("Срок действия", confirmationPage.getCardExpirationDateInputPlaceholder());
        assertEquals("CVV/CVC", confirmationPage.getCardCvvInputPlaceholder());

        List<String> icons = confirmationPage.getPaymentSystemIcons();
        assertTrue(icons.contains("visa"));
        assertTrue(icons.contains("mastercard"));
    }

    private void checkLabels(OnlineRefillPage refillPage, String serviceType, List<String> expectedLabels) {
        refillPage.selectServiceType(serviceType);
        List<String> actualLabels = refillPage.getServiceLabelsText();
        for (String label : expectedLabels) {
            assertTrue(actualLabels.contains(label), "Отсутствует надпись: " + label + " для типа услуги: " + serviceType);
        }
    }
}