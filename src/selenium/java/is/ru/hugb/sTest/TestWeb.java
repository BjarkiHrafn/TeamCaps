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
    WebElement button = driver.findElement(By.id("resetGame"));
    button.click();

    Thread.sleep(5000);
    input.sendKeys("1");
    input.submit();
    Thread.sleep(5000);
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

    assertEquals("Error, illegal position...", message.getText());
  }

  public void testSwitchPlayer() throws Exception {
    driver.get(baseUrl);
    Thread.sleep(5000);

    WebElement input = driver.findElement(By.id("xIn"));
    WebElement player = driver.findElement(By.id("pRound"));
    assertEquals("O", player.getText());
    Thread.sleep(5000);
    input.sendKeys("2");
    input.submit();
    Thread.sleep(5000);

    assertEquals("X", player.getText());
  }

  @Test
  public void testWin() throws Exception {
    WebElement button = driver.findElement(By.id("resetGame"));
    button.click();

    WebElement input = driver.findElement(By.id("xIn"));
    WebElement input2 = driver.findElement(By.id("xIn"));
    WebElement input3 = driver.findElement(By.id("xIn"));
    WebElement input4 = driver.findElement(By.id("xIn"));
    WebElement input5 = driver.findElement(By.id("xIn"));
    input.sendKeys("1");
    input2.sendKeys("2");
    input3.sendKeys("4");
    input4.sendKeys("3");
    input5.sendKeys("7");

    WebElement result = driver.findElement(By.id("gameStatus"));
    assertEquals("X wins!", result.getText());
  }
}
