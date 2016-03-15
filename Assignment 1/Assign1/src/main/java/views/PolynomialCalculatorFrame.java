package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class PolynomialCalculatorFrame extends JFrame {
	
	protected JPanel contentPanel;
	protected JTextField polyA=new JTextField(10);
	protected JTextField polyB=new JTextField(10);
	protected JTextField result= new JTextField(10);
	protected JTextField rest= new JTextField(10);
	protected JButton differentiation=new JButton("Derivative of A");
	protected JButton integration = new JButton("Integral of A");
	protected JButton addition=new JButton("A+B");
	protected JButton subtraction = new JButton("A-B");
	protected JButton multiplication=new JButton("A*B");
	protected JButton division = new JButton("A/B");
	
	public PolynomialCalculatorFrame(String title){
		
		//INTRO
		super(title);
		setSize(480, 400);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.blue);
		add(contentPanel, BorderLayout.CENTER);
		polyA.setText("0");
		polyB.setText("0");
		result.setText("0");
		rest.setText("0");
		//TWO LINES INPUT AND RESULT
		contentPanel.setLayout(new GridLayout(2,0));
		JPanel inputPart=new JPanel();
		JPanel resultPart=new JPanel();
		contentPanel.add(inputPart);
		contentPanel.add(resultPart);
		
		
		// Input area 2 zones - insertPoly and buttons
		inputPart.setLayout(new GridLayout(0,2));
		JPanel insertPoly= new JPanel();
		inputPart.add(insertPoly);
		
		
		//Polynomial A
		JLabel sentence= new JLabel("Polynomial A:");
		insertPoly.add(sentence);
		insertPoly.add(polyA);
		
		
		//Polynomial B
		sentence= new JLabel("Polynomial B:");
		insertPoly.add(sentence);
		insertPoly.add(polyB);
		
		// Constraints..
		insertPoly.add(Box.createRigidArea(new Dimension(0,50)));
		sentence= new JLabel("The polynomial must be of variable x,"); 
		insertPoly.add(sentence);
		sentence= new JLabel("written in the format: 3x^3+2x^2-2");
		insertPoly.add(sentence);
		
		//BUTTONS
		JPanel buttons=new JPanel();
		inputPart.add(buttons);
		buttons.setLayout(new GridLayout(4,0));
		JPanel binaryOp= new JPanel();
		binaryOp.setLayout(new GridLayout(2,2));
		buttons.add(binaryOp);
		
		
		//UnaryOperations
		buttons.add(differentiation);
		buttons.add(integration);
		
		//BinaryOperations
	
		binaryOp.add(addition);
		binaryOp.add(subtraction);
		
		binaryOp.add(multiplication);
		binaryOp.add(division);
		
		//Result Part
		sentence= new JLabel("Result:");
		resultPart.add(sentence);
		//resultPart.add(Box.createRigidArea(new Dimension(0,100)));
		resultPart.add(result);
		resultPart.add(Box.createRigidArea(new Dimension(0,200)));
	    sentence = new JLabel("Rest: ");
	    resultPart.add(sentence);
	    resultPart.add(rest);
	    
	    setVisible(true);   	
	}

	public String getPolyA() {
		return polyA.getText();
	}

	public String getPolyB() {
		return polyB.getText();
	}

	public void setResult(String text) {
		result.setText(text);
	}

	public void setRest(String text) {
		rest.setText(text);
	}
	
	public void setActionListenerDifferentiation(ActionListener a) {
		this.differentiation.addActionListener(a);
	}

	public void setActionListenerIntegration(ActionListener a) {
		this.integration.addActionListener(a);
	}

	public void setActionListenerAddition(ActionListener a) {
		this.addition.addActionListener(a);
	}

	public void setActionListenerSubtraction(ActionListener a) {
		this.subtraction.addActionListener(a);
	}
	public void setActionListenerMultiplication(ActionListener a) {
		this.multiplication.addActionListener(a);
	}

	public void setActionListenerDivision(ActionListener a) {
		this.division.addActionListener(a);
	}

}
