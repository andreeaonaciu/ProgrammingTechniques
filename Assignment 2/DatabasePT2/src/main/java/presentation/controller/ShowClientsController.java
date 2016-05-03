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

public class ShowClientsController {
	CustomerOperations orderOp=new CustomerOperations();
    ViewFrame frame;
	public ShowClientsController(ViewFrame fr) {
		this.frame=fr;
		// TODO Auto-generated constructor stub
		fr.setActionListenerBack(new ActionListenerBack());
	}
	
	public class ActionListenerBack implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub  
			frame.setVisible(false);
		    MainMenuFrame newFrame=new MainMenuFrame();
		    MenuController menu=new MenuController(newFrame);
		}
	}
	
	
}
