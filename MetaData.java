
import java.sql.*;

public class MetaData
{
  	  public static void main(String[] args) 
{
 	       try 
		{
           Class.forName("oracle.jdbc.driver.OracleDriver");
       con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","R22BQ1A05E1","R22BQ1A05E1");
            Statement stmt = con.createStatement();
     ResultSet rs = stmt.executeQuery("select * from student");
         ResultSetMetaData rsmd = rs.getMetaData();
	 System.out.print(rsmd.getColumnName(1)+" "+rsmd.getColumnName(2)+" "+rsmd.getColumnName(3));
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
}
             stmt.close();
            rs.close();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}	






/*System.out.println(rsmd.getColumnCount());
            System.out.println(rsmd.getColumnName(2));
            System.out.println(rsmd.getColumnTypeName(2));
            System.out.println(rsmd.isSearchable(2));
            System.out.println(rsmd.getColumnType(2));
	    System.out.print(rsmd.getColumnName(1)+" "+rsmd.getColumnName(2));*/
           