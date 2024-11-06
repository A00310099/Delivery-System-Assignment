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
            statement = connect.createStatement();
            if (id.equals("all")) {
            	resultSet = statement.executeQuery("SELECT * FROM customers");
            } else {
            	resultSet = statement.executeQuery("SELECT * FROM customers WHERE customer_id = " + id);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            resultSet = null;
        }
        return resultSet;
    }

    public boolean deleteCustomerById(int custID) {
        boolean deleteSucessfull = true;
        try {
            if (custID == -99) {
                preparedStatement = connect.prepareStatement("DELETE FROM customers");
            } else {
                preparedStatement = connect.prepareStatement("DELETE FROM customers WHERE customer_id = ?");
                preparedStatement.setInt(1, custID);
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            deleteSucessfull = false;
        }
        return deleteSucessfull;
    }

	public void close() {
		
	}
}
