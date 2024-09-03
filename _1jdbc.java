//Java program to set up connection and get all data from table
import java.sql.*;

public class _1jdbc 
{
	public static void main(String arg[])
	{
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/school",
				"root", "12345");
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet;
			resultSet = statement.executeQuery(
				"select * from studentdata");
			int sno, courseid ,age;
			String sname;
			while (resultSet.next()) {
				sno = resultSet.getInt("sno");
                courseid = resultSet.getInt("courseid");
                age = resultSet.getInt("age");
				sname = resultSet.getString("sname").trim();

		System.out.println("sno " + sno + " age "+age +" courseid "+courseid+  " sname " + sname);
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch (Exception exception) {
			System.out.println(exception);
		}
	}
} 
