package models;

public class Term  implements Comparable<Term> {

	private int degree;
	private double coeficient;
		
	public Term(int degree, double coeficient) {
		this.degree = degree;
		this.coeficient = coeficient;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public double getCoeficient() {
		return coeficient;
	}

	public void setCoeficient(double coeficient) {
		this.coeficient = coeficient;
	}

	

	// compares 2 terms based on their degree
	public int compareTo(Term arg0) {
		// TODO Auto-generated method stub 
		if (this.degree>arg0.degree) return 1;
		if (this.degree<arg0.degree) return -1;
		return 0;
	}

	//returns a string representation of the term
	
	public String toString() {
	
		if (this.getCoeficient()==0) return "0";
		else if (this.getCoeficient()>0)  
			return this.getCoeficient()+"x^"+this.getDegree();
		else 
			return "("+this.getCoeficient()+"x^"+this.getDegree()+")";
	}
}