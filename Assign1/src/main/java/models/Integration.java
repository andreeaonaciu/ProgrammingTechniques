package models;

public class Integration extends UnaryOperations {

	@Override
	public Polynomial execute(Polynomial operand) {
		// TODO Auto-generated method stub
Polynomial result=new Polynomial();
		
		for (Term t:operand.getTerms()){
				Term t1=new Term(t.getDegree()+1,t.getCoeficient()/(t.getDegree()+1));
				result.getTerms().add(t1);
		}
		return result;
		
	}
	

}
