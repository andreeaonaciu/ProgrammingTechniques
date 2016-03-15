package controller;

import java.util.ArrayList;

import models.BinaryOperation;
import models.Polynomial;
import models.UnaryOperations;
import views.PolynomialCalculatorFrame;

abstract public class AbstractController {

	PolynomialCalculatorFrame frame;
	Polynomial polyA;
	Polynomial polyB;
	Converter converter;
	BinaryOperation binOp;
	UnaryOperations unyOp;
	ArrayList<Polynomial> result;
	
	public AbstractController(PolynomialCalculatorFrame frame){
		this.frame=frame;
		polyA=new Polynomial();
		polyB=new Polynomial();
		converter=new Converter();
	}
	
}
