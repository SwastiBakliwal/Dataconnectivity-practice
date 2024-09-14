import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
class Ex3 
{
      private static final String url = "jdbc:mysql://localhost:3306/students";
         private static final String username ="root";
         private static final String password = "12345"; 
         public static void main(String[] args) 
         {
            try
            {
                 Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch(ClassNotFoundException e)
            {
               System.out.println(e.getMessage());
            }
            try
            {
              Connection connection = DriverManager.getConnection(url,username,password);
              Statement statement = connection.createStatement();
              String query = String.format("update eg set age =%d where id = %d", 16, 101 );              
              int rowsAffected = statement.executeUpdate(query);
              if(rowsAffected>0)
              {
               System.out.println("Data Updated Successfully");
              }
              else
              {
               System.out.println("Data is not Updated");
              }
            } 
            catch(SQLException e)
            {
              System.out.println(e.getMessage());
            }
         }     
    }
