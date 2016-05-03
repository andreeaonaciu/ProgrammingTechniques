package dataAccessObjects;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionFactory;
import model.Customer;
import model.Product;
 
public class ProductDAO {

    private Connection connection;
    private Statement statement;
    private ArrayList<Product> products=new ArrayList<Product>();
    String query;  
    ResultSet rs;
    
    public ArrayList<Product> getProducts() throws SQLException {
    	
         this.query = "SELECT * FROM product";
         this.rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
         
            while (rs.next())
            {
            	String name=rs.getString("Name");
            	int price=Integer.parseInt(rs.getString("Price"));
            	int quantity=Integer.parseInt(rs.getString("Quantity"));
            	products.add(new Product(name,price,quantity));
            }
           
        } finally {
        	connection.close();
        	statement.close();
        	rs.close();
        }
        
        return this.products;
    }
    
        public Product getProduct(String name) throws SQLException{
    	  this.query = "SELECT * FROM product WHERE Name like '"+name+"'" ;
    	 this.rs = null;
        Product product=null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            this.rs = statement.executeQuery(query);
            rs.next();
            product=new Product(rs.getString("Name"),Integer.parseInt(rs.getString("Quantity")),Integer.parseInt(rs.getString("Price")));
           
        } finally {
        connection.close();
        statement.close();
        rs.close();
        }
        
        return product;
    }
    
  
 public void insertProduct(Product product) throws SQLException {
	 
	 String price=String.valueOf(product.getPrice());
	 String quantity=String.valueOf(product.getQuantity());
     this.query = "INSERT INTO product (Name, Price, Quantity) VALUES('"+product.getName()+"','"+ price+"','"+quantity+"')";
    
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
  
        } finally {
        	connection.close();
        	statement.close();
        	
        }
        
    }
 
 public void deleteProduct(String product) throws SQLException {
 	
     this.query = "Delete from product where Name='"+product+"'";//(Name, Email) VALUES('"+customer.getName()+"','"+ customer.getEmail()+"')";
 
     try {
         connection = ConnectionFactory.getConnection();
         statement = connection.createStatement();
         statement.executeUpdate(query);
         System.out.println(product);

     } finally {
    	 connection.close();
     	 statement.close();
     	
     }
     
 }
 
 public void updateProduct(Product product) throws SQLException {
	 	
     this.query = "UPDATE product SET Price="+product.getPrice()+", Quantity="+product.getQuantity()+" where Name="+ "'"+product.getName()+"'";
     
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