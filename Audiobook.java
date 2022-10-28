import java.util.List;
import java.util.UUID;

public class Audiobook extends MediaItem
{
    private List<String> chapterNames;
    private int seconds;

    public Audiobook(UUID id, String t, int y, String g, boolean ipi, List<String> cn, int s) {
        super(id, t, y, g, ipi);
        chapterNames = cn;
        seconds = s;
    }

    public int getNumberOfChapters()
    {
        return chapterNames.size();
    }

    public String getChapterNames()
    {
        int k = 0;
        String chapterList = "";
        while(k < chapterNames.size())
        {
            chapterList += k + ". " + chapterNames.get(k);
            k++;
        }
        return chapterList;
    }

    @Override
    public String getLength() {
        return seconds/60 + ":" + seconds%60;
    }
}
