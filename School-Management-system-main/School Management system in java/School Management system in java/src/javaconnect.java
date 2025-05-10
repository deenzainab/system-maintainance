import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class javaconnect {
    
    // Method to establish a connection to the MySQL database
    public static Connection connectDb() {
        Connection conn = null;
        try {
            // Load the MySQL JDBC driver (use com.mysql.cj.jdbc.Driver for MySQL 8.x)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection to the database
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_database?zeroDateTimeBehavior=convertToNull", 
                "root", 
                ""
            );
            
            // Optionally, set auto-commit to true (default is true)
            // conn.setAutoCommit(true);
            
            // Optionally, display a message upon successful connection
            // JOptionPane.showMessageDialog(null, "Database connected.");
        } catch (ClassNotFoundException | SQLException e) {
            // Handle any exceptions that occur during initialization
            JOptionPane.showMessageDialog(null, "Database Connection Problem: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
        }
        return conn; // Return the Connection object
    }
    
    // Example of usage
    public static void main(String[] args) {
        // Example usage:
        Connection conn = connectDb();
        if (conn != null) {
            System.out.println("Connected to database!");
            // Perform database operations here
        } else {
            System.out.println("Failed to connect to database.");
        }
    }
}
