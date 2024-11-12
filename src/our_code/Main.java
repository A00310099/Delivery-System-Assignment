package our_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    
    private static final String URL = "jdbc:mysql://localhost:3306/Newsagent";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Create Customer");
                System.out.println("2. Create Publication");
                System.out.println("3. Create Delivery Area");
                System.out.println("4. Create Order");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        createCustomer(scanner, connection);
                        break;
                    case 2:
                        createPublication(scanner, connection);
                        break;
                    case 3:
                        createDeliveryArea(scanner, connection);
                        break;
                    case 4:
                        createOrder(scanner, connection);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return; 
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createCustomer(Scanner scanner, Connection connection) throws SQLException {
        System.out.println("Enter a new customer:");
        Customer customer = new Customer();
        System.out.print("Customer ID: ");
        customer.setCustomerId(scanner.nextLine());
        System.out.print("Name: ");
        customer.setName(scanner.nextLine());
        System.out.print("Address: ");
        customer.setAddress(scanner.nextLine());
        System.out.print("Phone Number: ");
        customer.setPhoneNumber(scanner.nextLine());
        System.out.print("Status: ");
        customer.setStatus(scanner.nextLine());
        insertCustomer(connection, customer);
    }

    private static void createPublication(Scanner scanner, Connection connection) throws SQLException {
        System.out.println("Enter a new publication:");
        Publication publication = new Publication();
        System.out.print("Publication ID: ");
        publication.setPublicationID(scanner.nextLine());
        System.out.print("Name: ");
        publication.setPublicationName(scanner.nextLine());
        System.out.print("Type: ");
        publication.setPublicationType(scanner.nextLine());
        System.out.print("Frequency: ");
        publication.setPublicationFreq(scanner.nextLine());
        System.out.print("Stock: ");
        publication.setPublicationStock(scanner.nextInt());
        System.out.print("Cost: ");
        publication.setPublicationCost(scanner.nextDouble());
        insertPublication(connection, publication);
        scanner.nextLine(); 
    }

    private static void createDeliveryArea(Scanner scanner, Connection connection) throws SQLException {
        System.out.println("Enter a new delivery area:");
        DeliveryArea deliveryArea = new DeliveryArea();
        System.out.print("Delivery Area ID: ");
        deliveryArea.setAreaID(scanner.nextLine());
        System.out.print("Delivery Person ID: ");
        deliveryArea.setDeliveryPersonID(scanner.nextLine());
        System.out.print("Area Number: ");
        deliveryArea.setAreaNumber(scanner.nextLine());
        System.out.print("Customer ID: ");
        deliveryArea.setCustomerID(scanner.nextLine());
        insertDeliveryArea(connection, deliveryArea);
    }

    private static void createOrder(Scanner scanner, Connection connection) throws SQLException {
        System.out.println("Enter a new order:");
        Order order = new Order();
        System.out.print("Order ID: ");
        order.setOrderID(scanner.nextLine());
        System.out.print("Delivery Area: ");
        order.setDeliveryArea(scanner.nextLine());
        System.out.print("Customer ID: ");
        order.setCustomerID(scanner.nextLine());
        System.out.print("Publication ID: ");
        order.setPublicationID(scanner.nextLine());
        System.out.print("Week Day: ");
        order.setWeekDay(scanner.nextLine());
        insertOrder(connection, order);
    }

    private static void insertCustomer(Connection connection, Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (customer_id, name, address, phone_number, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getCustomerID());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getPhoneNumber());
            statement.setString(5, customer.getStatus());
            statement.executeUpdate();
        }
    }

    private static void insertPublication(Connection connection, Publication publication) throws SQLException {
        String sql = "INSERT INTO publications (publication_id, name, type, frequency, stock, cost) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, publication.getPublicationID());
            statement.setString(2, publication.getPublicationName());
            statement.setString(3, publication.getPublicationType());
            statement.setString(4, publication.getPublicationFreq());
            statement.setInt(5, publication.getPublicationStock());
            statement.setDouble(6, publication.getPublicationCost());
            statement.executeUpdate();
        }
    }

    private static void insertDeliveryArea(Connection connection, DeliveryArea deliveryArea) throws SQLException {
        String sql = "INSERT INTO delivery_areas (delivery_area_id, delivey_person_id, delivery_area_number, customer_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, deliveryArea.getAreaID());
            statement.setString(2, deliveryArea.getDeliveryPersonID());
            statement.setString(3, deliveryArea.getAreaNumber()); 
            statement.setString(4, deliveryArea.getCustomerID());
            statement.executeUpdate();
        }
    }

    private static void insertOrder(Connection connection, Order order) throws SQLException {
        String sql = "INSERT INTO orders (order_id, delivery_area, customer_id, publication_id, week_day) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, order.getOrderID());
            statement.setString(2, order.getDeliveryArea());
            statement.setString(3, order.getCustomerID());
            statement.setString(4, order.getPublicationID());
            statement.setString(5, order.getWeekDay());
            statement.executeUpdate();
        }
    }
}
