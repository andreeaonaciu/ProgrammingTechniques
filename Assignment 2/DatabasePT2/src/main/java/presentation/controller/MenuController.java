package presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bussinessLogicLayer.CustomerOperations;
import bussinessLogicLayer.ProductOperations;
import presentation.view.*;//AbstractFrame;
import presentation.view.DeleteCustomerFrame;
import presentation.view.DeleteProductsFrame;
import presentation.view.InsertClientFrame;
import presentation.view.InsertOrderFrame;
import presentation.view.InsertProductFrame;
import presentation.view.MainMenuFrame;
import presentation.view.UpdateCustomerFrame;
import presentation.view.UpdateProductFrame;
import presentation.view.ViewFrame;

public class MenuController extends AbstractController {
   
	public MenuController(MainMenuFrame frame) {
		super(frame);
		frame.setActionListenerDeleteCustomer(new ActionListenerDeleteCustomer());
		frame.setActionListenerDeleteProduct(new ActionListenerDeleteProduct());
		frame.setActionListenerInsertCustomer(new ActionListenerInsertCustomer());
		frame.setActionListenerInsertOrder(new ActionListenerInsertOrder());
		frame.setActionListenerInsertProduct(new ActionListenerInsertProduct());
		frame.setActionListenerUpdateCustomer(new ActionListenerUpdateCustomer());
		frame.setActionListenerUpdateProduct(new ActionListenerUpdateProduct());
		frame.setActionListenerViewCustomer(new ActionListenerViewCustomer());
		frame.setActionListenerViewProduct(new ActionListenerViewProduct());
	}

	public class ActionListenerDeleteCustomer implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
           frame.setVisible(false);
           CustomerOperations customer=new CustomerOperations();
           try {
        	   DeleteCustomerFrame newFrame=new DeleteCustomerFrame(customer.getCustomersNames());
        	   DeleteCustomerController controller=new DeleteCustomerController(newFrame);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}

	public class ActionListenerDeleteProduct implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			frame.setVisible(false);
			ProductOperations op=new ProductOperations();
			try {
				DeleteProductsFrame  newFrame=new DeleteProductsFrame(op.getProductsNames());
				DeleteProductController controller=new DeleteProductController(newFrame);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class ActionListenerInsertCustomer implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			frame.setVisible(false);
			InsertClientFrame  newFrame=new InsertClientFrame();
			InsertCustomerController controller=new InsertCustomerController(newFrame);
		}
	}

	public class ActionListenerInsertOrder implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			frame.setVisible(false);
			ProductOperations op=new ProductOperations();
			CustomerOperations customer=new CustomerOperations();
			try {
				InsertOrderFrame newFrame=new InsertOrderFrame(customer.getCustomersNames(),op.getProductsNames());
				InsertOrderController control=new InsertOrderController(newFrame);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class ActionListenerInsertProduct implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			frame.setVisible(false);
			InsertProductFrame newFrame=new InsertProductFrame();
			InsertProductController control=new InsertProductController(newFrame);
		}

	}

	public class ActionListenerUpdateCustomer implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			frame.setVisible(false);
			CustomerOperations customer=new CustomerOperations();
			try {
				UpdateCustomerFrame newFrame=new UpdateCustomerFrame(customer.getCustomersNames());
				UpdateCustomerController control=new UpdateCustomerController(newFrame);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public class ActionListenerUpdateProduct implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			frame.setVisible(false);
			ProductOperations op=new ProductOperations();
			try {
				UpdateProductFrame newFrame=new UpdateProductFrame(op.getProductsNames());
				UpdateProductController control=new UpdateProductController(newFrame);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class ActionListenerViewCustomer implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			frame.setVisible(false);
			CustomerOperations customer=new CustomerOperations();
			String[] columns={"NrCrt","Name","E-mail"};
			ViewFrame newFrame;
			try {
				newFrame = new ViewFrame(customer.getInfo(),columns);
				ShowClientsController controller=new ShowClientsController(newFrame);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

	public class ActionListenerViewProduct implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			frame.setVisible(false);
			String[] columns={"NrCrt","Name","Price","Quantity"};
			ProductOperations op=new ProductOperations();
			ViewFrame newFrame;
			try {
				newFrame = new ViewFrame(op.getInfo(),columns);
				ShowProductsController controller=new ShowProductsController(newFrame);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
