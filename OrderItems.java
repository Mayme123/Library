import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class OrderItems {
    private OrderItems() {
    }

   
    public static void orderMovie(Scanner scnr, 
            Connection conn) {
    	
        System.out.print("What is the movie id?");
        int id = Integer.parseInt(scnr.nextLine());

        System.out.print("What is the movie title?");
        String title = scnr.nextLine();

        System.out.print("Type p for physical and d for digital movie ");
        String type = scnr.nextLine();

        System.out.print("What is today's date?");
        String orderdate = scnr.nextLine();

        System.out.print("What is the estimated arrival date?");
        String arrivaldate = scnr.nextLine();

        System.out.print("What is your email?");
        String email = scnr.nextLine();        
        
        String sql = "INSERT INTO media_item (\r\n"
        		+ "                           mediaID,\r\n"
        		+ "                           title,\r\n"
        		+ "                           media_type,\r\n"
        		+ "                           order_date,\r\n"
        		+ "                           arrival_est,\r\n"
        		+ "                           email)"
        		+ "                       VALUES (?,\r\n"
        		+ "                           ?,\r\n"
        		+ "                           ?,\r\n"
        		+ "                           ?,\r\n"
        		+ "                           ?,\r\n"
        		+ "                           ?\r\n"
        		+ "                       );\r\n";
        String sql2 ="INSERT INTO MOVIE(movieID)\r\n"
        		+ "VALUES(?);";
     

        try {
            PreparedStatement stmnt = conn.prepareStatement(sql);
            PreparedStatement stmnt2 = conn.prepareStatement(sql2);
            stmnt.setInt(1, id);
            stmnt.setString(2, title);
            stmnt.setString(3, type);
            stmnt.setString(4, orderdate);
            stmnt.setString(5, arrivaldate);
            stmnt.setString(6, email);
            stmnt2.setInt(1, id);
            
            ResultSet rs = stmnt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String value = rsmd.getColumnName(i);
                System.out.print(value + ": ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue);
                System.out.print("\n");
            }
            System.out.print("\n");
            stmnt.close();
            rs.close();
            
            ResultSet rs2 = stmnt2.executeQuery();
            ResultSetMetaData rsmd2 = rs.getMetaData();
            int columnCount2 = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount2; i++) {
                String value = rsmd2.getColumnName(i);
                System.out.print(value + ": ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue);
                System.out.print("\n");
            }
            System.out.print("\n");
            stmnt2.close();
            rs2.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

     

    }
    
    public static void activateMovie(Scanner scnr, 
            Connection conn) {
        System.out.print(
                "What movie was received (please provide movieID) ");
        int id = Integer.parseInt(scnr.nextLine());
        System.out.print(
                "What library is storing the movie ");
        String library = scnr.nextLine();
        System.out.print(
                "Where is the library located");
        String location = scnr.nextLine();
        String sql = "\r\n"
        		+ "INSERT INTO library(name, location) VALUES(?, ?);\r\n";
        String sql2 = "INSERT INTO stores(lib_name,mediaID) VALUES(?,?);";

        try {
            PreparedStatement stmnt = conn.prepareStatement(sql);
            stmnt.setString(1, library);
            stmnt.setString(2, location);
            PreparedStatement stmnt2 = conn.prepareStatement(sql2);
            stmnt.setString(1, library);
            stmnt.setInt(2, id);
            
            ResultSet rs = stmnt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String value = rsmd.getColumnName(i);
                System.out.print(value + ": ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue);
                System.out.print("\n");
            }
            System.out.print("\n");
            stmnt.close();
            rs.close();
            
            ResultSet rs2= stmnt2.executeQuery();
            ResultSetMetaData rsmd2 = rs2.getMetaData();
            int columnCount2 = rsmd2.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String value = rsmd2.getColumnName(i);
                System.out.print(value + ": ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue);
                System.out.print("\n");
            }
            System.out.print("\n");
            stmnt.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    
}
