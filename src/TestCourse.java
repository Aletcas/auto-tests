
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCourse extends DriverSetting {


    @Test
    public void testWebsiteDiary() {
       driver.get("http://qa.skillbox.ru/module15/bignotes/#/statistic");

        var planLocator = By.className("page__content");
        driver.findElement(planLocator).click();
        var cardLocator = By.className(".articlePreview.pageArticle__articlePreview:first-child");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardLocator));
        var actualResult = driver.findElement(By.className("articlePreview__title")).getText();
        var expectedResult = "План на следующий месяц";
        Assert.assertEquals(expectedResult, actualResult);
        var basketLocator = By.cssSelector("button.pageArticle__button:nth-of-type(2) > svg.pageArticle__icon");
        driver.findElement(basketLocator).click();
        var noteLocator = By.cssSelector("div.articlePreview.pageArticle__articlePreview:first-child");
        driver.findElement(noteLocator).click();
        driver.findElement(basketLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(noteLocator));
        Assert.assertTrue("Не исчезла записка после удаления",driver.findElements(noteLocator).size() == 0);

    }
}



