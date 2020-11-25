
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/*  Используя известные вам техники тест-дизайна, напишите ещё два теста 
на позитивные сценарии к сайту с подбором имени для щенка. 
Используйте при этом все советы из урока. 
 */
public class HomeworkFourTests {

    private static ChromeDriver driver;

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    private By boyLocator = By.id("boy");
    private By girlLocator = By.id("girl");
    private By emailLocator = By.name("email");
    private By resultEmailLocator = By.className("your-email");
    private By buttonLocator = By.id("sendMe");

    @Test
    public void testDogBoy() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(boyLocator).click();
        var email = "test@test.ru";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Не отобразился текст про email",
            driver.findElement(resultEmailLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст про email", email,
            driver.findElement(resultEmailLocator).getText());
    }

    @Test
    public void testDogTextMatching() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        var actualHeadingText = driver.findElement(By.className("subtitle-bold")).getText();
        var expectedHeadingText = "Мы подберём имя для твоего щеночка";
        Assert.assertEquals(expectedHeadingText, actualHeadingText);
        var actualWhoText = driver.findElement(By.className("formQuestion")).getText();
        var expectedWhoText = "Кто у тебя?";
        Assert.assertEquals(expectedWhoText, actualWhoText);
        driver.findElement(girlLocator).click();
        var email = "test@test.ru";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Не отобразился текст про email",
            driver.findElement(resultEmailLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст про email", email,
            driver.findElement(resultEmailLocator).getText());
    }

/* Повторите действия из третьего урока для формы обратной связи на сайте
по ремонту компьютеров: создайте тест, дополните его локаторами для двух
других полей ввода. Совершите действия с этими полями, а именно ввод текста. */

    private By nameLocator = By.cssSelector(".data.text");
    private By emaillLocator = By.cssSelector(".data.field");
    private By textLocator = By.cssSelector(".field.text");

    @Test
    public void testFeedback() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        var name = "Елена";
        var emaill = "test@test.ru";
        var message = "Спасибо, всё понравилось";
        var buttonLocator = By.id("comment");
        var messageLocator = By.className("message-header");
        driver.findElement(nameLocator).sendKeys("Елена");
        driver.findElement(nameLocator).sendKeys("test@test.ru");
        driver.findElement(nameLocator).sendKeys("спасибо, всё понравилось");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("не отобразился текст про спасибо",
            driver.findElement(messageLocator).isDisplayed());
    }
/* Напишите один позитивный тест для странички, включающий в себя заполнение
всех полей. Перед написанием кода проверьте свои локаторы через браузер.
Ищите элементы с помощью By.cssSelector, указывая один или два класса там,
где поиск по одному классу будет неуникальным.*/


    private By namesLocator = By.cssSelector(".form-input.fio");
    private By streetLocator = By.cssSelector(".data.form-input.street");
    private By houseNumberLocator = By.cssSelector(".form-input.house");
    private By apartmentLocator = By.cssSelector(".form-input.flat");
    private By dayLocator = By.cssSelector(".form-input.date");
    private By resultmessagesLocator = By.cssSelector(".form-result.result");

    @Test
    public void testMasterCall() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");
        var names = "Иванов Иван Иванович";
        driver.findElement(namesLocator).sendKeys(names);
        var street = "Николаева";
        driver.findElement(streetLocator).sendKeys(street);
        var houseNumber = "15";
        driver.findElement(houseNumberLocator).sendKeys(houseNumber);
        var apartment = "30";
        driver.findElement(apartmentLocator).sendKeys(apartment);
        var day = "saturday";
        driver.findElement(dayLocator).sendKeys(day);
        driver.findElement(By.className("form-submit")).click();
        Assert.assertTrue("Не отобразился введенный текст",
            driver.findElement(resultmessagesLocator).isDisplayed());
    }
/* Запишите один тест на сценарий работы валидации формы авторизации
на сайте клуба любителей весёлых носков.
перейти на страницу;
ввести в поле email значение «@»;
ввести в поле для пароля значение «123»;
нажать на кнопку «Войти»;
убедиться, что отобразился текст с ошибкой (проверка только на видимость);
проверить сам текст с ошибкой, он должен быть равен «Некорректный email или пароль».
При этом каждый элемент на странице ищите новым способом из уже изученных,
а  именно: By.id, By.tagName, By.className, By.name.
Итого у вас будет четыре элемента, найденные четырьмя разными стратегиями поиска.
*/

    private By EmailLocator = By.cssSelector("input#email.form-input");
    private By passwordLocator = By.cssSelector("input#password.form-input");
    private By buttonLocator2 = By.cssSelector("button.form-submit");
    private By getTextLocator = By.cssSelector("#error.form-error-password-email");

    @Test
    public void testSocksClub() {
        http:
//qajava.skillbox.ru/module04/homework/auth/changed.html
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html");
        var Email = "@";
        driver.findElement(EmailLocator).sendKeys(Email);
        var password = "123";
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator2).click();
        Assert.assertTrue("Не отобразился текст про ошибку",
            driver.findElement(resultEmailLocator).isDisplayed());
        var actualResult = driver.findElement(By.cssSelector("#error.form-error-password-email"))
            .getText();
        var expectedResult = "Некорректный email или пароль";
        Assert.assertEquals(expectedResult, actualResult);
    }

    // Страница обновилась
    private By EmailNewLocator = By.cssSelector("input#email.form-input.input-data");
    private By passwordNewLocator = By.cssSelector("input#password.form-input.password");
    private By buttonNewLocator2 = By.cssSelector("button#submit.form-submit");
    private By getTextNewLocator = By.cssSelector("#error.form-error-password-email");

    @Test
    public void testSocksClubNew() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var Email = "@";
        driver.findElement(EmailNewLocator).sendKeys(Email);
        var password = "123";
        driver.findElement(passwordNewLocator).sendKeys(password);
        driver.findElement(buttonNewLocator2).click();
        Assert.assertTrue("Не отобразился текст про ошибку",
            driver.findElement(resultEmailLocator).isDisplayed());
        var actualResult = driver.findElement(By.cssSelector("#error.form-error-password-email"))
            .getText();
        var expectedResult = "Некорректный email или пароль";
        Assert.assertEquals(expectedResult, actualResult);
    }
}