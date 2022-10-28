import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
 
public class EditRecords
{
 
   private EditRecords() {}
 
   public static void editRecords(Scanner scnr, List<Artist> list,
           Connection conn) {
       System.out.println("Enter an artist ID:");
       int id = Integer.parseInt(scnr.nextLine());
       System.out.print(
               "What do you want to change about this artist?\n\n1. ArtistID\n2. First name\n3. Last Name\n4. Date of birth\n5. Email\n6. Genre\n");
       int input = Integer.parseInt(scnr.nextLine());
       String change;
       String update;
      
       switch (input) {
           case 1:
               System.out.print("Enter the new artist ID: ");
               change = scnr.nextLine();
               update = "UPDATE person\nSET personID = ?\nWHERE personID = ?;";
               try {
                   PreparedStatement stmnt = conn.prepareStatement(update);
                   stmnt.setString(1, change);
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
               } catch (SQLException e) {
                   System.out.println(e.getMessage());
               }
               update = "UPDATE artist\nSET artistID = ?\nWHERE artistID = ?;";
               try {
                   PreparedStatement stmnt = conn.prepareStatement(update);
                   stmnt.setString(1, change);
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
               } catch (SQLException e) {
                   System.out.println(e.getMessage());
               }
               break;
           case 2:
               System.out.print("Enter the new first name: ");
               change = scnr.nextLine();
               update = "UPDATE person\nSET Fname = ?\nWHERE personID = ?;";
               try {
                   PreparedStatement stmnt = conn.prepareStatement(update);
                   stmnt.setString(1, change);
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
               } catch (SQLException e) {
                   System.out.println(e.getMessage());
               }
               break;
           case 3:
               System.out.print("Enter the new last name: ");
               change = scnr.nextLine();
               update = "UPDATE person\nSET Lname = ?\nWHERE personID = ?;";
               try {
                   PreparedStatement stmnt = conn.prepareStatement(update);
                   stmnt.setString(1, change);
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
               } catch (SQLException e) {
                   System.out.println(e.getMessage());
               }
               break;
           case 4:
               System.out.print("Enter the new date of birth: ");
               change = scnr.nextLine();
               update = "UPDATE person\nSET dob = ?\nWHERE personID = ?;";
               try {
                   PreparedStatement stmnt = conn.prepareStatement(update);
                   stmnt.setString(1, change);
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
               } catch (SQLException e) {
                   System.out.println(e.getMessage());
               }
               break;
           case 5:
               System.out.print("Enter the new email: ");
               change = scnr.nextLine();
               update = "UPDATE person\nSET email = ?\nWHERE personID = ?;";
               try {
                   PreparedStatement stmnt = conn.prepareStatement(update);
                   stmnt.setString(1, change);
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
               } catch (SQLException e) {
                   System.out.println(e.getMessage());
               }
               break;
           case 6:
               System.out.print("Enter the new genre: ");
               change = scnr.nextLine();
               update = "UPDATE artist\nSET genre = ?\nWHERE artistID = ?;";
               try {
                   PreparedStatement stmnt = conn.prepareStatement(update);
                   stmnt.setString(1, change);
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
               } catch (SQLException e) {
                   System.out.println(e.getMessage());
               }
               break;
           default:
               System.out.print("Error in reading in choice");
 
               System.out.println("\n");
       }
   }
}

