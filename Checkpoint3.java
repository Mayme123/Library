import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Checkpoint3 {

//    public static boolean isValidInput(String str) {
//        return str.length() == 1 && Character.isDigit(str.charAt(0))
//                && Integer.parseInt(str) > 0 && Integer.parseInt(str) < 10;
//    }

    /**
     * The database file name.
     *
     * Make sure the database file is in the root folder of the project if you
     * only provide the name and extension.
     *
     * Otherwise, you will need to provide an absolute path from your C: drive
     * or a relative path from the folder this class is in.
     *
     * @author Leon J. Madrid (madrid.1), Jeff Hachtel (hachtel.5)
     */
    private static String DATABASE = "library-test4.db";

    /**
     * Connects to the database if it exists, creates it if it does not, and
     * returns the connection object.
     *
     * @param databaseFileName
     *            the database file name
     * @return a connection object to the designated database
     *
     * @author Leon J. Madrid (madrid.1), Jeff Hachtel (hachtel.5)
     */
    public static Connection initializeDB(String databaseFileName) {
        /**
         * The "Connection String" or "Connection URL".
         *
         * "jdbc:sqlite:" is the "subprotocol". (If this were a SQL Server
         * database it would be "jdbc:sqlserver:".)
         */
        String url = "jdbc:sqlite:" + databaseFileName;
        Connection conn = null; // If you create this variable inside the Try block it will be out of scope
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                // Provides some positive assurance the connection and/or creation was successful.
                DatabaseMetaData meta = conn.getMetaData();
                System.out
                        .println("The driver name is " + meta.getDriverName());
                System.out.println(
                        "The connection to the database was successful.");
            } else {
                // Provides some feedback in case the connection failed but did not throw an exception.
                System.out.println("Null Connection");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out
                    .println("There was a problem connecting to the database.");
        }
        return conn;
    }

    public static void main(String args[]) throws SQLException {
        List<Artist> artistList = new ArrayList<>();
        List<Track> trackList = new ArrayList<>();
        List<MediaItem> orders = new ArrayList<>();

        Connection conn = initializeDB(DATABASE);
        System.out.println("This is a new run");

        Scanner scnr = new Scanner(System.in);
        System.out.println("Type a number to select an option.");
        System.out.println("1. Search \n2. Add new records \n3. Order items \n4. Edit records \n5. Useful Reports\n");
        String choice = scnr.nextLine();

            switch (choice) {
                case "1":
                	System.out.println("Search");
                    System.out.println("Type a letter to select an option.");
                	System.out.println("a. Search artist\nb. Search Tracks\n");
                	choice= scnr.nextLine();
                	if (choice.equals("a")) {
                        System.out.println("Searching artists.");
                        GetInformation.getArtistInformation(scnr, artistList, conn);
                	}
                	else if (choice.equals("b")) {
                		System.out.println("Searching tracks.");
                	}
                    break;
                    
                case "2":
                	System.out.println("Add new records");
                	System.out.println("Type a letter to select an option.");
                	System.out.println("a. Add an artist\nb. Add an audiobook\n");
                	choice= scnr.nextLine();
                	if (choice.equals("a")) {
                        System.out.println("Adding an artist.");
                        boolean successful = MakeNewClass.makeArtistFromUserInput(scnr, conn);

                        if (successful) {
                            System.out.println("Successful!");
                        } else {
                            System.out.println("Unsuccessful");
                        }

                	}
                	else if (choice.equals("b")) {
                        System.out.println("Adding an audiobook.");

                	}
//                    trackList.add(MakeNewClass.makeTrackFromUserInput(scnr));
                    break;
                    
                case "3":
                	System.out.println("Order items");
                	System.out.println("Type a letter to select an option.");
                	System.out.println("a. Order a movie\nb. Activate item received\n");
                	choice= scnr.nextLine();
                	if (choice.equals("a")) {
                        System.out.println("Ordering a movie.");
                        OrderItems.orderMovie(scnr, conn);
                	}
                	else if (choice.equals("b")) {
                		System.out.println("Activating item received.");
                		OrderItems.activateMovie(scnr, conn);
                		
                	}
                    break;
                    
                case "4":
                	System.out.println("Edit an artist");
                	EditRecords.editRecords(scnr, artistList, conn);

                    break;
                    
                case "5":
                	System.out.println("Useful reports");
                	System.out.println("Type a letter to select an option.");
                	System.out.println("a: Tracks by ARTIST released before YEAR.");
                	System.out.println("b: Number of albums checked out by a single patron.");
                	System.out.println("c: Most popular actor in the database.");
                	System.out.println("d: Most listened to artist in the database.");
                	System.out.println("e: Patron who has checked out the most videos.");
                	choice= scnr.nextLine();
                	if (choice.equals("a")) {
                        System.out.println("Tracks by ARTIST released before YEAR.");
                        UsefulReports.artistTrack(scnr, conn);
                	}
                	else if (choice.equals("b")) {
                		System.out.println("Number of albums checked out by a single patron.");
                		UsefulReports.numAlbums(scnr, conn);
                	}
                	else if(choice.equals("c")) {
                		System.out.println("Most popular actor in the database.");
                		UsefulReports.popActor(scnr, conn);

                	}
                	else if(choice.equals("d")) {
                		System.out.println("Most listened to artist in the database.");
                		UsefulReports.topArtist(scnr, conn);
                	}
                	else if(choice.equals("e")) {
                		System.out.println("Patron who has checked out the most videos.");
                		GetInformation.getPatronMostVideos(scnr, conn);
                	}
                    break;

                default:
                    System.out.println("Selected an incorrect input");

            }


              
        scnr.close();
        conn.close();
    }
}
