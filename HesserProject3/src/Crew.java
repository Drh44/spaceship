/**
 * 
 * @author Dylan Hesser
 *Class that extends Traveler class to hold information for crew travelers
 */
public class Crew extends Traveler 
{
	/**
	 * position- position of the crew member
	 * pay - how much the crew member gets paid per flight
	 * flightHours - amount of flight hours the crew member has
	 */
	private String position;
	private double pay;
	private int flightHours;
	/**
	 * default constructor
	 */
	public Crew()
	{
		position = "crewman";
		pay = 3000;
		flightHours = 50;
		super.name = "NoName";
		super.currentLocation = Location.EARTH;
	}
	/**
	 * constructor that takes in custom information
	 * @param name name to be used
	 * @param aLocation location to be set
	 * @param position position to be used
	 * @param pay pay to be used
	 * @param flightHours flight hours to be used
	 */
	public Crew (String name, Location aLocation, String position, double pay, int flightHours)
	{
		this.name = name;
		this.currentLocation = aLocation;
		this.position = position;
		this.pay = pay;
		this.flightHours = flightHours;
		this.id = nextIDNum++;
	}
	/**
	 * sets the position
	 * @param position position to be used
	 */
	public void setPosition(String position)
	{
		this.position = position;
	}
	/**
	 * sets the pay
	 * @param pay to be used
	 */
	public void setPay (double pay)
	{
		this.pay = pay;
	}
	/**
	 * sets the flight hours
	 * @param flightHours flight hours to be used
	 */
	public void setFlightHours(int flightHours)
	{
		this.flightHours = this.flightHours + flightHours;
	}
	/**
	 * gets the position
	 * @return the position
	 */
	public String getPosition() 
	{
		return position;
	}
	/**
	 * gets the pay
	 * @return the pay
	 */
	public double getPay() 
	{
		return pay;
	}
	/**
	 * gets the flight hours
	 * @return the flight hours
	 */
	public int getFlightHours()
	{
		return flightHours;
	}
	/**
	 * formats the crew information into a string for output
	 */
	public String toString()
	{
		String str;
		str = "\nCrew[name= " + getName() + ", id= " + getID() + ", current= " + getLocation() ;
		str = str +  ", position= " + getPosition() + ", pay= " + getPay()+ ", flight hours = " + getFlightHours() + "]" ;
		return str;	
	}
	/**
	 * moves the crew member to the location of the spaceship they are on
	 */
	public void move(Location spaceshipLocation) 
	{
		currentLocation = spaceshipLocation;
	}
}
