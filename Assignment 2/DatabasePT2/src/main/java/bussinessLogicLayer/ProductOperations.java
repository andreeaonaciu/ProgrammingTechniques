package bussinessLogicLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dataAccessObjects.CustomerDAO;
import dataAccessObjects.ProductDAO;
import model.Customer;
import model.Product;

public class ProductOperations {
	ProductDAO dao;

	public ProductOperations() {

		dao = new ProductDAO();
	}
public String[][] getInfo() throws SQLException{
		
		ArrayList<Product> products=dao.getProducts();
		String[][] info=new String[products.size()][4];
		int i = 0;
		for (Product product : products) {
			info[i][0] = String.valueOf(i);
			info[i][1] = product.getName();
			info[i][2] = String.valueOf(product.getPrice());
			info[i][3]= String.valueOf(product.getQuantity());
			i++;
		}
		return info;
	}
	

	public String[] getProductsNames() throws SQLException {
		int i=0;
		ProductDAO dao = new ProductDAO();
		ArrayList<Product> products = dao.getProducts();
		String[] names = new String[products.size()];
		for (Product product : products){
			names[i]=product.getName();
			i++;
		}
		return names;
	}

	public boolean validateInsertProduct(String name, String price, String quantity) {

		try {
			int p = Integer.parseInt(price);
			int q = Integer.parseInt(quantity);
			if (name == null)
				return false;
			if (p <= 0)
				return false;
			if (q <= 0)
				return false;

			char[] chars = name.toCharArray();

			for (char c : chars) {
				if (!Character.isLetter(c) && c!=' ') {
					return false;
				}
			}

			return true;

		} catch (NumberFormatException e) {
			return false;
		}

	}

	public boolean insertProduct(String name, String price, String quantity) throws SQLException {

		if (!validateInsertProduct(name, price, quantity))
			return false;
		int p = Integer.parseInt(price);
		int q = Integer.parseInt(quantity);
		Product product = new Product(name, p, q);
		dao.insertProduct(product);
		return true;
	}

	public boolean updateProduct(String name, String price, String quantity) throws SQLException {

		if (!validateInsertProduct(name, price, quantity))
			return false;
		int p = Integer.parseInt(price);
		int q = Integer.parseInt(quantity);
		Product product = new Product(name, q, p);
		dao.updateProduct(product);
		return true;
	}

	public void deleteProduct(String name) throws SQLException {
		dao.deleteProduct(name);
	}
}