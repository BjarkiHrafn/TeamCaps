package is.ru.sTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestWeb extends SeleniumTestWrapper {

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
