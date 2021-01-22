import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Ozon extends DriverSetting {
    private By catalogLocator = By.xpath("//*[text()='Каталог']");
    private By notebookLocator = By.xpath("(//span[@class='c7c3'][text()='Ноутбуки'])[1]");
    private By headingLocator = By.xpath("//a[@href='/category/noutbuki-15692/acer-25219580/']");
    private By priceFromLocator = By.xpath("(//*[@qa-id='range-from'])[1]");
    private By priceToLocator = By.xpath("(//*[@qa-id='range-to'])[1]");
    private By modelLocator = By.xpath("//*[text()='Acer']");
    private By modelNotebookLocator = By.xpath("(//a[@href='/product/14-noutbuk-acer-nx-gw9er-004-40-siniy-217650928/'])[2]");
    private By basketLocator = By.xpath("(//*[text()='Добавить в корзину'])[1]");


    @Test
    public void selectingAndAddingAnItemToTheCart() {
        driver.navigate().to("http://ozon.ru");
        driver.findElement(catalogLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(notebookLocator));
        driver.findElement(notebookLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceFromLocator));
        driver.findElement(priceFromLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(priceFromLocator).sendKeys("20000");
        driver.findElement(priceToLocator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(priceToLocator).sendKeys("45000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(modelLocator));
        driver.findElement(modelLocator).click();
        driver.findElement(modelLocator).isEnabled();
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingLocator));
        var actualResult = driver.findElement(headingLocator).getText();
        var expectedResult = "Ноутбуки Acer";
        Assert.assertEquals(expectedResult, actualResult);
        wait.until(ExpectedConditions.visibilityOfElementLocated(modelNotebookLocator));
        driver.findElement(modelNotebookLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(basketLocator));
        driver.findElement(basketLocator).click();
    }
}


