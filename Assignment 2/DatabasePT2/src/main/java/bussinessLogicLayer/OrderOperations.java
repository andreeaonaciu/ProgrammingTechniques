package bussinessLogicLayer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import dataAccessObjects.OrderDAO;
import dataAccessObjects.ProductDAO;
import model.Order;
import model.Product;

public class OrderOperations {
	OrderDAO daoOrder = new OrderDAO();
	ProductDAO daoProduct = new ProductDAO();
	Order order;

	public boolean validateOrder(Product product, String q) throws SQLException {
		boolean parsable = true;
		try {
			int quantity = Integer.parseInt(q);
			if (product.getQuantity() <= quantity)
				return false;
			    return true;
		} catch (NumberFormatException e) {
			parsable = false;
		}
		return parsable;
	}

	public String calculatePrice(String product, String q) throws SQLException {
		Product product1 = daoProduct.getProduct(product);
		float totalPrice = product1.getPrice() * Integer.parseInt(q);
		System.out.println(q+ product1.getPrice());
		return String.valueOf(totalPrice);
	}

	public boolean insertOrder(String client, String product, String q) throws SQLException, FileNotFoundException, UnsupportedEncodingException {
		Product product1 = daoProduct.getProduct(product);
		
		if (!validateOrder(product1, q))
			return false;
		int quantity = Integer.parseInt(q);
		
		int quantityLeft = product1.getQuantity() - quantity;
		product1.setQuantity(quantityLeft);
		
		daoProduct.updateProduct(product1);
		Double price=Double.valueOf(calculatePrice(product,q));
		order=new Order(client,product,price,quantity);
		daoOrder.insertOrder(order);
	    order.generateInvoice();
		return true;
	}

	
}
