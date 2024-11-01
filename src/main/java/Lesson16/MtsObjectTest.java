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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OnlineRefillTest {

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testOnlineRefill() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mts.by/");

        OnlineRefillPage refillPage = new OnlineRefillPage(driver);


        List<String> mobileLabels = refillPage.getMobileServiceLabelsText();
        for (String s : Arrays.asList("Номер телефона", "Сумма")) {
            assertTrue(mobileLabels.contains(s));
        }

        refillPage.selectServiceType("mobile");
        refillPage.enterPhoneNumber("+375291234567");
        refillPage.enterAmount("10");
        refillPage.clickContinueButton();

        PaymentConfirmationPage confirmationPage = new PaymentConfirmationPage(driver);

        assertEquals("10.00 BYN", confirmationPage.getAmountText());
        assertEquals("+375291234567", confirmationPage.getPhoneNumberText());


        assertEquals("Номер карты", confirmationPage.getCardNumberInputPlaceholder());

        List<String> icons = confirmationPage.getPaymentSystemIcons();
        assertTrue(icons.contains("visa"));
        assertTrue(icons.contains("mastercard"));

        driver.quit();
    }
}