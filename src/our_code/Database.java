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
        boolean insertSucessfull = true;
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
            insertSucessfull = false;
        }
        return insertSucessfull;
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

    public boolean deleteCustomerById(String id) {
        boolean deleteSucessfull = true;
        try {
            preparedStatement = connect.prepareStatement("DELETE FROM customers WHERE customer_id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            deleteSucessfull = false;
        }
        return deleteSucessfull;
    }

    // ==================== PUBLICATION METHODS ====================
    
    // ==================== ORDER METHODS ====================
    
    // ==================== INVOICE METHODS ====================
    
    // ==================== DELIVERY DOCKET METHODS ====================
    
    // ==================== DELIVERY AREA METHODS ====================
    
    // ==================== DELIVERY PERSON METHODS ====================
    
    
    
    // ?
	public void close() {
		
	}
}
