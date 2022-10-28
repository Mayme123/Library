import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Artist extends Person {

    private int artistID;
    private int genreID;

    public Artist(String fName, String lName, String dob, String social,
            int artID, int genID) {
        super(fName, lName, dob, social);
        this.artistID = artID;
        this.genreID = genID;
    }

    public int getArtistID() {
        return this.artistID;
    }

    public int getGenreID() {
        return this.genreID;
    }

    public int setGenreID(int newID) {
        int oldID = this.genreID;
        this.genreID = newID;
        return oldID;
    }

    @Override
    public String toString() {
        return "NAME: " + super.getLastName() + ", " + super.getLastName()
                + "\nDOB: " + super.getDOB() + "\nSSN: " + super.getSSN()
                + "\nARTISTID: " + this.artistID + "\nGENREID: " + this.genreID
                + "\n\n";
    }

    public static void changeInformation(Scanner scnr, List<Artist> list,
            Connection conn) {
        Artist art = GetInformation.getArtistInformation(scnr, list, conn);

        System.out.print(
                "What do you want to change about this artist?\n\n1. First name\n2. Last name\n3. Date of birth\n4. SSN\n5. GenreID");

        int input = Integer.parseInt(scnr.nextLine());

        switch (input) {
            case 1:
                System.out.print("Enter the new first name: ");
                art.setFirstName(scnr.nextLine());
                break;
            case 2:
                System.out.print("Enter the new last name: ");
                art.setLastName(scnr.nextLine());
                break;
            case 3:
                System.out.print("Enter the new date of birth: ");
                art.setDOB(scnr.nextLine());
                break;
            case 4:
                System.out.print("Enter the new SSN: ");
                art.setSSN(scnr.nextLine());
                break;
            case 5:
                System.out.print("Enter the new genreID: ");
                art.setGenreID(Integer.parseInt(scnr.nextLine()));
                break;
            default:
                System.out.print("Error in reading in choice");

                System.out.println("\n");
        }
    }
}
