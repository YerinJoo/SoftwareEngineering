import static org.junit.Assert.*;
import org.junit.Test;
//import SimpleProgram.Calculator;

public class Calculator {

	@Test
	public void testCalc() {
		SimpleProgram sp = new SimpleProgram();
		SimpleProgram.Calculator ca = sp.new Calculator();
		assertEquals(8, ca.calc(2, 4, "*"));
	}

}
