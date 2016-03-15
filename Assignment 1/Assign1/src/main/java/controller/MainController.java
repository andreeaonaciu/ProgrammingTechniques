package controller;

import views.PolynomialCalculatorFrame;


public class MainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolynomialCalculatorController controller=
				new PolynomialCalculatorController(new PolynomialCalculatorFrame("Polynomial Calculator")); 
	}

}
