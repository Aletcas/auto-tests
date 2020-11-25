import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class onlineCinemaTests {
    private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

                       // 3.2 Selenium WebDriver тесты: избавляемся от дублирования кода

    /*3.2. В первом тесте перейдите на сайт, введите любое имя, email skillbox@test.ru и пароль qwerty!123.
     После этого кликните по кнопке «Зарегистрироваться» и убедитесь,
     что текст у элемента с результатом регистрации равен «Вам на почту skillbox@test.ru
     отправлено письмо».
     */
    @Test
    public void checkIn() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module06/register/");
        driver.findElement(By.className("form-input")).sendKeys("Алексей");
        driver.findElement(By.name("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.id("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-result")).getText();
        var expectedResult = "Вам на почту skillbox@test.ru отправлено письмо";
        Assert.assertEquals(expectedResult, actualResult);
    }

    /*3.2 Во втором тесте перейдите на сайт и сразу же кликните по кнопке «Зарегистрироваться».
    Убедитесь, что текст у элемента с ошибкой регистрации равен «Введите имя».*/
    @Test
    public void checkInError() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();
        var actualAnswerText = driver.findElement(By.className("form-error")).getText();
        var expectedAnswerText = "Введите имя";
        Assert.assertEquals(expectedAnswerText, actualAnswerText);
    }
}


