import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class СomplicatedTests {

    @Test
    public void checkAllFieldsValidData() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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
        driver.quit();
    }

    @Test
    public void complicatedNoName() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("Иванов@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("+79306248762");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту (Иванов@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79306248762.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void checkFieldsNoEmail() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Сергей Владимирович Иванов");
        driver.findElement(By.name("phone")).sendKeys("+79306248762");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Сергей Владимирович Иванов.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79306248762.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void checkFieldsNoTelephone() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Сергей Владимирович Иванов");
        driver.findElement(By.name("email")).sendKeys("Иванов@mail.ru");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Сергей Владимирович Иванов.\n" +
                "На вашу почту (Иванов@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void checkFields_EmptyFields() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void checkInvalidData() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("123");
        driver.findElement(By.name("phone")).sendKeys("+79306248762");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, 123.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79306248762.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }
}