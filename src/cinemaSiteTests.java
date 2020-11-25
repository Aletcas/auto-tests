
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class cinemaSiteTests {
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

    @Test
    public void itemSearch() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module07/practice3/");
        driver.findElement(By.id("films")).sendKeys("Котофеи");
        driver.findElement(By.name("serials")).sendKeys("Котофеи на охоте");
        driver.findElement(By.cssSelector("#save")).click();
        driver.findElement(By.cssSelector("#two")).click();
        driver.findElement(By.cssSelector("#save")).click();
        driver.findElement(By.id("ok")).click();
        var actualResult = driver.findElement(By.cssSelector("#best_films")).getText();
        var expectedResult = "Котофеи";
        Assert.assertEquals(expectedResult, actualResult);
        var actualResult2 = driver.findElement(By.cssSelector("#best_serials")).getText();
        var expectedResult2 = "Котофеи на охоте";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void itemSearchAllData() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module07/practice3/");
        driver.findElement(By.id("films")).sendKeys("Котофеи");
        driver.findElement(By.name("serials")).sendKeys("Котофеи на охоте");
        driver.findElement(By.cssSelector("#save")).click();
        driver.findElement(By.cssSelector("#two")).click();
        driver.findElement(By.cssSelector("#page_2 > div:nth-child(1) > div.module__inputs > div:nth-child(3) > label > span")).click();
        driver.findElement(By.cssSelector("#page_2 > div:nth-child(2) > div.module__inputs > div:nth-child(5) > label > span")).click();
        driver.findElement(By.cssSelector("#save")).click();
        driver.findElement(By.id("ok")).click();
        var actualResult = driver.findElement(By.cssSelector("#best_films")).getText();
        var expectedResult = "Котофеи";
        Assert.assertEquals(expectedResult, actualResult);
        var actualResult2 = driver.findElement(By.cssSelector("#best_serials")).getText();
        var expectedResult2 = "Котофеи на охоте";
        Assert.assertEquals(expectedResult, actualResult);
        var actualResult3 = driver.findElement(By.cssSelector("#language")).getText();
        var expectedResult3 = "В оригинале";
        Assert.assertEquals(expectedResult, actualResult);
        var actualResult4 = driver.findElement(By.cssSelector("#age")).getText();
        var expectedResult4 = "35-45";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void itemSearchAllEmptyFields() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module07/practice3/");
        driver.findElement(By.cssSelector("#save")).click();
        driver.findElement(By.cssSelector("#two")).click();
        driver.findElement(By.cssSelector("#save")).click();
        driver.findElement(By.id("ok")).click();
        var actualResult = driver.findElement(By.cssSelector("#best_films")).getText();
        var expectedResult = "";
        Assert.assertEquals(expectedResult, actualResult);
        var actualResult2 = driver.findElement(By.cssSelector("#best_serials")).getText();
        var expectedResult2 = "";
        Assert.assertEquals(expectedResult, actualResult);
        var actualResult3 = driver.findElement(By.cssSelector("#language")).getText();
        var expectedResult3 = "";
        Assert.assertEquals(expectedResult, actualResult);
        var actualResult4 = driver.findElement(By.cssSelector("#age")).getText();
        var expectedResult4 = "";
        Assert.assertEquals(expectedResult, actualResult);
    }
}



