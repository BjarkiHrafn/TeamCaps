package is.ru.sTest;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class SeleniumTestWrapper {

  static ChromeDriver driver;
  //static WebDriver driver;
  static String baseUrl;
  static String port;



  @BeforeClass
  public static void openBrowser() {

    driver = new ChromeDriver();
    //driver = webDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    port = System.getenv("PORT");

    if (port == null) {

      port = "4567";
    }

    //baseUrl = System.getProperty("user.dir") + "/servers/server.txt";
    baseUrl = "https://dry-bastion-22033.herokuapp.com/";

    //baseUrl = "http://localhost:" + port;

  }



  @AfterClass
  public static void closeBrowser() {

    driver.quit();
  }

  public static ChromeDriver webDriver() {
      final ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setBinary(System.getProperty("google.chrome"));
      chromeOptions.addArguments("--no-sandbox");
      chromeOptions.addArguments("--headless");
      chromeOptions.addArguments("--disable-gpu");
      final DesiredCapabilities dc = new DesiredCapabilities();
      dc.setJavascriptEnabled(true);
      dc.setCapability(
          ChromeOptions.CAPABILITY, chromeOptions
      );
      return new ChromeDriver(dc);
  }

}
