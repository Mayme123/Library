import java.util.Scanner;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class MakeNewClass
{
    private MakeNewClass() {}
    
    public static String makeAlbumOrderFromUserInput(Scanner scnr, List<MediaItem> order)
    {
        int initialNumInOrder = order.size();
        System.out.print("How many albums to order: ");
        int numToOrder = Integer.parseInt(scnr.nextLine());
        int k = 0;

        System.out.print("What is the album's title: ");
        String title = scnr.nextLine();

        System.out.print("What is the album's year: ");
        int year = Integer.parseInt(scnr.nextLine());

        System.out.print("What is the album's genre: ");
        String genre = scnr.nextLine();

        System.out.print("Is it a physical album? Enter P for physcial and D for digital: ");
        boolean isPhysicalItem = scnr.nextLine() == "P";

        System.out.print("What is the album's release date: ");
        String releaseDate = scnr.nextLine();

        System.out.print("What is the album's length in seconds: ");
        int seconds = Integer.parseInt(scnr.nextLine());

        while(k < numToOrder)
        {
            order.add(new Album(UUID.randomUUID(), title, year, genre, isPhysicalItem, releaseDate, seconds));
            k++;
        }

        int numOrdered = order.size() - initialNumInOrder;
        return "At $0.75 per album and " + numOrdered + " movies ordered, it will cost $" + 0.75 * numOrdered + " and take" + numOrdered * 2 / 3 + "days";
    }

    public static String makeMovieOrderFromUserInput(Scanner scnr, List<MediaItem> order)
    {
        int initialNumInOrder = order.size();
        System.out.print("How many movies to order: ");
        int numToOrder = Integer.parseInt(scnr.nextLine());
        int k = 0;

        System.out.print("What is the movie's title: ");
        String title = scnr.nextLine();

        System.out.print("What is the movie's year: ");
        int year = Integer.parseInt(scnr.nextLine());

        System.out.print("What is the movie's genre: ");
        String genre = scnr.nextLine();

        System.out.print("Is it a physical album? Enter P for physcial and D for digital: ");
        boolean isPhysicalItem = scnr.nextLine() == "P";

        System.out.print("What is the movies's content rating: ");
        String contentRating = scnr.nextLine();

        System.out.print("What is the movies's length in minutes: ");
        int minutes = Integer.parseInt(scnr.nextLine());

        while(k < numToOrder)
        {
            order.add(new Movie(UUID.randomUUID(), title, year, genre, isPhysicalItem, contentRating, minutes));
            k++;
        }

        int numOrdered = order.size() - initialNumInOrder;
        return "At $1.50 per movie and " + numOrdered + " movies ordered, it will cost $" + 1.50 * numOrdered + " and take" + numOrdered/2 + "days";
    }

    public static String makeAudiobookOrderFromUserInput(Scanner scnr, List<MediaItem> order)
    {
        int initialNumInOrder = order.size();
        System.out.print("How many audiobooks to order: ");
        int numToOrder = Integer.parseInt(scnr.nextLine());
        int k = 0;

        System.out.print("What is the audiobook's title: ");
        String title = scnr.nextLine();

        System.out.print("What is the audiobook's year: ");
        int year = Integer.parseInt(scnr.nextLine());

        System.out.print("What is the audiobook's genre: ");
        String genre = scnr.nextLine();

        System.out.print("Is it a physical album? Enter P for physcial and D for digital: ");
        boolean isPhysicalItem = scnr.nextLine() == "P";

        String input = "random";
        int i = 1;
        List<String> chapterNames = new ArrayList<>();
        while(!input.equals(""))
        {
            System.out.print("What is chapter " + i + "'s name (enter a new tab to end)");
            chapterNames.add(scnr.nextLine());
            i++;
        }

        System.out.print("What is the audiobook's length in seconds: ");
        int seconds = Integer.parseInt(scnr.nextLine());
        
        while(k < numToOrder)
        {
            order.add(new Audiobook(UUID.randomUUID(), title, year, genre, isPhysicalItem, chapterNames, seconds));
            k++;
        }

        int numOrdered = order.size() - initialNumInOrder;
        return "At $0.30 per audiobook and " + numOrdered + " audiobooks ordered, it will cost $" + 0.30 * numOrdered + " and take" + numOrdered + 1 + "days";
    }

    public static Artist makeArtistFromUserInput(Scanner scnr)
    {
        System.out.print("What is the artists first name: ");
        String fName = scnr.nextLine();

        System.out.print("What is the artists last name: ");
        String lName = scnr.nextLine();

        System.out.print("What is the artists date of birth: ");
        String dob = scnr.nextLine();

        System.out.print("What is the artists social security number: ");
        String social = scnr.nextLine();

        System.out.print("What is the artists artistID: ");
        int artID = Integer.parseInt(scnr.nextLine());

        System.out.print("What is the artists genreID: ");
        int genID = Integer.parseInt(scnr.nextLine());

        return new Artist(fName, lName, dob, social, artID, genID);
    }

    public static Track makeTrackFromUserInput(Scanner scnr)
    {
        System.out.print("What is the trackID: ");
        int trackID = Integer.parseInt(scnr.nextLine());

        System.out.print("What is the track name: ");
        String name = scnr.nextLine();

        System.out.print("What is the track number on the album: ");
        int num = Integer.parseInt(scnr.nextLine());

        System.out.print("What is the length of the song in seconds: ");
        int length = Integer.parseInt(scnr.nextLine());

        return new Track(trackID, name, num, length);
    }
    
    public static boolean makeArtistFromUserInput(Scanner scnr,
            Connection conn) {
        System.out.print("\nTRYING3345\n");
        try {
            String personSQL = "INSERT INTO person (personID, dob, Fname, Lname, email) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement personPS = conn.prepareStatement(personSQL);

            String artistSQL = "INSERT INTO artist (artistID, genre) VALUES (?, ?);";
            PreparedStatement artistPS = conn.prepareStatement(artistSQL);

            System.out.print("What is the artists artistID: ");
            int artID = Integer.parseInt(scnr.nextLine());
            personPS.setInt(1, artID);
            artistPS.setInt(1, artID);

            System.out.print("What is the artists date of birth: ");
            String dobString = scnr.nextLine();
            Date dob = Date.valueOf(dobString);
            personPS.setDate(2, dob);

            System.out.print("What is the artists first name: ");
            String fName = scnr.nextLine();
            personPS.setString(3, fName);

            System.out.print("What is the artists last name: ");
            String lName = scnr.nextLine();
            personPS.setString(4, lName);

            System.out.print("What is the artists email: ");
            String email = scnr.nextLine();
            personPS.setString(5, email);

            System.out.print(
                    "What is the artists genre(e.g. 'Mystery|Thriller'): ");
            String genre = scnr.nextLine();
            artistPS.setString(2, genre);

            return personPS.execute() && artistPS.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}