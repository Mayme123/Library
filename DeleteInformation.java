import java.util.Scanner;
import java.util.List;

public class DeleteInformation
{
    private DeleteInformation() {}

    public static Track deleteTrack(Scanner scnr, List<Track> list)
    {
        Track track = GetInformation.getTrackInformation(scnr, list);

        System.out.print("Are you sure you want to delete track " + track.getTrackID() + "?\n1. Yes\n2. No");
        int input = Integer.parseInt(scnr.nextLine());

        if(input == 1)
        {
            list.remove(track);
            return track;
        }

        System.out.println("\nSuccessfully cancelled!");
        return null;
    }
}