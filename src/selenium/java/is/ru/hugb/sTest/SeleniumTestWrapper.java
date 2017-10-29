package is.ru.sTest;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class SeleniumTestWrapper {
  static ChromeDriver driver;
  static String baseUrl;
  static String port;

  @BeforeClass
  public static void openBrowser() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    baseUrl = "https://dry-bastion-22033.herokuapp.com/";
  }

  @Before
  public void setUp() {
    driver.get(baseUrl);
    WebElement input = driver.findElement(By.id("xIn"));
    WebElement message = driver.findElement(By.id("1"));
    WebElement button = driver.findElement(By.id("resetGame"));
    button.click();
  }

  @After
  public void isEnd() {
    Thread.sleep(5000);
    input.sendKeys("1");
    input.submit();
    Thread.sleep(5000);
    assertEquals("X", message.getText());
  }

  @AfterClass
  public static void closeBrowser() {
    driver.quit();
  }
}
