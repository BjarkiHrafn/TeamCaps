package is.ru.sTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;



public class TestWeb extends SeleniumTestWrapper {

  @Test

  public void testTitleMatches() {

    driver.get(baseUrl);
	
    assertEquals("Tic-Tac-Toe", driver.getTitle());
	

  }


}