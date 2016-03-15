import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert.*;
import controller.Converter;
import models.Addition;
import models.BinaryOperation;
import models.Polynomial;

public class AdditionTest {
 
	@Test
 public void AdditionTest(){
	
	 Polynomial a=new Polynomial();
	 Polynomial b=new Polynomial();
	 Converter conv=new Converter();
	 BinaryOperation op= new Addition();
	 
	 a=conv.conevertStringIntoPolynomial("2x^3+1x^0");
	 b=conv.conevertStringIntoPolynomial("2x^3+2x^0");
	 
	 Polynomial result=op.execute(a, b).get(0);	
	 assertEquals(result.toString(),"4.0x^3+3.0x^0");
 }
	
}
