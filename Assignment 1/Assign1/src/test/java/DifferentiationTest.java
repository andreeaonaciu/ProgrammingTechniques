import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.Converter;
import models.BinaryOperation;
import models.Diferentiation;
import models.Multiplication;
import models.Polynomial;
import models.UnaryOperations;


	
public class DifferentiationTest {
	@Test
	 public void DiferentiationTest(){
		
		 Polynomial a=new Polynomial();
		 Converter conv=new Converter();
		 UnaryOperations op= new  Diferentiation();
		 a=conv.conevertStringIntoPolynomial("3x^3+1x^0");
		 Polynomial result=op.execute(a);	
		 assertEquals(result.toString(),"9.0x^2");
	 }
}
