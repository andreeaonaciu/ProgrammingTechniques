
package presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DeleteProductsFrame extends AbstractFrame{
	JComboBox products;
	String[] productsNames;
	JButton  deleteB;
	JButton backB;
	public DeleteProductsFrame(String[] names)
	{
		super("DELETE Product");
		this.productsNames=names;
		products=new JComboBox(names);
		contentPanel.add(products);
		deleteB=new JButton("DELETE");
		backB=new JButton("Menu");
		contentPanel.add(deleteB);
		contentPanel.add(backB);
		setVisible(true);
	}

	public String getProduct() {
		return (String) products.getSelectedItem();
	}
	public void setProductsNames(String[] clientsNames) {
		this.productsNames = clientsNames;
	}
	
	 public void setActionListenerDeleteCustomer(ActionListener a) {
	 		this.deleteB.addActionListener(a);
	 	}
	 public void setActionListenerBack(ActionListener a) {
	 		this.backB.addActionListener(a);
	 	}
}
