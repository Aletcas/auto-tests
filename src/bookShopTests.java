import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class bookShopTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void itemSearch() {
        driver.navigate().to("http://qajava.skillbox.ru/");
        WebElement element = driver.findElement(By.linkText("Обратная связь"));
        WebElement footer = driver.findElement(By.id("footer"));
        footer.findElements(By.cssSelector("#footer > div:nth-child(2) > a"));
        driver.findElement(By.cssSelector("body > div > div:nth-child(2) > div:nth-child(1) > div.book-price > button"));
        driver.findElement(By.id("cart_count"));
        driver.findElement(By.cssSelector("#genres > a"));
        var inputElement = driver.findElement(By.name("search-input-form"));
    }

    @Test
    public void numberOfBooks() {
        driver.navigate().to("http://qajava.skillbox.ru/");
        var noteElements = driver.findElements(By.className("book-info"));
        Assert.assertEquals("неверное количество книг на странице", 15, noteElements.size());
    }


}