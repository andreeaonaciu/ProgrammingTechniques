package dataAccessObjects;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionFactory;
import model.Customer;

 
public class CustomerDAO {
    private Connection connection;
    private Statement statement;
    private ArrayList<Customer> customers=new ArrayList<Customer>();
    String query;  
    ResultSet rs;
    
    public ArrayList<Customer> getCostumers() throws SQLException {
    	
         this.query = "SELECT * FROM customer";
         this.rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
        
            while (rs.next())
            {
            	this.customers.add(new Customer(rs.getString("Name"),rs.getString("Email")));
            }
           
        } finally {
        	connection.close();
        	statement.close();
        	rs.close();
        }
        
        return this.customers;
    }
    /*
    public Customer getCostumer(String name) throws SQLException{
    	String query = "SELECT * FROM customer WHERE Name='Onaciu Andreea'" ;
        ResultSet rs = null;
        Customer customer=null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            customer=new Customer(rs.getString("Name"),rs.getString("Email"));
           
        } finally {
        connection.close();
        	statement.close();
        	rs.close();
        }
        
        return customer;
    }
    
    */
 public void insertCostumer(Customer customer) throws SQLException {
    	
        this.query = "INSERT INTO customer (Name, Email) VALUES('"+customer.getName()+"','"+ customer.getEmail()+"')";
    
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
  
        } finally {
        	connection.close();
        	statement.close();
        	
        }
        
    }
 
 public void deleteCostumer(String customer) throws SQLException {
 	
     this.query = "Delete from customer where Name='"+customer+"'";//(Name, Email) VALUES('"+customer.getName()+"','"+ customer.getEmail()+"')";
 
     try {
         connection = ConnectionFactory.getConnection();
         statement = connection.createStatement();
         statement.executeUpdate(query);

     } finally {
    	 connection.close();
     	 statement.close();
     	
     }
     
 }
 public void updateEmail(Customer customer) throws SQLException {
	 	
     this.query = "UPDATE customer SET Email='"+customer.getEmail()+"' where Name="+ "'"+customer.getName()+"'";
 
     try {
         connection = ConnectionFactory.getConnection();
         statement = connection.createStatement();
         statement.executeUpdate(query);

     } finally {
        connection.close();
     	statement.close();
     	
     }
     
 }
}