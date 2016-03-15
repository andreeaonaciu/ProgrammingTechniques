
import static org.junit.Assert.*;

	import org.junit.Test;
	import org.junit.Assert.*;
	import controller.Converter;
	import models.Addition;
	import models.BinaryOperation;
	import models.Polynomial;
import models.Subtraction;
	
public class SubtractionTest {

		@Test
	 public void SubtractionTest(){
		
		 Polynomial a=new Polynomial();
		 Polynomial b=new Polynomial();
		 Converter conv=new Converter();
		 a=conv.conevertStringIntoPolynomial("2x^4+1x^0");
		 b=conv.conevertStringIntoPolynomial("2x^3+2x^0");
		 
		 BinaryOperation op= new Subtraction();
		 Polynomial result=op.execute(a, b).get(0);

		 assertEquals(result.toString(),"2.0x^4+(-1.0x^0)+(-2.0x^3)");
	 }
		
	}


