import java.time.Instant;
import java.util.EventObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestLabirint extends DriverSetting {

    private By firstAddBookButtonLocator = By.cssSelector("[data-title='Что почитать: выбор редакции'] .product:nth-of-type(1) .buy-link");
    private By firstCheckoutButtonLocator = By.cssSelector("[data-title='Что почитать: выбор редакции'] .product:nth-of-type(1) .btn-more");
    private By beginOrderButtonLocator= By.id("basket-default-begin-order");
    private By chooseCourierDeliveryCheckboxLocator = By.className("js-dl-courier");
    private By courierDeliverylightboxLocator = By.cssSelector("form.b-dlform");
    private By streetLocator= By.cssSelector("[id^='f-street']");
    private By buildingLocator= By.cssSelector("[id^='_jsbuilding_']");
    private By buttonReadyLocator = By.cssSelector("form.b-dlform input[type='submit']");
    private By AddressTextLocator = By.cssSelector(".js-dl-courier .b-deliv-im-head-e-subname");
    private By loaderLocator = By.className("loading-panel");

    @Test
    // страница, которую тестируем, действие, ожидаемый результат
    public void cartPage_FillAndConfirmCourierDeliveryLightbox_DeliveryAddressIsVisible() {
        var street = "Ленина";
        var building = "1";

        driver.get("https://www.labirint.ru/");
        driver.findElement(firstAddBookButtonLocator).click();
        driver.findElement(firstCheckoutButtonLocator).click();
        driver.findElement(beginOrderButtonLocator).click();
        driver.findElement(chooseCourierDeliveryCheckboxLocator).click();
        driver.findElement(streetLocator).sendKeys(street);
        driver.findElement(buildingLocator).sendKeys(building);
        driver.findElement(buildingLocator).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
        driver.findElement(buttonReadyLocator).click();
        Assert.assertFalse("не исчез после заполнения лайтбокс курьерской доставки", driver.findElement(courierDeliverylightboxLocator).isDisplayed());
        var expectedAddress = "Ленина д. 1";
        var actualAddress = driver.findElement(AddressTextLocator).getText();
        Assert.assertTrue(String.format("неправильный адрес курьерской доставки. Сейчас:%s Ожидали:%s", actualAddress, expectedAddress), actualAddress.contains(expectedAddress));

    }
    @Test
    // страница, которую тестируем, действие, ожидаемый результат
    public void cartPage_PartlyFillUserInfoAndSubmitOrder_NeedToFillTextWasShown()
    {
        //arrange
        var emailLocator = By.cssSelector(".b-user [name='email']");
        var phoneLocator = By.cssSelector(".b-user .js-phone");
        var nameLocator = By.cssSelector(".b-user [name='firstname']");
        var surnameLocator = By.cssSelector(".b-user [name='lastname']");
        var buttonLocator = By.cssSelector("[data-gaid='cart_submit']");

        var deliveryTypeTextLocator = By.cssSelector(".b-lefttofill-items *:nth-child(1)");
        var paymentTypeTextLocator = By.cssSelector(".b-lefttofill-items *:nth-child(3)");
        var emailTextLocator = By.cssSelector(".b-lefttofill-items *:nth-child(5)");
        var phoneTextLocator = By.cssSelector(".b-lefttofill-items *:nth-child(7)");
        var nameTextLocator = By.cssSelector(".b-lefttofill-items *:nth-child(9)");
        var surnameTextLocator = By.cssSelector(".b-lefttofill-items *:nth-child(11)");
        var cookiePolicyButtonLocator = By.className("js-cookie-policy-agree");
        var redTextLocator = By.cssSelector(".b-user .b-form-error-e-text");

        driver.get("https://www.labirint.ru/");
        driver.findElement(cookiePolicyButtonLocator).click();
        driver.findElement(firstAddBookButtonLocator).click();
        driver.findElement(firstCheckoutButtonLocator).click();
        driver.findElement(beginOrderButtonLocator).click();

        //act
        driver.findElement(emailLocator).sendKeys("test12@test.ru");
        driver.findElement(phoneLocator).sendKeys("9000000077");
        wait.until(ExpectedConditions.visibilityOfElementLocated(redTextLocator));
        driver.findElement(nameLocator).sendKeys("Тестер");
        driver.findElement(surnameLocator).sendKeys("Иванов");
        driver.findElement(surnameLocator).sendKeys(Keys.TAB);
        driver.findElement(buttonLocator).click();

        //assert
        Assert.assertFalse("тип доставки оказался заполненным, когда его не заполняли", driver.findElement(deliveryTypeTextLocator).getAttribute("class").contains("filled"));
        Assert.assertFalse("тип оплаты оказался заполненным, когда его не заполняли", driver.findElement(paymentTypeTextLocator).getAttribute("class").contains("filled"));
        Assert.assertTrue("email оказался не заполненным, когда его заполняли", driver.findElement(emailTextLocator).getAttribute("class").contains("filled"));
        Assert.assertTrue("имя оказалось не заполненной, когда его заполняли", driver.findElement(nameTextLocator).getAttribute("class").contains("filled"));
        Assert.assertTrue("фамилия оказалась не заполненной, когда ее заполняли", driver.findElement(surnameTextLocator).getAttribute("class").contains("filled"));
        Assert.assertTrue("телефон оказался не заполненным, когда его заполняли", driver.findElement(phoneTextLocator).getAttribute("class").contains("filled"));
    }



  }