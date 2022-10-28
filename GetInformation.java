import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class GetInformation {
    private GetInformation() {
    }

    public static void getOrderInformation(Scanner scnr,
            List<MediaItem> orders) {
        System.out.println(
                "What type of media item do you want to look for in orders:\n\n1. Album\n2. Movie\n3. Audiobook\n");
        int input = Integer.parseInt(scnr.nextLine());

        switch (input) {
            case 1:
                for (MediaItem item : orders) {
                    if (item instanceof Album) {
                        System.out.println(item);
                    }
                }
                break;
            case 2:
                for (MediaItem item : orders) {
                    if (item instanceof Movie) {
                        System.out.println(item);
                    }
                }
                break;
            case 3:
                for (MediaItem item : orders) {
                    if (item instanceof Audiobook) {
                        System.out.println(item);
                    }
                }
                break;
            default:
                System.out.print("Error in reading input");
        }
    }

    public static Artist getArtistInformation(Scanner scnr, List<Artist> list,
            Connection conn) {
        System.out.print(
                "What artist are you looking for (please provide artistID): ");
        int id = Integer.parseInt(scnr.nextLine());

        String sql = "SELECT *\r\n" + "FROM person, artist\r\n"
                + "where artistID = ? AND artistID = personID;";

        try {
            PreparedStatement stmnt = conn.prepareStatement(sql);
            stmnt.setInt(1, id);
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

        return null;

    }

    public static void getPatronMostVideos(Scanner scnr, Connection conn) {
        System.out.println(
                "Here is the patron with the most checked out videos: ");

        String sql = "SELECT    email, MAX(countPerPerson)\r\n"
                + "FROM        (SELECT email, COUNT(mediaID) as countPerPerson\r\n"
                + "         FROM       checks_out, movie\r\n"
                + "         WHERE  mediaID = movieID\r\n"
                + "        GROUP BY    email);";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
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
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Track getTrackInformation(Scanner scnr, List<Track> list) {
        System.out.print(
                "What track are you looking for (please provide trackID): ");
        int id = Integer.parseInt(scnr.nextLine());

        for (Track track : list) {
            if (track.getTrackID() == id) {
                return track;
            }
        }

        return null;
    }
}
