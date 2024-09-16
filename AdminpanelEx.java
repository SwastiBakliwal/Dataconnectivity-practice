import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
class AdminpanelEx 
{

        private static final String URL = "jdbc:mysql://localhost:3306/students";
        private static final String USER = "root";
        private static final String PASSWORD = "12345";
    
        public static Connection getConnection() throws SQLException 
        {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }


        private static Connection connection;

        public static void main(String[] args) 
        {
            try 
            {
                connection = AdminpanelEx.getConnection();
                Scanner scanner = new Scanner(System.in);
                while (true) 
                {
                    System.out.println("Choose an operation: 1. Create 2. Read 3. Update 4. Delete 5. Exit");
                    int choice = scanner.nextInt();
                    switch (choice) 
                    {
                        case 1:
                            createeg(scanner);
                            break;
                        case 2:
                            readeg();
                            break;
                        case 3:
                            updateeg(scanner);
                            break;
                        case 4:
                            deleteeg(scanner);
                            break;
                        case 5:
                            System.out.println("Thankyou...");
                            connection.close();
                            scanner.close();
                            return;
                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    
        private static void createeg(Scanner scanner) throws SQLException 
        {
            System.out.println("Enter Student ID to insert:");
            int id = scanner.nextInt();
            System.out.println("Enter new name:");
            String name = scanner.next();
            System.out.println("Enter new Age:");
            int age = scanner.nextInt();
    
            String query = "INSERT INTO eg (id,name,age) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.executeUpdate();
            System.out.println("student created successfully.");
        }
    
        private static void readeg() throws SQLException 
        {
         try
          {
             String query = "SELECT * FROM eg";
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery();        
             Formatter fmt = new Formatter();
             fmt.format("%15s %15s %15s\n", "id", "name", "age");

             while (rs.next()) 
             {
               fmt.format("%15d %15s %15d\n", rs.getInt(1), rs.getString(2), rs.getInt(3));
             }

             System.out.println(fmt);
          } 
         catch (Exception e) 
            {
             e.printStackTrace();
            }
        }
    
        private static void updateeg(Scanner scanner) throws SQLException 
        {
            System.out.println("Enter Student ID to update:");
            int id = scanner.nextInt();
            System.out.println("Enter new name:");
            String name = scanner.next();
            System.out.println("Enter new Age:");
            int age = scanner.nextInt();
    
            String query = "UPDATE eg SET name = ?, age = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.executeUpdate();
            System.out.println("Student updated successfully.");
        }
    
        private static void deleteeg(Scanner scanner) throws SQLException 
        {
            System.out.println("Enter Student ID to delete:");
            int id = scanner.nextInt();
    
            String query = "DELETE FROM eg WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Studentname deleted successfully.");
        }
    }