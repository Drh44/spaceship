/**
 * 
 * @author Dylan Hesser
 * Abstract class that the passenger and crew class utilize to gather information on travelers
 *
 */
public abstract class Traveler 
{
	/**
	 * nextIDNum - will be used as a static int that gets incremented
	 * name - name of the traveler
	 * id- id of the traveler
	 * currentLocation- location the traveler is currently at
	 */
	protected static int nextIDNum = 0;
	protected String name;
	protected int id = 0;
	protected Location currentLocation;

/**
 * default constructor
 */
	public Traveler() 
	{
		name = null;
		id = 0;
		currentLocation = Location.EARTH;
	}
/**
 *  This is the constructor that takes user input 
 * @param aName The name of the traveler
 * @param aLocation the location they are at
 */
	public Traveler(String aName, Location aLocation)
	{
		this.name = aName;
		this.currentLocation = aLocation;
	//the id is used to identify the traveler
		this.id = nextIDNum++;
	}
/**
 * returns the name of the traveler
 * @return name of traveler
 */
	public String getName()
	{
		return name;
	}
/**
 * returns the location of the traveler
 * @return the location of traveler
 */
	public Location getLocation()
	{
		return currentLocation;
	}
/**
 * returns the ID of the traveler
 * @return id of traveler
 */
	public int getID()
	{
		return id;
	}
/**
 * sets name of traveler to user value
 * @param aName the name to be set
 */
	public void setName(String aName)
	{
		this.name = aName;
	}
/**
 * sets the location of the traveler to user value
 * @param aLocation the location to be set
 */
	public void setLocation(Location aLocation)
	{
		this.currentLocation = aLocation;
	}
/**
 * sets the id of the traveler to the next ID number available 
 */
	public void setID()
	{
		this.id = nextIDNum++;
	}
/**
 * returns a nicely formatted string with the information of the traveler based on if the traveler is a crew or passenger
 */
	public abstract String toString() ;
/**
 * moves the traveler based on spaceship location
 * @param spaceshipLocation the location of the spaceship
 */
	public  abstract void move(Location spaceshipLocation);
}

