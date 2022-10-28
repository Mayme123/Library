class Track
{
	private int trackID;
	private String name;
	private int number;
	private int length;

	public Track(int id, String n, int num, int l)
	{
		trackID = id;
		name = n;
		number = num;
		length = l;
	}

	public int getTrackID()
	{
		return trackID;
	}

	public String getTrackName()
	{
		return name;
	}

	public int getTrackNumber()
	{
		return number;
	}

	public String getLength()
	{
		return length/60 + ":" + length%60;
	}

	@Override
	public String toString()
	{
		return "TRACK NAME: " + getTrackName() + "\nTRACKID: " + getTrackID() + "\nPOSITION ON ALBUM: " + getTrackNumber() + "\nLENGTH: " + getLength();
	}
}