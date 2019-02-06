import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 
 * @author Dylan Hesser
 * Program that keeps track of the information of the spaceship and methods to take actions on it
 *
 */

public class Spaceship 
{
	/**
	 * name- name of the spaceship
	 * capacity- max amount of people that can be on the spaceship
	 * numOfTravelers- number of people actually on the spaceship
	 * current- current location of the spaceship
	 * destination- destination location of the spaceship
	 * traveler- array of travelers to hold passengers and crew
	 * date- to maintain the date of the flight
	 * flightHours- amount of hours the ship has flown
	 */
	private	String name;
	private int capacity = 1000;
	private int numOfTravelers = 0;
	private Location current;
	private Location destination;
	//next variable is the array to hold travelers
	private Traveler[] traveler = new Traveler[capacity];
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateOfFlight;
	private int flightHours;
/**
 * default constructor
 * 
 */
	public Spaceship()
	{
	//change after available traveler class is made
		Traveler[] traveler = new Traveler[10];
		name = "Jim";
		capacity = 1000;
		numOfTravelers = 0;
		current = Location.EARTH;
		destination = Location.MARS;
		try {
			dateOfFlight = simpleDateFormat.parse("2100-05-11");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/**
 * constructor that takes user input
 * @param aName name to be set
 * @param aCurrent location to be set
 * @param aDestination future location to be set
 * @param aCapacity capacity of ship to be set
 */
	public Spaceship(String aName, Location aCurrent, String dateString, Location aDestination, int aCapacity, int flightHours ) 
	{
		this.name = aName;
		this.capacity = aCapacity;
		this.current = aCurrent;
		this.destination = aDestination;
		this.flightHours = this.flightHours + flightHours;
		Traveler[] traveler = new Traveler[10];	
	}
/**
 * gets the name of the ship
 * @return name of ship
 */
	public String getName()
	{
		return name;
	}
/**
 * gets the capacity of the ship
 * @return capacity of ship
 */
	public int getCapacity()
	{
		return capacity;
	}
/**
 * gets the current location of the ship
 * @return location of the ship
 */
	public Location getCurrent()
	{
		return current;
	}
/**
 * gets the destination of the ship
 * @return destination of the ship
 */
	public Location getDestination()
	{
		return destination;
	}
	/**
	 * gets the date
	 * @return the date of the flight
	 */
	public Date getDate()
	{
		return dateOfFlight;
	}
	/**
	 * gets the number of travelers
	 * @return number of travelers
	 */
	public int getNumOfTravelers() 
	{
		return numOfTravelers;
	}
/**
 * gets the flight hours
 * @return flight hours
 */
	public int getFlightHours() {
		return flightHours;
	}
/**
 * sets the name of the ship
 * @param aName name of the ship to be used
	*/
	public void setName(String aName) 
	{
		this.name = aName;
	}
/**
 * sets the current location of the ship
 * @param aCurrent location to be used
 */
	public void setCurrent (Location aCurrent) 
	{
		this.current = aCurrent;
	}
	/**
	 * sets the date of the flight
	 * @param dateString date to be used
	 */
	public void setDate (String dateString) 
	{
		try {
			this.dateOfFlight = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * sets the flight hours
	 * @param flightHours flight hours to be used
	 */
	public void setFlightHours (int flightHours)
	{
		this.flightHours = flightHours;
	}
/**
 * sets the destination of the ship
 * @param aDestination destination to be used
 */
	public void setDestination (Location aDestination) 
	{
		this.destination = aDestination;
	}
/**
 * sets the capacity of the ship
 * @param aCapacity capacity to be used
 */
	public void setCapacity(int aCapacity) 
	{
		this.capacity = aCapacity;
	}
/**
 * checks to see if a traveler is on board of a ship
 * @param aTraveler traveler to be searched for
 * @return true if traveler is found, false otherwise
 */
	public boolean isOnBoard ( Traveler aTraveler) 
	{
		int i = 0;
		boolean answer = false;
		//loop will go through the travelers on board and try to match them with the one given
		for ( i = 0; i < numOfTravelers; i++) 
			{
				if (aTraveler.getName() == (traveler[i].getName()) ) 
					{
						answer = true;
					}
			}
		return answer; 
	}

/**
 * adds a given traveler to the preferred spaceship
 * @param aTraveler traveler to be added
 * @return true if the traveler was added, false otherwise
 */
	public boolean board(Traveler aTraveler)
	{
	    /*the if statement will check if the number of travelers on board is already at capacity, 
	      then will do a check to see if any of those travelers aboard is the given traveler by using the isOnBoard method*/
		if ( (numOfTravelers != capacity) && ( isOnBoard(aTraveler) == false)) 
			{
				 traveler[numOfTravelers] = aTraveler;
				numOfTravelers++;
				System.out.print("Successful\n");
				return true;
			}
		else 
			{
				System.out.print("Unsuccessful\n");
				return false;
			}
	}
/**
 * checks for a traveler and then removes them from the ship
 * @param aTraveler traveler to be removed
 * @return true if successful, false other wise.
 */
	boolean leave(Traveler aTraveler) 
	{
		int i = 0;
		boolean answer = false;
		for (i = 0; i < numOfTravelers ; i ++) 
			{
			//will check if any traveler on board is the traveler given
				if ( traveler[i].getName() ==(aTraveler.getName()))
					{
						traveler[i] = traveler[i + 1];
						answer  = true;	
					}
			}
		return answer;
	}
/**
 * moves the spaceship to its destination and removes the travelers on board	
 * return true if travelers are correct
 */
	public boolean moveShip() 
	{
		int i;
		int j;
		//will check if the travelers on the ship consist of a passenger and a crew member and return true if so
		for ( i = 0; i < numOfTravelers; i ++ ) {
			if ( traveler[i] instanceof Passenger) {
				for (j = 0; j < numOfTravelers; j++ ) {
					if ( traveler[j] instanceof Crew) {
						//moves ship to destination and removes travelers
						current = destination;
						destination = null;
						numOfTravelers = 0;
						traveler = new Traveler[numOfTravelers];
						return true;
						}	
					}
				}
			}
		return false;
	}
/**
 * formats the information into a nice output for the user to read
 */
	public String toString()
	{
		String str = "";
		str = "Spaceship[name= " + getName() + " Current= " + getCurrent() + " Destination= " + getDestination() + " Capacity = " + getCapacity() + " Travelers= " + getNumOfTravelers() ;
		str = str + " flight hours= " + getFlightHours() + " Date= " + getDate() + "]";
		int i;
		for (i = 0; i < numOfTravelers; i++) 
		{
			str = str + (traveler[i].toString());
		}
		return str;
	}
}

