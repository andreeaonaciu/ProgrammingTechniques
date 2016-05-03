
package presentation.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bussinessLogicLayer.OrderOperations;
import bussinessLogicLayer.ProductOperations;
import presentation.view.*;


public class DeleteProductController {
	ProductOperations orderOp=new ProductOperations();
    DeleteProductsFrame frame;
	public DeleteProductController(DeleteProductsFrame fr) {
		this.frame=fr;
		// TODO Auto-generated constructor stub
		fr.setActionListenerBack(new ActionListenerBack());
		fr.setActionListenerDeleteCustomer(new ActionListenerDelete());
	}
	
	public class ActionListenerBack implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub  
			frame.setVisible(false);
		    MainMenuFrame newFrame=new MainMenuFrame();
		    MenuController menu=new MenuController(newFrame);
		}
	}
	
	public class ActionListenerDelete implements ActionListener {
        
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String name=frame.getProduct();
			
			try {
						orderOp.deleteProduct(name);
				JOptionPane.showMessageDialog(null, "Delete succeeded!");
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Unsucceeded deletion!");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
}
	

