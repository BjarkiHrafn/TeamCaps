package is.ru.sTest;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class SeleniumTestWrapper {

  public static WebDriver driver;
  public static String baseUrl;
  public static String port;

  

  @BeforeClass
  public static void openBrowser() {
    
    final ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setBinary("/path/to/google-chrome-stable");
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--disable-gpu");
  
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    /*
    port = System.getenv("PORT");

    if (port == null) {

      port = "4567";
    }

    baseUrl = "http://localhost:" + port;
    */

    setBaseURL();

    if(baseUrl.contains("localhost"))
    {
      port = System.getenv("PORT");
          if (port == null) {
              port = "4567";
          }

      baseUrl += port;
    }

  }



  @AfterClass
  public static void closeBrowser() {

    driver.quit();
  }

  private static void setBaseURL()
    {
    String serverFilePath = System.getProperty("user.dir") + "/servers/server.txt";
        try
    {
      BufferedReader reader;
      reader = new BufferedReader(new FileReader(serverFilePath));
      try
      {
        baseUrl = reader.readLine();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      finally
      {
        try
        {
          reader.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    }

  public static WebDriver webDriver() {
      final ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setBinary(System.getProperty("google.chrome"));
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
