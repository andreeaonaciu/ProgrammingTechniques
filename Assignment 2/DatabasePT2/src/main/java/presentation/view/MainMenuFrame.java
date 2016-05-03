package presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenuFrame extends AbstractFrame{
	JButton insertCustomerB;
	JButton insertProductB;
	JButton insertOrderB;
	JButton deleteProductB;
	JButton deleteCustomerB;
	JButton updateProductB;
	JButton updateCustomerB;
	JButton viewCustomerB;
	JButton viewProductsB;
	
	
     public MainMenuFrame()
     {
    	 super("The College's Shop");
    	 insertCustomerB=new JButton("Add Client");
         insertProductB=new JButton("Add Product");
    	 insertOrderB=new JButton("Add Order");
    	 deleteProductB=new JButton("Delete Product");
    	 deleteCustomerB=new JButton("Delete Client");
    	 updateProductB=new JButton("Update Product");
    	 updateCustomerB=new JButton("Update Client");
    	 viewCustomerB=new JButton("View Clients");
    	 viewProductsB=new JButton("View Products");
    	 
    	 setSize(600, 600);
 		 
		
		contentPanel.setLayout(new GridLayout(5,3));
		contentPanel.add(new JLabel("_____CLIENT operations______"));
		contentPanel.add(new JLabel("_____PRODUCT Operations____"));
		contentPanel.add(new JLabel("_____ORDER Operations______"));
		contentPanel.add(insertCustomerB);
		contentPanel.add(insertProductB);
		contentPanel.add(insertOrderB);
		contentPanel.add(deleteCustomerB);
		contentPanel.add(deleteProductB);
		JPanel inter=new JPanel();
		inter.setBackground(Color.gray);
		contentPanel.add(inter);
		contentPanel.add(updateCustomerB);
		contentPanel.add(updateProductB);
		JPanel inter1=new JPanel();
		inter1.setBackground(Color.gray);
		contentPanel.add(inter1);
		contentPanel.add(viewCustomerB);
		contentPanel.add(viewProductsB);
		JPanel inter2=new JPanel();
		inter2.setBackground(Color.gray);
		contentPanel.add(inter2);
		
		setVisible(true);
     }
	
     public void setActionListenerInsertCustomer(ActionListener a) {
 		this.insertCustomerB.addActionListener(a);
 	}
     
     public void setActionListenerInsertProduct(ActionListener a) {
  		this.insertProductB.addActionListener(a);
  	}
     
     public void setActionListenerDeleteCustomer(ActionListener a) {
  		this.deleteCustomerB.addActionListener(a);
  	}
     public void setActionListenerDeleteProduct(ActionListener a) {
   		this.deleteProductB.addActionListener(a);
   	}
     
     public void setActionListenerUpdateProduct(ActionListener a) {
    		this.updateProductB.addActionListener(a);
    	}
     
     public void setActionListenerUpdateCustomer(ActionListener a) {
 		this.updateCustomerB.addActionListener(a);
 	}
     
     public void setActionListenerViewProduct(ActionListener a) {
 		this.viewProductsB.addActionListener(a);
 	}
     
     public void setActionListenerViewCustomer(ActionListener a) {
  		this.viewCustomerB.addActionListener(a);
  	}
     
     public void setActionListenerInsertOrder(ActionListener a) {
   		this.insertOrderB.addActionListener(a);
   	}
}

