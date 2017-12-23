import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testCalc() {
		SimpleProgram sp = new SimpleProgram();
		SimpleProgram.Calculator ca = sp.new Calculator();
		assertEquals(8, ca.calc(2, 4, "*"));
	}

}
