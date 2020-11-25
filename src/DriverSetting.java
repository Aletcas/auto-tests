import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSetting {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        // разворачиваем полностью экран
        //    driver.manage().window().maximize();
        // неявное ожидание Implicitly Wait, которое задается вначале теста и будет работать при каждом вызове метода поиска элемента:
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Таким образом, если элемент не найден, то драйвер будет ждать его появления в течении заданного времени (5 секунд) и шагом в 500 мс. Как только элемент будет найден, драйвер продолжит работу, однако, в противном случае тест упадем по истечению времени.
    
    
    }

 /*   @AfterClass
    public static void tearDownClass() throws IOException {
        var sourseFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourseFile, new File("c:\\tmp\\screenshot.png"));
        driver.quit();
    } */
    
    
}



