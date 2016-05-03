
package presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InsertProductFrame extends  AbstractFrame{
	
	JTextField name;
	JTextField price;
	JTextField quantity;
	JButton saveB;
	JButton backB;
	JLabel sentence;
	
	
	public InsertProductFrame()
	{
		super("Insert Product");
		setSize(600, 200);
 		
 		
 		name=new JTextField(30);
 		price=new JTextField(30);
 		quantity=new JTextField(30);
 		saveB=new JButton("SAVE");
 		backB=new JButton("MENU");
 		
 		
		contentPanel.setLayout(new GridLayout(4,2));
		
		contentPanel.add(new JLabel("Name: "));
		contentPanel.add(name);
		contentPanel.add(new JLabel("Price: "));
		contentPanel.add(price);
		contentPanel.add(new JLabel("Quantity: "));
		contentPanel.add(quantity);
		contentPanel.add(saveB);
		contentPanel.add(backB);
		
		setVisible(true);
	}
	
	 public String getName() {
		return name.getText();
	}

	public String getPrice() {
		return price.getText();
	}
	
	public String getQuantity() {
		return quantity.getText();
	}


	public void setActionListenerBack(ActionListener a) {
	 		this.backB.addActionListener(a);
	 	}

	 public void setActionListenerSave(ActionListener a) {
	 		this.saveB.addActionListener(a);
	 	}
}