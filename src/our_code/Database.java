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
    
    public boolean insertPublication(Publication p) {
        boolean insertSucessful = true;
        try {
            preparedStatement = connect.prepareStatement("INSERT INTO publications (publication_id, name, type, frequency, stock, cost) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, p.getPublicationID());
            preparedStatement.setString(2, p.getPublicationName());
            preparedStatement.setString(3, p.getPublicationType());
            preparedStatement.setString(4, p.getPublicationFreq());
            preparedStatement.setInt(5, p.getPublicationStock());
            preparedStatement.setDouble(6, p.getPublicationCost());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            insertSucessful = false;
        }
        return insertSucessful;
    }
    
    public ResultSet retrievePublication(String id) {
        try {
            if (id.equals("all")) {
            	statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // These parameters allow use of rs.first() and rs.beforeFirst() 
            	resultSet = statement.executeQuery("SELECT * FROM publications");
            } else {
            	preparedStatement = connect.prepareStatement("SELECT * FROM publications WHERE publication_id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // Same as above
            	preparedStatement.setString(1, id);
            	resultSet = preparedStatement.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultSet = null;
        }
        return resultSet;
    }
    
    public boolean updatePublication(Publication p) {
    	boolean updateSuccessful = true;
    	try {
    		preparedStatement = connect.prepareStatement("UPDATE publications SET name = ?, type = ?, frequency = ?, stock = ?, cost = ? WHERE publication_id = ?");
            preparedStatement.setString(1, p.getPublicationName());
            preparedStatement.setString(2, p.getPublicationType());
            preparedStatement.setString(3, p.getPublicationFreq());
            preparedStatement.setInt(4, p.getPublicationStock());
            preparedStatement.setDouble(5, p.getPublicationCost());
    		preparedStatement.setString(6, p.getPublicationID());
    		preparedStatement.executeUpdate();
    	} catch (Exception e) {
    		e.printStackTrace();
    		updateSuccessful = false;
    	}
    	
    	return updateSuccessful;
    	
    }
    
    public boolean deletePublicationById(String id) {
        boolean deleteSucessful = true;
        try {
            preparedStatement = connect.prepareStatement("DELETE FROM publications WHERE publication_id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            deleteSucessful = false;
        }
        return deleteSucessful;
    }
    
    
    // ==================== ORDER METHODS ====================
    
    // ==================== INVOICE METHODS ====================
    
    // ==================== DELIVERY DOCKET METHODS ====================
    
    // ==================== DELIVERY AREA METHODS ====================
    
    // ==================== DELIVERY PERSON METHODS ====================
    
    
    
    // ?
	public void close() {
		
	}
}
