import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBC {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    try {
     DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
    conn = DriverManager.getConnection(jdbc:oracle:thin:@192.168.12.2:1521/orcl,"R22BQ1A05E1","R22BQ1A05E1");
      Scanner sc = new Scanner(System.in);
      System.out.println("The choices are: " + "\t1.Add \t2.Delete\t3.Modify\t4.Retrieve");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          ps = conn.prepareStatement("insert into studies values(?,?);");
          System.out.println("Enter name and splace:");
          String no = sc.next();
          String str = sc.next();
          ps.setString(1, no);
          ps.setString(2, str);
          ps.executeUpdate();
          System.out.println("Inserted succesfully");
          break;
        case 2:
          ps = conn.prepareStatement("delete from studies where splace=?");
          System.out.println("Enter roll number:");
          String roll = sc.next();
          ps.setString(1, roll);
          ps.executeUpdate();
          System.out.println("Deleted succesfully");
          break;
        case 3:
          ps = conn.prepareStatement("update studies set pname=? where splace=?");
          System.out.println("Enter existing name and splace:");
          no = sc.next();
          str = sc.next();
          ps.setString(1, str);
          ps.setString(2, no);
          ps.executeUpdate();
          System.out.println("Updated succesfully");
          break;
        case 4:
          ps = conn.prepareStatement("select * from studies;");
          rs = ps.executeQuery();
          while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2));
          }
          break;
        default:
          System.out.println("Invalid choice");
          System.exit(0);
      }
      conn.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
}
}
