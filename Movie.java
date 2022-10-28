import java.util.UUID;

public class Movie extends MediaItem
{
    private String contentRating;
    private int minutes;

    public Movie(UUID id, String t, int y, String g, boolean ipi, String cr, int time) {
        super(id, t, y, g, ipi);
        contentRating = cr;
        minutes = time;
    }

    public String getContentRating()
    {
        return contentRating;
    }

    @Override
    public String getLength() {
        return minutes + " minutes";
    }
}
