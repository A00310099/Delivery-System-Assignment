package our_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    final private String host = "jdbc:mysql://localhost:3306/Newsagent";
    final private String user = "root";
    final private String password = "root";

    public Database() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(host, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // ==================== CUSTOMER METHODS ====================
    public boolean insertCustomerDetailsAccount(Customer c) {
        boolean insertSucessful = true;
        try {
            preparedStatement = connect.prepareStatement("INSERT INTO customers (customer_id, name, address, phone_number, status) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, c.getCustomerID());
            preparedStatement.setString(2, c.getName());
            preparedStatement.setString(3, c.getAddress());
            preparedStatement.setString(4, c.getPhoneNumber());
            preparedStatement.setString(5, c.getStatus());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            insertSucessful = false;
        }
        return insertSucessful;
    }
    public ResultSet retrieveCustomerAccount(String id) {
        try {
            if (id.equals("all")) {
            	statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // These parameters allow use of rs.first() and rs.beforeFirst() 
            	resultSet = statement.executeQuery("SELECT * FROM customers");
            } else {
            	preparedStatement = connect.prepareStatement("SELECT * FROM customers WHERE customer_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // Same as above
            	preparedStatement.setString(1, id);
            	resultSet = preparedStatement.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultSet = null;
        }
        return resultSet;
    }
    public boolean updateCustomerRecord(Customer c) {
    	boolean updateSuccessful = true;
    	try {
    		preparedStatement = connect.prepareStatement("UPDATE customers SET name = ?, address = ?, phone_number = ?, status = ? WHERE customer_id = ?");
            preparedStatement.setString(1, c.getName());
            preparedStatement.setString(2, c.getAddress());
            preparedStatement.setString(3, c.getPhoneNumber());
            preparedStatement.setString(4, c.getStatus());
    		preparedStatement.setString(5, c.getCustomerID());
    		preparedStatement.executeUpdate();
    	} catch (Exception e) {
    		e.printStackTrace();
    		updateSuccessful = false;
    	}
    	
    	return updateSuccessful;
    }
    
    public boolean deleteCustomerById(String id) {
        boolean deleteSucessful = true;
        try {
            preparedStatement = connect.prepareStatement("DELETE FROM customers WHERE customer_id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            deleteSucessful = false;
        }
        return deleteSucessful;
    }

    // ==================== PUBLICATION METHODS ====================
    
    // ==================== ORDER METHODS ====================
    public boolean insertOrderDetailsAccount(Order o) {
        boolean insertSucessful = true;
        try {
            preparedStatement = connect.prepareStatement("INSERT INTO orders (order_id, delivery_area, customer_id, publication_id, week_day) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, o.getOrderID());
            preparedStatement.setString(2, o.getDeliveryArea());
            preparedStatement.setString(3, o.getCustomerID());
            preparedStatement.setString(4, o.getPublicationID());
    		preparedStatement.setString(5, o.getWeekDay());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            insertSucessful = false;
        }
        return insertSucessful;
    }
    public ResultSet retrieveOrderAccount(String id) {
        try {
            if (id.equals("all")) {
            	statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // These parameters allow use of rs.first() and rs.beforeFirst() 
            	resultSet = statement.executeQuery("SELECT * FROM orders");
            } else {
            	preparedStatement = connect.prepareStatement("SELECT * FROM orders WHERE order_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // Same as above
            	preparedStatement.setString(1, id);
            	resultSet = preparedStatement.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultSet = null;
        }
        return resultSet;
    }
    public boolean updateOrderRecord(Order o) {
    	boolean updateSuccessful = true;
    	try {
    		preparedStatement = connect.prepareStatement("UPDATE orders SET delivery_area = ?, customer_id = ?, publication_id = ?, week_day = ? WHERE order_id = ?");
            preparedStatement.setString(1, o.getDeliveryArea());
            preparedStatement.setString(2, o.getCustomerID());
            preparedStatement.setString(3, o.getPublicationID());
    		preparedStatement.setString(4, o.getWeekDay());
    		preparedStatement.setString(5, o.getOrderID());
    		preparedStatement.executeUpdate();
    	} catch (Exception e) {
    		e.printStackTrace();
    		updateSuccessful = false;
    	}
    	
    	return updateSuccessful;
    }
    
    public boolean deleteOrderById(String id) {
        boolean deleteSucessful = true;
        try {
            preparedStatement = connect.prepareStatement("DELETE FROM orders WHERE order_id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            deleteSucessful = false;
        }
        return deleteSucessful;
    }
    // ==================== INVOICE METHODS ====================
    
    // ==================== DELIVERY DOCKET METHODS ====================
    
    // ==================== DELIVERY AREA METHODS ====================
    
    // ==================== DELIVERY PERSON METHODS ====================
    
    
    
    // ?
	public void close() {
		
	}
}
