import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.Converter;
import models.Diferentiation;
import models.Integration;
import models.Polynomial;
import models.UnaryOperations;

public class IntegrationTest {
	@Test
	public void IntegrationTest() {

		Polynomial a = new Polynomial();
		Converter conv = new Converter();
		UnaryOperations op = new Integration();

		a = conv.conevertStringIntoPolynomial("4x^3+2x^0");

		Polynomial result = op.execute(a);
		assertEquals(result.toString(), "1.0x^4+2.0x^1");
	}
}
