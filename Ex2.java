import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//data insertion 
class Ex2 
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
          String query = String.format("insert into eg(id,name,age) values(%d,'%s',%d)",104,"subrat",14);
          
          int rowsAffected = statement.executeUpdate(query);
          if(rowsAffected>0)
          {
           System.out.println("Data Inserted Successfully");
          }
          else
          {
           System.out.println("Data not Inserted");
          }
        } 
        catch(SQLException e)
        {
          System.out.println(e.getMessage());
        }
     }     
}
