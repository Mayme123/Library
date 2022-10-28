import java.util.Scanner;
import java.util.List;

public class AddOrder
{

    private AddOrder() {}

    public static String addOrder(Scanner scnr, List<MediaItem> orders)
    {
        System.out.println("Would you like to add a...\n1. Album\n2. Movie\n3. Audiobook");
        int input = Integer.parseInt(scnr.nextLine());

        switch (input)
        {
            case 1:
                return MakeNewClass.makeAlbumOrderFromUserInput(scnr, orders);
            case 2:
                return MakeNewClass.makeMovieOrderFromUserInput(scnr, orders);
            case 3:
                return MakeNewClass.makeAudiobookOrderFromUserInput(scnr, orders);
            default:
                return "Error reading in input";
        }
    }
}
