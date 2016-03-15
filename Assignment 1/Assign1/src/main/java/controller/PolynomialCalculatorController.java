package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.Addition;
import models.Diferentiation;
import models.Division;
import models.Integration;
import models.Multiplication;
import models.Polynomial;
import models.Subtraction;
import models.Term;
import views.PolynomialCalculatorFrame;

public class PolynomialCalculatorController extends AbstractController{
  
  public PolynomialCalculatorController(PolynomialCalculatorFrame frame)  {
	  // sets the action listeners of the buttons from the frame
	  super(frame);
	  frame.setActionListenerAddition(new AdditionButtonActionListener());
	  frame.setActionListenerDifferentiation(new DiferentiationButtonActionListener());
	  frame.setActionListenerIntegration(new IntegrationButtonActionListener());
	  frame.setActionListenerDivision(new DivisionButtonActionListener());
	  frame.setActionListenerMultiplication(new MultiplicationButtonActionListener());
	  frame.setActionListenerSubtraction(new SubtractionButtonActionListener());
	  
  }
  
  private class AdditionButtonActionListener  implements ActionListener {


		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//converts polyA and polyB, form the input into polynomials and sets the result of addition
			binOp=new Addition(); 
			polyA=converter.conevertStringIntoPolynomial(frame.getPolyA()); 
			polyB=converter.conevertStringIntoPolynomial(frame.getPolyB());
			frame.setResult(binOp.execute(polyA, polyB).get(0).toString());
			frame.setRest(" ");
		}
  }
  
  private class SubtractionButtonActionListener implements ActionListener {


		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//converts polyA and polyB, form the input into polynomials and sets the result ofsubtraction
			binOp=new Subtraction();
			polyA=converter.conevertStringIntoPolynomial(frame.getPolyA());
			polyB=converter.conevertStringIntoPolynomial(frame.getPolyB());
			frame.setResult(binOp.execute(polyA, polyB).get(0).toString());
			frame.setRest(" ");
		}
}
  
  private class MultiplicationButtonActionListener implements ActionListener {


		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//converts polyA and polyB, form the input into polynomials and sets the result of multiplication
			binOp=new Multiplication();
			polyA=converter.conevertStringIntoPolynomial(frame.getPolyA());
			polyB=converter.conevertStringIntoPolynomial(frame.getPolyB());
			frame.setResult(binOp.execute(polyA, polyB).get(0).toString());
			frame.setRest(" ");
		}
}
  private class DivisionButtonActionListener implements ActionListener {


		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//converts polyA and polyB, form the input into polynomials and sets the result of division
			binOp=new Division();
			polyA=converter.conevertStringIntoPolynomial(frame.getPolyA());
			polyB=converter.conevertStringIntoPolynomial(frame.getPolyB());
			if (polyB.getDegree()==0) {
				frame.setResult("DIVISION BY ZERO");
				frame.setRest("");
			}
			else{
			result=binOp.execute(polyA, polyB);
			frame.setResult(result.get(0).toString());
			frame.setRest(result.get(1).toString());
			}
		}
}
  private class DiferentiationButtonActionListener implements ActionListener {


		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//converts polyA, form the input into polynomial and sets the result of diferentiation
			unyOp=new Diferentiation();
			polyA=converter.conevertStringIntoPolynomial(frame.getPolyA());
			frame.setResult(unyOp.execute(polyA).toString());
			frame.setRest(" ");
		}
}
  private class IntegrationButtonActionListener implements ActionListener {


		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//converts polyA, form the input into polynomial and sets the result of integration
			unyOp=new Integration();
			polyA=converter.conevertStringIntoPolynomial(frame.getPolyA());
			frame.setResult(unyOp.execute(polyA).toString());
			frame.setRest(" ");
		}
}
}
