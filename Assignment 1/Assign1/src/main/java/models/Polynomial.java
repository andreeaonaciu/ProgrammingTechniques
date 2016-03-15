package models;

import java.util.ArrayList;
import java.util.StringJoiner;



public class Polynomial {

	private ArrayList<Term> term;

	public Polynomial() {
		this.term = new ArrayList<Term>();
	}

	public Polynomial(ArrayList<Term> terms) {
		this.term = terms;
	}

	public ArrayList<Term> getTerms() {
		return term;
	}

	public void setTerms(ArrayList<Term> terms) {
		this.term = terms;
	}

	// method that returns the degree of the polynomial
	public int getDegree() {
		int maxDegree = 0;
		for (Term t : term) {
			if (t.getDegree() > maxDegree && t.getCoeficient() != 0)
				maxDegree = t.getDegree();
		}

		return maxDegree;
	}

	// method that returns the coefficient of the leading term
	
	public double getCoefficientOfLeadingTerm() {
		double maxCoef = 0;
		int maxDegree = 0;
		for (Term t : term) {
			if (t.getDegree() > maxDegree && t.getCoeficient() != 0) {
				maxDegree = t.getDegree();
				maxCoef = t.getCoeficient();
			}
		}

		return maxCoef;
	}

	// returns a string representation of a polynomial

	public String toString() {

		StringJoiner myString = new StringJoiner("+");
        boolean notZero=true;
		for (Term t : this.term) {
			if (t.toString()=="0"){
				notZero=false;
			myString.add(t.toString());
			}
		}
		if (this.term.size()==0) return "Not valid entries!";
        if (!notZero) return "0";
		return myString.toString();

	}
	
	// adds one term to the current polynomial

	public void addTerm(Term t) {
		if (this.term.size() == 0)
			this.term.add(t);
		else {

			boolean added = false;

			for (Term myTerms : this.term) {
				if (t.getDegree() == myTerms.getDegree()) {
					myTerms.setCoeficient(myTerms.getCoeficient() + t.getCoeficient());
					added = true;
				}
			}

			if (!added)
				this.term.add(t);
		}
	}
	

	//substracts one term from the current polynomial
	
	public void substractTerm(Term t) {
		if (this.term.size() == 0)
			this.term.add(new Term(t.getDegree(), -t.getCoeficient()));
		else {
			boolean added = false;
			for (Term myTerms : this.term) {

				if (t.getDegree() == myTerms.getDegree()) {
					myTerms.setCoeficient(myTerms.getCoeficient() - t.getCoeficient());
					added = true;
				}
			}
			if (!added)
				this.term.add(new Term(t.getDegree(), -t.getCoeficient()));
		}
	}

}
