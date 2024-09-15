import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//data insertion 
class Ex6 
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
          String query ="select * from eg where id = ?";
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.setInt(1,106);
          ResultSet resultSet = preparedStatement.executeQuery();
          if(resultSet.next())
          {
            String Name = resultSet.getString("name");
            System.out.println("Name: "+Name);
          }
          else
          {
            System.out.println("Name not exist!");
          }
        } 
        catch(SQLException e)
        {
          System.out.println(e.getMessage());
        }
     }     
}
