package dataAccessObjects;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.ResultSetMetaData;

import connection.ConnectionFactory;
import model.Order;

 
public class OrderDAO {
    private Connection connection;
    private Statement statement;
    private ArrayList<Order> orders=new ArrayList<Order>();
    String query;  
    ResultSet rs;
    
    public ArrayList<Order> getOrders() throws SQLException {
    	
         this.query = "SELECT * FROM orderdetails";
         this.rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement=connection.createStatement();
            rs=statement.executeQuery(query);
            
            while (rs.next())
            {
            	this.orders.add(new Order(rs.getString("Customer"),rs.getString("Product"),
            			Double.parseDouble(rs.getString("Price")),Integer.parseInt(rs.getString("quantity"))));
            }
           
        } finally {
        	connection.close();
        	statement.close();
        	rs.close();
        }
        
        return this.orders;
    }
   
 
  public void insertOrder(Order order) throws SQLException {
    
        this.query = "INSERT INTO orderdetails (product,customer,price,quantity) "//, Price, Quantity) "
        		+ "VALUES('"+order.getProduct()+"','"+order.getCustomer()+"',"+order.getPrice()+","+
        		order.getQuantity()+")";
    
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