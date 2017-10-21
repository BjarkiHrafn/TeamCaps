package is.ru.hugb.ttt;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BusinessTest{
	@Test
    public void testSum() {
        assertEquals(18, Business.sum(5, 13));
    }
}