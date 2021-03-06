
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Assert.*;
import controller.Converter;
import models.Addition;
import models.BinaryOperation;
import models.Division;
import models.Multiplication;
import models.Polynomial;


public class DivisionTest {
	@Test
	 public void DivisionTest(){
		
		 Polynomial a=new Polynomial();
		 Polynomial b=new Polynomial();
		 Converter conv=new Converter();
		 BinaryOperation op= new Division();
		 
		 a=conv.conevertStringIntoPolynomial("2x^3+1x^0");
		 b=conv.conevertStringIntoPolynomial("2x^3+1x^0");
		 
		 ArrayList<Polynomial> result=op.execute(a, b);	
		
		 assertEquals(result.get(0).toString(),"1.0x^0");
		 assertEquals(result.get(1).toString(),"0+0");
	 }
		
}
