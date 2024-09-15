import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//data insertion 
class Ex5 
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
          String query ="insert into eg(id, name, age) values(?, ?, ?)";
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.setInt(1,104);
          preparedStatement.setString(2,"Subrat");
          preparedStatement.setInt(3,14);
          int rowsAffected = preparedStatement.executeUpdate();
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
