import java.sql.*;
import java.util.Scanner;

class _2table 
{
  public static void main(String[] args) 
  {
    final String url = "jdbc:MySQL://localhost:3306/school";
    final String user="root";
    final String password="12345";
     String sql = "INSERT INTO studentdata (sno, sname, courseid, age) VALUES (?, ?, ?, ?)";
     try (Connection conn =DriverManager.getConnection(url,user,password);
          PreparedStatement pstmt = conn.prepareStatement(sql)) {
          Scanner sc= new Scanner(System.in);
         System.out.println("enter the the roll no  ");
         int sno = sc.nextInt();
         pstmt.setInt(1, sno);
         System.out.println("enter the student name");
         sc.next();
         String sname= sc.nextLine();
         pstmt.setString(2, sname);
         System.out.println("enter the courseid");
         int courseid= sc.nextInt();
         pstmt.setInt(3, courseid);
         System.out.println("enter the age");
         int age= sc.nextInt();
         pstmt.setInt(4,age);
         pstmt.executeUpdate();
         System.out.println("Record created...");
         sc.close();
     } catch (SQLException e) 
     {
         System.out.println(e);
     }
}
}

