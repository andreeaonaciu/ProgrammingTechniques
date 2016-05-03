package presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DeleteCustomerFrame extends AbstractFrame{
	JComboBox clients;
	String[] clientsNames;
	JButton  deleteB;
	JButton backB;
	
	public DeleteCustomerFrame(String[] clientsNames)
	{
		super("DELETE Customer");
		this.clientsNames=clientsNames;
		clients=new JComboBox(clientsNames);
		contentPanel.add(clients);
		deleteB=new JButton("DELETE");	
		backB=new JButton("Menu");
		
		contentPanel.add(deleteB);
	    contentPanel.add(backB);
	}

	public String getClient() {
		return (String) clients.getSelectedItem();
	}
	
	public void setClientsNames(String[] names) {
		this.clientsNames = names;
	}
	
	 public void setActionListenerDeleteCustomer(ActionListener a) {
	 		this.deleteB.addActionListener(a);
	 	}
	 public void setActionListenerBack(ActionListener a) {
	 		this.backB.addActionListener(a);
	 	}
}
