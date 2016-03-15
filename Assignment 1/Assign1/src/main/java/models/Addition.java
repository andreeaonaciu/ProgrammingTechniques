package models;

import java.util.ArrayList;

public class Addition extends BinaryOperation {

	@Override
	public ArrayList<Polynomial> execute(Polynomial operand1, Polynomial operand2) {
		// TODO Auto-generated method stub

		Polynomial result = new Polynomial();
		ArrayList<Polynomial> res = new ArrayList<Polynomial>();
		Boolean added = false;
		result.setTerms(operand1.getTerms());
		ArrayList<Term> resultTerms = result.getTerms();

			for (Term t2 : operand2.getTerms()) {
			    result.addTerm(t2);
				result.setTerms(resultTerms);
			}

		res.add(result);
		return res;
	}

}
