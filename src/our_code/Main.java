package our_code;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        Database db = null;
        ResultSet rs = null;

        try {
            db = new Database(); // Establish the connection
            rs = db.retrieveAllCustomerAccounts(); // Retrieve customer accounts

            if (rs != null) {
                while (rs.next()) {
                    System.out.println("Customer ID: " + rs.getString("customer_id") +
                                       ", Name: " + rs.getString("name") +
                                       ", Address: " + rs.getString("address") +
                                       ", Phone Number: " + rs.getString("phone_number") +
                                       ", Status: " + rs.getString("status"));
                }
            } else {
                System.out.println("No customers found.");
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (db != null) db.close(); // close Database connection
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
