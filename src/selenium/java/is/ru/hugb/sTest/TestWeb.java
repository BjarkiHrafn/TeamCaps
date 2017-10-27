package is.ru.sTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestWeb extends SeleniumTestWrapper {

  @Test
  public void testTitleMatches() {

    driver.get(baseUrl);

    assertEquals("team caps lock", driver.getTitle());
  }
}
