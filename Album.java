import java.util.UUID;

public class Album extends MediaItem
{
    private String dateReleased;
    private int seconds;

    public Album(UUID id, String t, int y, String g, boolean ipi, String dr, int s) {
        super(id, t, y, g, ipi);
        dateReleased = dr;
        seconds = s;
    }

    public String getDateReleased()
    {
        return dateReleased;
    }

    @Override
    public String getLength() {
        return seconds/60 + ":" + seconds%60;
    }
}
