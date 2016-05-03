
package presentation.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bussinessLogicLayer.CustomerOperations;
import bussinessLogicLayer.OrderOperations;
import bussinessLogicLayer.ProductOperations;
import presentation.view.*;

public class InsertCustomerController {
	CustomerOperations orderOp=new CustomerOperations();
    InsertClientFrame frame;
	public InsertCustomerController(InsertClientFrame fr) {
		this.frame=fr;
		// TODO Auto-generated constructor stub
		fr.setActionListenerBack(new ActionListenerBack());
		fr.setActionListenerSave(new ActionListenerSave());
	}
	
	public class ActionListenerBack implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub  
			frame.setVisible(false);
		    MainMenuFrame newFrame=new MainMenuFrame();
		    MenuController menu=new MenuController(newFrame);
		}
	}
	
	public class ActionListenerSave implements ActionListener {
        
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String name=frame.getName();
			String email=frame.getEmail();
			
			try {
				if (!orderOp.insertCustomer(name, email))
					JOptionPane.showMessageDialog(null, "Invalid input!");
				else JOptionPane.showMessageDialog(null, "Insert succeeded!");
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
}
	

