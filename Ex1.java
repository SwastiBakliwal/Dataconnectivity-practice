import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
class Ex1
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
          String query = "select * from eg";
          Resultset resultSet = (Resultset) statement.executeQuery(query);
          while (((ResultSet) resultSet).next()) 
          {
           int id = ((ResultSet) resultSet).getInt("id");
           String name = ((ResultSet) resultSet).getString("name");
           int age = ((ResultSet) resultSet).getInt("age");
            System.out.println("Id: "+id  +"  Name: "+name  +"  Age: "+age +"\n"); 
          }
        } 
        catch(SQLException e)
        {
          System.out.println(e.getMessage());
        }
     } 
}