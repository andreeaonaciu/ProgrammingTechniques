package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Order {

	String customer;
	String product;
	Double price;
	int quantity;
	
	public Order(String customerID,String productID,Double price,int quantity)
	{
		this.customer=customerID;
		this.product=productID;
		this.price=price;
		this.quantity=quantity;
		
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void generateInvoice() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(this.customer+".txt", "UTF-8");
		writer.println("Client: "+this.customer);
		writer.println("Product: "+this.product);
		writer.println("Quantity: "+this.quantity);
		writer.println("Price: "+this.price);
		
		writer.close();
	}
}
