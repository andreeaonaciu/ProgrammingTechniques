package models;

import java.util.ArrayList;

public class Division extends BinaryOperation {

	@Override
	public ArrayList<Polynomial> execute(Polynomial operand1, Polynomial operand2) {

		ArrayList<Polynomial> result = new ArrayList<Polynomial>();

		if (operand2.getCoefficientOfLeadingTerm() == 0)
			throw new RuntimeException("Divide by zero.");
		else if (operand1.getDegree() < operand2.getDegree()) {
			result.add(new Polynomial());
			result.add(operand2);
			return result;
		} else {
		
			Polynomial quotient = new Polynomial();
			Polynomial rest = operand1;

			while (rest.getDegree() >= operand2.getDegree() && rest.getDegree() != 0) {
				// leading coefficients get divide
				Term t = new Term(rest.getDegree() - operand2.getDegree(),
						rest.getCoefficientOfLeadingTerm() / operand2.getCoefficientOfLeadingTerm());

				// The term is transformed into a polynomial
				ArrayList<Term> listOfTerms = new ArrayList<Term>();
				listOfTerms.add(t);
				Polynomial p = new Polynomial(listOfTerms);

				// this term is add to the final quotient
				BinaryOperation op = new Addition();
				quotient = op.execute(quotient, p).get(0);

				// p is multiplied with operand2 and substracted from the rest
				// to form a new rest
				op = new Multiplication();
				Polynomial intermidiante = op.execute(operand2, p).get(0);
				op = new Subtraction();
				rest = op.execute(rest, intermidiante).get(0);

			}

			result.add(quotient);
			result.add(rest);
		}
		return result;
	}

}
