import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
class Exofdb 
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
          String query = "select * from student";
          Resultset resultSet = (Resultset) statement.executeQuery(query);
          while (((ResultSet) resultSet).next()) 
          {
           int id = ((ResultSet) resultSet).getInt("sno");
           String name = ((ResultSet) resultSet).getString("name");
           String Address = ((ResultSet) resultSet).getString("address");
           int Fees = ((ResultSet) resultSet).getInt("fees");
           String Course = ((ResultSet) resultSet).getString("course");
           int Course_id = ((ResultSet) resultSet).getInt("course_id");
           String Section = ((ResultSet) resultSet).getString("section");
            System.out.println("Id: "+id); 
            System.out.println("NAME: "+name);
            System.out.println("Address: "+Address);
            System.out.println("Fees: "+Fees);
            System.out.println("Course: "+Course);
            System.out.println("Course_id: "+Course_id);
            System.out.println("Section: "+Section);    
           
          }
        } 
        catch(SQLException e)
        {
          System.out.println(e.getMessage());
        }
     } 
}