import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class itemSearchTests {
    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void checkAllFieldsValidData()
    {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Сергей Владимирович Иванов");
        driver.findElement(By.name("email")).sendKeys("Иванов@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("+79306248762");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Сергей Владимирович Иванов.\n" +
                "На вашу почту (Иванов@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79306248762.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void complicatedNoName() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("Иванов@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("+79306248762");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту (Иванов@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79306248762.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkFieldsNoEmail() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Сергей Владимирович Иванов");
        driver.findElement(By.name("phone")).sendKeys("+79306248762");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Сергей Владимирович Иванов.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79306248762.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkFieldsNoTelephone() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Сергей Владимирович Иванов");
        driver.findElement(By.name("email")).sendKeys("Иванов@mail.ru");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Сергей Владимирович Иванов.\n" +
                "На вашу почту (Иванов@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkFields_EmptyFields() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkInvalidData() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("123");
        driver.findElement(By.name("phone")).sendKeys("+79306248762");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, 123.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79306248762.";
        Assert.assertEquals(expectedResult, actualResult);
    }
}


