
package is.ru.sTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestWeb extends SeleniumTestWrapper {

  @Test
  public void testTitleMatches() {

    driver.get(baseUrl);

    assertEquals("team caps lock", driver.getTitle());
  }

  @Test
  public void testInputX() throws Exception {
    driver.get(baseUrl);

    Thread.sleep(5000);
    WebElement input = driver.findElement(By.id("xIn"));
    WebElement message = driver.findElement(By.id("1"));
    input.sendKeys("1");
    input.submit();
    assertEquals("X", message.getText());
  }

  @Test
  public void testIllegalInput() throws Exception {
    driver.get(baseUrl);

    Thread.sleep(5000);
    WebElement input = driver.findElement(By.id("xIn"));
    WebElement message = driver.findElement(By.id("error"));
    input.sendKeys("0");
    Thread.sleep(5000);
    input.submit();
    Thread.sleep(5000);
    assertEquals("Error, illegal position...", message.getText());


  }

}

