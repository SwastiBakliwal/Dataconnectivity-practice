import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Formatter;

class DisplayTable 
{
    public static void main(String[] args) 
    {
        String url = "jdbc:mysql://localhost:3306/students";
        String user = "root";
        String password = "12345";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM eg")) 
             {

            Formatter fmt = new Formatter();
            fmt.format("%-15s %-15s %-15s\n", "id", "name", "age");

            while (rs.next()) 
            {
                fmt.format("%-15d %-15s %-15d\n", rs.getInt(1), rs.getString(2), rs.getInt(3));
            }

            System.out.println(fmt);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
