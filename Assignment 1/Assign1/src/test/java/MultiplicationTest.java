
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert.*;
import controller.Converter;
import models.Addition;
import models.BinaryOperation;
import models.Multiplication;
import models.Polynomial;

public class MultiplicationTest {
 
	@Test
 public void MultiplicationTest(){
	
	 Polynomial a=new Polynomial();
	 Polynomial b=new Polynomial();
	 Converter conv=new Converter();
	 BinaryOperation op= new Multiplication();
	 
	 a=conv.conevertStringIntoPolynomial("2x^3+1x^0");
	 b=conv.conevertStringIntoPolynomial("2x^3+2x^0");
	 
	 Polynomial result=op.execute(a, b).get(0);	
	 assertEquals(result.toString(),"2.0x^0+6.0x^3+4.0x^6");
 }
	
}

