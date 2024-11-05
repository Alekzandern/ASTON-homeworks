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

import org.junit.jupiter.api.AfterEach;
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

class MtsObjectTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private OnlineRefillPage refillPage;

    private final By COOKIE_BUTTON_LOCATOR = By.xpath("//button[contains(@class, 'cookie-policy__button')]");
    private final By MORE_DETAILS_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Подробнее о сервисе')]");

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mts.by/");

        refillPage = new OnlineRefillPage(driver, wait);

        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(COOKIE_BUTTON_LOCATOR));
            cookieButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Кнопка подтверждения куки не найдена.");
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testOnlineRefillMobile() {

        List<String> expectedMobileLabels = Arrays.asList("Номер телефона", "Сумма");
        List<String> actualMobileLabels = refillPage.getLabelsForServiceType("mobile");
        assertLabels(expectedMobileLabels, actualMobileLabels, "mobile");


        refillPage.fillRefillForm("mobile", "+375297777777", "10");

        PaymentConfirmationPage confirmationPage = new PaymentConfirmationPage(driver, wait);

        assertEquals("10.00 BYN", confirmationPage.getAmountText());
        assertEquals("+375297777777", confirmationPage.getPhoneNumberText());

        assertEquals("Номер карты", confirmationPage.getCardNumberInputPlaceholder());
        assertEquals("Срок действия", confirmationPage.getCardExpirationDateInputPlaceholder());
        assertEquals("CVV/CVC", confirmationPage.getCardCvvInputPlaceholder());

        List<String> paymentIcons = confirmationPage.getPaymentSystemIcons();
        assertTrue(paymentIcons.contains("visa"));
        assertTrue(paymentIcons.contains("mastercard"));


        refillPage.clickMoreDetailsLink(MORE_DETAILS_LINK_LOCATOR);
        assertTrue(driver.getCurrentUrl().contains("https://mts.by/personal/chastnym-klientam/denezhnye-perevody/onlayn-popolnenie"), "Неверный URL страницы 'Подробнее о сервисе'");
    }

    @Test
    public void testOnlineRefillOtherServices() {

        assertLabels(Arrays.asList("Номер лицевого счета", "Сумма"), refillPage.getLabelsForServiceType("home-internet"), "home-internet");
        assertLabels(Arrays.asList("Номер договора", "Сумма"), refillPage.getLabelsForServiceType("installment"), "installment");
        assertLabels(Arrays.asList("Номер телефона", "Сумма"), refillPage.getLabelsForServiceType("debt"), "debt");
    }

    private void assertLabels(List<String> expectedLabels, List<String> actualLabels, String serviceType) {
        for (String label : expectedLabels) {
            assertTrue(actualLabels.contains(label), "Отсутствует надпись: " + label + " для типа услуги: " + serviceType);
        }
    }
}