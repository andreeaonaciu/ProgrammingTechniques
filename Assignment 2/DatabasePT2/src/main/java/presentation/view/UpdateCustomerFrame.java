
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

public class UpdateCustomerFrame extends AbstractFrame{
	
	JComboBox name;
	JTextField email;
	JButton saveB;
	JButton backB;
	JLabel sentence;
	JButton  deleteB;
	String[]  names;
	
	public UpdateCustomerFrame(String[]  names)
	{
		super("Update Client");
		setSize(600, 200);
 		
 		this.names=names;
 		name=new JComboBox(names);
 		email=new JTextField(30);
 		saveB=new JButton("SAVE");
 		backB=new JButton("MENU");
 		
 	
		contentPanel.setLayout(new GridLayout(3,2));
		
		contentPanel.add(new JLabel("Name: "));
		contentPanel.add(name);
		contentPanel.add(new JLabel("E-mail: "));
		contentPanel.add(email);
		contentPanel.add(saveB);
		contentPanel.add(backB);
		
//		setVisible(true);
	}
	
	 public String getName() {
		return (String)name.getSelectedItem();
	}

	public String getEmail() {
		return email.getText();
	}


	public void setNames(String[] names) {
		this.names = names;
	}

	public void setActionListenerBack(ActionListener a) {
	 		this.backB.addActionListener(a);
	 	}

	 public void setActionListenerSave(ActionListener a) {
	 		this.saveB.addActionListener(a);
	 	}
}