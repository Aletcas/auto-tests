import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class povtorLessonTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }

    // 3.3 Поиск элементов с помощью Selenium WebDriver

    /* 3.3 Повторите действия из теоретического материала третьего урока для сайта онлайн-кинотеатра:
    создайте тест, который переходит на сайт, ищет поля «Email», «Пароль» и «Подтверждение пароля».*/

    @Test
    public void fieldSearch() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module05/practice1/");
        driver.findElement(By.className("form-input"));
        driver.findElement(By.id("password"));
        driver.findElement(By.name("confirm_password"));
    }

    // повторение из видео
    @Test
    public void testLocators() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module05/practice1/");
        var emailElement = driver.findElement(By.className("form-input"));
        var passwordElement = driver.findElement(By.id("password"));
        var passwordConfirmElement = driver.findElement(By.name("confirm_password"));
        var buttonElement = driver.findElement(By.tagName("button"));
        var headerResultElement = driver.findElement(By.tagName("h3"));
        var email = "skillbox@test.ru";
        var password = "tester";
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        passwordConfirmElement.sendKeys(password);
        buttonElement.click();
        var emailResultElement = driver.findElement(By.linkText(email));
        var emailResultElement2 = driver.findElement(By.partialLinkText(email));
        Assert.assertEquals("неверный текст при успешной регистрации", "Спасибо за регистрацию!", headerResultElement.getText());
        Assert.assertEquals("неверный email при успешной регистрации", email, emailElement.getText());
    }

    // Повторение из видео
    @Test
    public void testLocatorMany() {
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/");
        var noteElements = driver.findElements(By.className("articlePreview"));
        Assert.assertEquals("неверное количество записей на странице", 2, noteElements.size());
    }

    @Test
    public void testLocatorManyNegative() {
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/");
        var noteElements = driver.findElement(By.className("articlePreview pageCreate__articlePreview"));
        Assert.assertEquals("неверное количество записей на странице", true, noteElements.isDisplayed());
    }
}
