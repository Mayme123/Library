import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class UsefulReports {
    private UsefulReports() {
    }

   
    public static void artistTrack(Scanner scnr, 
            Connection conn) {

        
        String sql = "SELECT T.title\r\n"
        		+ "FROM Artist as AR, Track as T, Album as AL, media_item as MI, media_title as MT, performs as P\r\n"
        		+ "WHERE AR.artistID = P.artistID AND AR.artistID = P.artistID AND P.albumID = AL.id AND T.albumID = AL.id AND AL.id = MI.mediaID AND MI.title = MT.title AND P.Fname = 'ARTIST' AND MI.year < YEAR;\r\n"
        		+ "";
     

        try {
            PreparedStatement stmnt = conn.prepareStatement(sql);

            
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

    
    }
    
    public static void topArtist(Scanner scnr, 
            Connection conn) {
    	
//        System.out.print("What is the movie id?");
//        int id = Integer.parseInt(scnr.nextLine());

        
        String sql = "SELECT Fname, Lname, count(a.artistID), alb.running_time, (count(a.artistID)*alb.running_time) as tot_played\r\n"
        		+ "FROM person, artist as a, performs as p, album as alb, media_item as mi, checks_out as co\r\n"
        		+ "Where alb.id = mi.mediaID and mi.mediaID = co.mediaID and personID = a.artistID and a.artistID = p.artistID\r\n"
        		+ "and p.albumID = alb.id\r\n"
        		+ "Group By a.artistID\r\n"
        		+ "Order By (count(a.artistID)*alb.running_time) desc\r\n"
        		+ "Limit 1;\r\n"
        		+ "\r\n"
        		+ "";
        
     

        try {
            PreparedStatement stmnt = conn.prepareStatement(sql);

            
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

     

    }
    
    public static void numAlbums(Scanner scnr, 
            Connection conn) {
    	
//        System.out.print("What is the movie id?");
//        int id = Integer.parseInt(scnr.nextLine());

        
        String sql = "SELECT    person.Fname, person.Lname, person.personID, peopleCheckedOutNum.numberCheckedOut\r\n"
        		+ "FROM      (SELECT    checks_out.email, COUNT(checks_out.mediaID) as numberCheckedOut\r\n"
        		+ "           FROM      checks_out\r\n"
        		+ "           GROUP BY  checks_out.email) as peopleCheckedOutNum, person\r\n"
        		+ "WHERE     person.email = peopleCheckedOutNum.email;";
        
     

        try {
            PreparedStatement stmnt = conn.prepareStatement(sql);

            
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

     

    }
    
    public static void popActor(Scanner scnr, 
            Connection conn) {
    	
//        System.out.print("What is the movie id?");
//        int id = Integer.parseInt(scnr.nextLine());

        
        String sql = "SELECT    all_movie_actor_ftrd_count.actorID, MAX(totalActedIn) as maxTotalActedIn\r\n"
        		+ "FROM      (SELECT    all_movie_actor_ftrd.actorID, COUNT(actorID) as totalActedIn\r\n"
        		+ "           FROM      (SELECT    allCheckedOutMovies.mediaID, actor.actorID\r\n"
        		+ "                      FROM      (SELECT      media_item.mediaID, media_item.title\r\n"
        		+ "                                 FROM        checks_out, media_item, movie\r\n"
        		+ "                                 WHERE       checks_out.mediaID = media_item.mediaID AND checks_out.mediaID = movie.movieID) as allCheckedOutMovies\r\n"
        		+ "                      JOIN actor ON allCheckedOutMovies.title = actor.featured_role) as all_movie_actor_ftrd\r\n"
        		+ "           GROUP BY  all_movie_actor_ftrd.actorID) as all_movie_actor_ftrd_count;";
        
     

        try {
            PreparedStatement stmnt = conn.prepareStatement(sql);

            
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

     

    }
    

    
}
