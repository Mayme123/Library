import java.util.UUID;

abstract class MediaItem
{
	private UUID itemID;
	private String title;
	private int year;
	private String genre;
	private boolean checkedOut;
	private String dueDate;
	private boolean isPhysicalItem;

	public MediaItem(UUID id, String t, int y, String g, boolean ipi)
	{
		itemID = id;
		title = t;
		year = y;
		checkedOut = false; // assume not checked out upon creation
		genre = g;
		isPhysicalItem = ipi;
	}

	public UUID getItemID()
	{
		return itemID;
	}

	public String getTitle()
	{
		return title;
	}

	public int getYear()
	{
		return year;
	}

	public String getGenre()
	{
		return genre;
	}

	public String getDueDate()
	{
		if(!checkedOut)
		{
			return "Item " + itemID + " is not checked out!";
		}
		return dueDate;
	}

	public boolean isPhysicalItem()
	{
		return isPhysicalItem;
	}

	public int checkOutItem(String dd)
	{
		if(checkedOut) // return -1 if already checked out
		{
			return -1;
		}
		checkedOut = true;
		dueDate = dd;

		return 0;
	}

	abstract String getLength();
}