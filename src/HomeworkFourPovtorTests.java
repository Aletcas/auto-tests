import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkFourPovtorTests {
    /* В этом классе можете описать тесты для домашнего задания */

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

/*
    @Test
    public void testKittens() {
        // переходим на страницу
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");
        // создаём переменную для поля ввода
        var emailElement = driver.findElement(By.className("email"));
        // кнопка по id
        var buttonElement = driver.findElement(By.id("write-to-me"));
        /* укажем элемент с текстом итогового емейла. (Вначале мы будем вводить емейл, потом проверять
        что он отобразился и равен введённому. Всего две проверки. Само значение емейл мы будем
         использовать дважды. И чтобы не писать его дважды создадим переменную емейл
        var email = "test@test.ru"; */
    // первым делом мы вводим текст, то есть вызываем емейл. И передаём в качестве параметра емейл
     /*   emailElement.sendKeys(email);
        // клик по кнопке
        buttonElement.click();
        var resultElementElement = driver.findElement(By.className("result-email"));
        /* Остаются две проверки. Первая на видимость текста, вторая на содержимое текста
        что он действительно равен тому, который вводили.
        Первым параметром указываем сообщение, если тест упадёт,
        далее ожидаемый результат,
        далее фактический результат. функция дисплей вернет тру, если элемент видимый, и фолс, если нет  */
    /*    Assert.assertEquals("не отобразился текст про емейл", true,
            resultElementElement.isDisplayed());
        // Проверяем текст.
        Assert.assertEquals("неправильный текст про емейл", email, resultElementElement.getText());
    }

    @Test
        public void testKittenEmtyemail()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");
        var buttonElement = driver.findElement(By.id("write-to-me"));
        buttonElement.click();
        var resultElementElement = driver.findElement(By.className("result-email"));
        Assert.assertEquals("неправильный текст про емейл", "", resultElementElement.getText());
    }
    */

    private By emailLocator = By.className("email");
    private By writeToMeLocator = By.id("write-to-me");
    private By resultEmailLocator = By.className("notification-email");

    @Test
    public void testKittens() {

        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");
        var email = "test@test.ru";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(writeToMeLocator).click();
        Assert.assertTrue("Не отобразился текст про email",
            driver.findElement(resultEmailLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст про email", email,
            driver.findElement(resultEmailLocator).getText());
    }

    @Test
    public void testKittenEmtyemail() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");
        driver.findElement(writeToMeLocator).click();
        Assert.assertEquals("Неправильный текст про email", "",
            driver.findElement(resultEmailLocator).getText());
    }
}
