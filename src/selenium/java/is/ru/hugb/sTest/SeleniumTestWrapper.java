package is.ru.sTest;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public abstract class SeleniumTestWrapper {

  static ChromeDriver driver;
  //static WebDriver driver;ss
  static String baseUrl;
  static String port;
//sss
  @BeforeClass
  public static void openBrowser() {
    ChromeOptions options = new ChromeOptions();
    //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromium-browser");

    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    port = System.getenv("PORT");

    if (port == null) {

      port = "4567";
    }

    baseUrl = "http://localhost:" + port;
  }



  @AfterClass
  public static void closeBrowser() {

    driver.quit();
  }

}
