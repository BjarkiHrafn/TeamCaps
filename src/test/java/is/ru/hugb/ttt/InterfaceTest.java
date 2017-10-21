package is.ru.hugb.ttt;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InterfaceTest{
	@Test
    public void testHelloWorld() {
        assertEquals("Hello world!", Interface.helloWorld());
    }
}