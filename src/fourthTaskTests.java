import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class fourthTaskTests {
    private static ChromeDriver driver;

    @BeforeClass
    public static void setUpClass()
    {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void tearDownClass()
    {
        driver.quit();
    }


               // 3.4 Поиск элементов с помощью Selenium WebDriver: продолжение. Домашняя работа

    /* 1. Запишите один тест на негативный сценарий для сайта магазина обуви */
    @Test
    public void invalidDataShoeStoreNegative() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("45");
        driver.findElement(By.tagName("button")).click();
        var actualText= driver.findElement(By.id("size-error")).getText();
        var expectedText = "В нашем магазине нет обуви вашего размера";
        Assert.assertEquals("Неправильный текст при отсутствии размера",expectedText, actualText);
    }
    /* 3.3 Запишите ещё один тест на позитивный сценарий для сайта магазина обуви.
    Примените известные вам техники тест-дизайна при составлении сценария.
    Для поиска элементов используйте разные, неповторяющиеся стратегии поиска By. */

    @Test
    public void DataShoeStore() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("34");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.id("size-success")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals(expectedResult, actualResult);
    }

    /* 2. Запишите тест для сайта книжного магазина http://qajava.skillbox.ru/.
     В тесте сделайте переход на сайт и найдите с помощью функции findElement следующие элементы:
     ссылку «Обратная связь» в самом низу страницы <a href="">Обратная связь</a>;
     ссылку «Предзаказы» в самом низу страницы <a href="">Предзаказы</a>;
     кнопку «В корзину» у первой книги <button class="book-add" onclick="AddToCart(this.parentElement)">;
     цифру с количеством товаров в корзинке у значка корзины справа вверху <span id="cart_count">;
     пункт меню «Книги» <li id="genres">;
     поле поиска по магазину <input name="search-input-form" id="search-input" type="text" placeholder="Поиск по магазину..." autocomplete="off" maxlength="100" value="">.
     Обратите внимание, что в этом тесте не будет никаких действий, только поиск элементов по локаторам.*/

    @Test
    public void itemSearch() {
        driver.navigate().to("http://qajava.skillbox.ru/");
        driver.findElement(By.linkText("Обратная связь"));
        driver.findElement(By.partialLinkText("Предзаказы"));
        driver.findElement(By.tagName("button"));
        driver.findElement(By.id("cart_count"));
        driver.findElement(By.id("genres"));
        driver.findElement(By.name("search-input-form"));
    }

    /* 3. Запишите тест для сайта книжного магазина.
    В тесте осуществите переход на сайт, найдите с помощью функции
    findElements все элементы <div class="book-info"> и в конце проверьте, что их ровно 15 штук. */

    @Test
    public void numberOfBooks() {
        driver.navigate().to("http://qajava.skillbox.ru/");
        var bookElements = driver.findElements(By.className("book-info"));
        Assert.assertEquals("неверное количество книг на странице", 15, bookElements.size());
    }

    /* 4.  Запишите не менее трёх тестов для сайта кинотеатра.
    введите текст в поле «Ваши любимые фильмы»;
    введите текст в поле «Ваши любимые сериалы»;
    нажмите «Сохранить»;
    нажмите на кнопку «2»;
    нажмите на кнопку «ВВОД»;
    нажмите на кнопку «ОК»;
    проверьте, что после нажатия кнопки «ОК» появился текст и он равен тому,
    который вы вводили в поле «Ваши любимые фильмы»; */

    @Test
    public void favoriteFilmsValidData() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module07/practice3/");
        driver.findElement(By.className("module_input_text")).sendKeys("Котофеи");
        driver.findElement(By.name("serials")).sendKeys("Котофеи на охоте");
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        var actualResult = driver.findElement(By.cssSelector("#best_films")).getText();
        var expectedResult = "Котофеи";
        Assert.assertEquals("Неверное название фильма",actualResult, expectedResult);
    }

    /* Сценарии остальных тестов выберите на своё усмотрение, опираясь на техники тест-дизайна.
    Для поиска элементов в тесте по возможности используйте все изученные стратегии поиска.
    Использование разных способов поиска (ни одной ссылки в форме нет)*/

    @Test
    public void favoriteFilmsEmptyFields() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module07/practice3/");
        driver.findElement(By.className("module_input_text")).sendKeys("Котофеи");
        driver.findElement(By.name("serials")).sendKeys("Котофеи на охоте");
        driver.findElement(By.tagName("input")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
    }
    // Проверка формы на соответствие полей. (Отработка соответствия проверки и класса)
    @Test
    public void checkingTheForm() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module07/practice3/");
        driver.findElement(By.className("header__content"));
        var actualResult = driver.findElement(By.className("header__content")).getText();
        var expectedResult = "Поделитесь списком ваших фаворитов";
        Assert.assertEquals(expectedResult, actualResult);
        driver.findElement(By.className("module_input_text")).sendKeys("Котофеи");
        driver.findElement(By.name("serials")).sendKeys("Котофеи на охоте");
        driver.findElement(By.tagName("input")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.className("module__header"));
        var actualText = driver.findElement(By.className("module__header")).getText();
        var expectedText = "Я люблю смотреть фильмы:";
        Assert.assertEquals(expectedText, actualText);
        driver.findElement(By.id("save")).click();
        driver.findElement(By.className("popup-text"));
        var actualSerialText = driver.findElement(By.className("popup-text")).getText();
        var expectedSerialText = "Показать ваши ответы перед сохранением?";
        Assert.assertEquals(expectedSerialText, actualSerialText);
        driver.findElement(By.id("ok")).click();
        driver.findElement(By.className("result"));
        var actualAnswerText = driver.findElement(By.className("result")).getText();
        var expectedAnswerText = "Ваши ответы:";
        Assert.assertEquals(expectedAnswerText, actualAnswerText);
    }
}
