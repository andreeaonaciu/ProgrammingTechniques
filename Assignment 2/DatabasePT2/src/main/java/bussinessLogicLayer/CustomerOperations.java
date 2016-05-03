package bussinessLogicLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dataAccessObjects.CustomerDAO;
import model.Customer;

public class CustomerOperations {
	CustomerDAO dao;

	public CustomerOperations() {
		dao = new CustomerDAO();
	}

	
	public String[][] getInfo() throws SQLException{
		
		ArrayList<Customer> customers=dao.getCostumers();
		String[][] info=new String[customers.size()][3];
		int i = 0;
		for (Customer customer : customers) {
			info[i][0] = String.valueOf(i);
			info[i][1] = customer.getName();
			info[i][2] = customer.getEmail();
			i++;
		}
		return info;
	}
	
	public String[] getCustomersNames() throws SQLException {
		int i=0;
		ArrayList<Customer> customers = dao.getCostumers();
		String[] names = new String[customers.size()];
		for (Customer customer : customers){
			names[i]=customer.getName();
			i++;
		}
		return names;
	}

	public boolean validateInsertCustomer(String name, String email) {
		
		if (name==null) return false;
		
		char[] chars = name.toCharArray();
       
		for (char c : chars) {
			if (!Character.isLetter(c) && c!=' ') {
				System.out.println("caractere");
				return false;
			}
		}
		if (!email.contains("@")){
			System.out.println("email");
			return false;
		}
			

		return true;
	}

	public boolean insertCustomer(String name, String email) throws SQLException {
		
		if (!validateInsertCustomer(name,email)) return false;

		Customer customer = new Customer(name, email);
		dao.insertCostumer(customer);
		return true;
	}

	public boolean updateCustomer(String name, String email) throws SQLException {
		if (!validateInsertCustomer(name,email)) return false;
		
		Customer customer = new Customer(name, email);
		dao.updateEmail(customer);
		return true;
	}

	public void deleteCustomer(String name) throws SQLException {
		dao.deleteCostumer(name);
	}
}
