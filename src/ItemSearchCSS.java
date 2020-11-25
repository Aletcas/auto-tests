import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ItemSearchCSS {
    private static ChromeDriver driver;
    private By resultEmailLocator;

    @BeforeClass

    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    // сайт весёлые носки
    private By headerLocator = By.cssSelector("[for = 'main-header-page']");
    private By titleLocator = By.cssSelector("h3.form-title");
    private By EmailLocator = By.cssSelector("[important = '']");
    private By passwordLocator = By.cssSelector("[required = 'true']");
    private By buttonLocator = By.cssSelector("button#submit.form-submit");


    @Test
    public void testSocksClubFieldValidation() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        Assert.assertTrue("Не отображается текст хэдера",
            driver.findElement(headerLocator).isDisplayed());
        Assert.assertTrue("Не отображается заголовок",
            driver.findElement(titleLocator).isDisplayed());
        var Email = "@";
        driver.findElement(EmailLocator).sendKeys(Email);
        var password = "123";
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();
        WebElement source = driver
            .findElement(By.cssSelector("pre#error.form-error-password-email"));
        Assert.assertEquals("Некорректный email или пароль", source.getText());
    }

    // Поиск элементов.
    /*
Локаторы на странице http://qajava.skillbox.ru/index.html для элемента
<a href="" test-info="about-us">О магазине</a>.
Осуществите поиск только по атрибуту test-info, равному "about-us".
     */
    private By footerLocator = By.cssSelector("[test-info = 'about-us']");

    /*
Локатор на странице http://qajava.skillbox.ru/index.html для всех элементов
с тегом a и с атрибутом href с пустым значением, то есть равным "".
     */
    private By linksLocator = By.cssSelector("[href = '']");

    /*
Локатор на странице http://qajava.skillbox.ru/search.html для всех элементов
с тегом option и с атрибутом selected.
Осуществите поиск только по атрибуту selected.
     */
    private By authorLocator = By.cssSelector("[selected = '']");

    /*
Локатор на странице http://qajava.skillbox.ru/index.html для элемента
<div class="book-price">.
Осуществите поиск одновременно по тегу и классу равному "book-price".
     */
    private By priceLocator = By.cssSelector("div.book-price");
    /*
Локатор на странице http://qajava.skillbox.ru/index.html для всех
элементов с тегом button и с атрибутом class, начинающимся на "book".
    */
    private By bookLocator = By.cssSelector("button[class^='book']");

    /*
Локатор на странице http://qajava.skillbox.ru/index.html для всех элементов,
у которых атрибут class заканчивается на "main".
     */
    private By lineLocator = By.cssSelector("[class$='main']");

    /*
Локатор на странице http://qajava.skillbox.ru/index.html для всех
элементов с тегом a и с атрибутом class, содержащим в себе слово "menu".
     */
    private By itemsLocator = By.cssSelector("a[class*='menu']");

    // Для сайта книжного магазина составьте CSS-локаторы:

    /*
На странице http://qajava.skillbox.ru/index.html найдите все теги div,
которые являются дочерними элементами первого уровня у элемента
<footer id="footer">.
     */

    private By booksLocator = By.cssSelector("footer#footer>div~*");

    /*
На странице http://qajava.skillbox.ru/index.html найдите любой тег,
который расположен сразу после <li id="genres">.
     */
    private By elementLocator = By.cssSelector("li#genres>a~*");

    /*
На странице http://qajava.skillbox.ru/search.html найдите любые теги,
которые расположены после <div class="filter-container">
(не обязательно ближайший сосед).
     */
    private By badgeLocator = By.cssSelector(".filter-container>span");

//3. Для сайта клуба любителей весёлых носков
// http://qajava.skillbox.ru/module05/auth/index.html составьте
// CSS-локаторы, в которых найдите:

    /*
первый тег h1, находящийся сразу на первом уровне вложенности внутри
<section class="important-section-block" for="main-header-page">;
Используйте поиск по первому child.
     */
    private By sectionLocator = By.cssSelector("section.important-section-block > h1:first-child");

    /*
последний тег p, находящийся сразу на первом уровне вложенности
внутри <form class="form" id="login-form">; Используйте поиск по child.
     */
    private By lastLocator = By.cssSelector("form.form > p:last-child");

    /*
 любой тег, который является третьим дочерним элементом первого уровня
 тега <body>; Используйте поиск по child.
     */
    private By oneLocator = By.cssSelector("body > *:nth-child(3)");

    /*
все элементы с тегом <a>, которые являются первым элементом своего
родителя <div class="footer__menuList">. Используйте поиск по type.
     */
    private By allLocator = By.cssSelector("div.footer__menuList > a:nth-of-type(1)");

    /*
найдите элемент с тегом <a>, который является первым дочерним
элементом данного типа у своего родителя <div class="footer__menuList">,
 при этом <div class="footer__menuList">
является первым дочерним элементом у своего родителя
<div class="footer__menu">.
Составленный поиск должен вернуть ровно один найденный элемент.
     */
    private By neighboringLocator = By.cssSelector("div.footer__menu > div:nth-child(1) > a:nth-child(2)");
}


