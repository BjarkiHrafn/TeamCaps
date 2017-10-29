<<<<<<< HEAD
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
    WebElement message = driver.findElement(By.id("5"));
    input.sendKeys("5");
    input.submit();
      Thread.sleep(5000);
    assertEquals("X", message.getText());

  }

}
=======

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

}

>>>>>>> 6cadea9404fd76c6ccf29b3bead977b520f2f279
