import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestClass1 {

    public static WebDriver driver;
@BeforeMethod
    public void launchDriver() {
        System.setProperty("webdriver.chrome.driver", getDriverPath("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        driver.navigate().to("https://www.automationtalks.com");
        System.out.println("test1 title is: " + driver.getTitle());
    }

    @Test
    public void test2() {
        driver.navigate().to("https://AutomationTalks.com");
        System.out.println("test2 title is: " + driver.getTitle());
    }

    @Test
    public void test3() {
        driver.navigate().to("https://AutomationTalks.com");
        System.out.println("test3 title is: " + driver.getTitle());
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    protected String getDriverPath(String driverFileName) {
        driverFileName = OsUtils.isWindows() ? driverFileName + ".exe" : driverFileName;
       // driverFileName = OsUtils.isMac() ? driverFileName + ".exe" : driverFileName;
        return getClass().getClassLoader().getResource("drivers/" + driverFileName).getPath();
    }
}
