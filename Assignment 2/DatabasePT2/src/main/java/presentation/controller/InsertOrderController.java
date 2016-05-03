package presentation.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bussinessLogicLayer.OrderOperations;
import presentation.view.*;

public class InsertOrderController {
    
	OrderOperations orderOp=new OrderOperations();
    InsertOrderFrame frame;
	public InsertOrderController(InsertOrderFrame fr) {
		this.frame=fr;
		// TODO Auto-generated constructor stub
		fr.setActionListenerBack(new ActionListenerBack());
		fr.setActionListenerSave(new ActionListenerSave());
		fr.setActionListenerPrice(new ActionListenerPrice());
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
			String client=frame.getClient();
			String product=frame.getProducts();
			String q=frame.getQuantity();
			try {
				if (!orderOp.insertOrder(client, product, q))
					JOptionPane.showMessageDialog(null, "Invalid input!");
				else JOptionPane.showMessageDialog(null, "Order succeeded!");
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
	
	public class ActionListenerPrice implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub  
			String product=frame.getProducts();
			String q=frame.getQuantity();
		    try {
				String price=orderOp.calculatePrice(product, q);
				frame.setPrice(price);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}
	}
	
}
