package models;

import java.util.ArrayList;
import java.util.Collections;

public class Multiplication extends BinaryOperation {

	@Override
	public ArrayList<Polynomial> execute(Polynomial operand1, Polynomial operand2) {
		// TODO Auto-generated method stub
		Polynomial result=new Polynomial();
		ArrayList<Polynomial> res=new ArrayList<Polynomial>();
		for (Term t1: operand1.getTerms())
			for (Term t2: operand2.getTerms()){
				
				Term t=new Term(0,0);
				t.setCoeficient(t1.getCoeficient()*t2.getCoeficient());
				t.setDegree(t1.getDegree()+t2.getDegree());
				result.addTerm(t);
				
			}
		Collections.sort(result.getTerms());
		res.add(result);
		return res;
	}

}
