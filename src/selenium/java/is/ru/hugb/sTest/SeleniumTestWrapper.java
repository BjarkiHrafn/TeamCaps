package is.ru.sTest;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public abstract class SeleniumTestWrapper {

  static ChromeDriver driver;
  //static WebDriver driver;
  static String baseUrl;
  static String port;

  @BeforeClass
  public static void openBrowser() {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Notandi\\Downloads\\Selenium\\chromedriver.exe");
    //driver = new ChromeDriver(dc);
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

  public static WebDriver chromeBrowser(){
      System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--no-sandbox");
      options.addArguments("--headless");
      WebDriver browser = new ChromeDriver(options);
      browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      return browser;

  }



}
