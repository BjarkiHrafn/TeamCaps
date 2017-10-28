package is.ru.sTest;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class SeleniumTestWrapper {

  //static ChromeDriver driver;
  private WebDriver driver;

  static String baseUrl;

  static String port;

  final ChromeOptions chromeOptions = new ChromeOptions();
  chromeOptions.setBinary("/path/to/google-chrome-stable");
  chromeOptions.addArguments("--headless");
  chromeOptions.addArguments("--disable-gpu");

  final DesiredCapabilities dc = new DesiredCapabilities();
  dc.setJavascriptEnabled(true);
  dc.setCapability(
      ChromeOptions.CAPABILITY, chromeOptions
  );



  @BeforeClass
  public static void openBrowser() {

    //driver = new ChromeDriver(dc);
    WebDriver driver = new ChromeDriver(dc);
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
