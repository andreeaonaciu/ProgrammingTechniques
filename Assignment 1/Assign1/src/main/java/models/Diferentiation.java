package models;

public class Diferentiation extends UnaryOperations {

	@Override
	public Polynomial execute(Polynomial operand1) {
		// TODO Auto-generated method stub
		
		Polynomial result=new Polynomial();
		
		for (Term t:operand1.getTerms()){
			if (t.getDegree()!=0) {
				Term t1=new Term(t.getDegree()-1,t.getCoeficient()*t.getDegree());
				result.getTerms().add(t1);
			}
		}
		return result;
	}

}
