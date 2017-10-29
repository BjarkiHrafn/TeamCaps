package is.ru.sTest;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;


public class TestWeb  {
  static WebDriver driver;
  static String baseUrl;
  static String port;

  @BeforeClass
  public static void initialize() {
    driver = new ChromeDriver();
    port = System.getenv("PORT");
    if(port == null) {
      port = "4567";
    }
    baseUrl = "http://localhost:"+port;
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterClass
  public static void endOfSession() {
    driver.close();
  }

  @Test
  public void testTitleMatches() {
    //System.setProperty("Web");
    driver.get(baseUrl);

    assertEquals("baldurs geit", driver.getTitle());
  }

  /*@Test
  public void testInputX() throws Exception {
    driver.get(baseUrl);

    Thread.sleep(5000);
    WebElement input = driver.findElement(By.id("xIn"));
    WebElement message = driver.findElement(By.id("1"));
    input.sendKeys("1");
    input.submit();
    assertEquals("X", message.getText());

  }*/

}
