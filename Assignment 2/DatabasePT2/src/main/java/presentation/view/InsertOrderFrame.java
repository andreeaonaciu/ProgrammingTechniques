
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

public class InsertOrderFrame extends AbstractFrame{
	
	JComboBox clientsB;
	JComboBox productsB;
	JTextField quantity;
	JTextField price;
	JButton orderB;
	JButton priceB;
	JButton backB;
	JLabel sentence;
	String[] clients;
	String[] products;
	
	public InsertOrderFrame(String[] clients,String[] products)
	{
		super("Insert Order");
		setSize(600, 300);
 		
 		quantity=new JTextField(30);
 		price=new JTextField(30);
 		orderB=new JButton("ORDER");
 		backB=new JButton("MENU");
 		priceB=new JButton("CalculatePrice");
 		this.clients=clients;
 		this.products=products;
 		clientsB=new JComboBox(clients);
 		productsB=new JComboBox(products);
 		
		contentPanel.setLayout(new GridLayout(5,2));
		
		contentPanel.add(new JLabel("Client: "));
		contentPanel.add(clientsB);
		contentPanel.add(new JLabel("Products: "));
		contentPanel.add(productsB);
		contentPanel.add(new JLabel("Quantity: "));
		contentPanel.add(quantity);
		contentPanel.add(priceB);
		contentPanel.add(price);
		contentPanel.add(orderB);
		contentPanel.add(backB);
		
		setVisible(true);
	}
	
	 public String getQuantity() {
		return quantity.getText();
	}

	public String getClient() {
		return (String) clientsB.getSelectedItem();
	}

	public String getProducts() {
		return (String) productsB.getSelectedItem();
	}
	
	

	public void setClients(String[] clients) {
		this.clients = clients;
	}

	public void setProducts(String[] products) {
		this.products = products;
	}

	public void setPrice(String price) {
		this.price.setText(price);
	}

	public void setActionListenerBack(ActionListener a) {
	 		this.backB.addActionListener(a);
	 	}

	 public void setActionListenerSave(ActionListener a) {
	 		this.orderB.addActionListener(a);
	 	}
	 public void setActionListenerPrice(ActionListener a) {
	 		this.priceB.addActionListener(a);
	 	}
}