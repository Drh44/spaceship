/**
 * 
 * @author Dylan Hesser
 * Class that creates an array of travelers to be put on spaceships
 */

public class AvailableTravelers extends Spaceship 
{
	/**
	 * travelers- array that holds travelers to be put on spaceship
	 * numOfTravelers - holds the amount of travelers on list.
	 */
	public Traveler[] travelers = new Traveler[1000];
	int numOfTravelers;
	/**
	 * default constructor
	 */
	public AvailableTravelers() 
	{
		travelers = new Traveler[20];
		numOfTravelers = 0;
	}
	
	/**
	 * constructor to take custom input
	 * @param capacity amount of people that can go into the list
	 */
	public AvailableTravelers(int capacity) 
	{
		travelers = new Traveler[capacity];
		numOfTravelers = 0;
	}
	/**
	 * adds a traveler to the available traveler array
	 * @param aTraveler traveler to be added
	 * @return true if successful, false otherwise
	 */
	public boolean addTraveler(Traveler aTraveler) 
	{
		boolean answer;
		//will return true if the array is not at capacity and the traveler is not already on
		if ( ( numOfTravelers != getCapacity()) && (findTravelerById(aTraveler.getID()) == null) )
		{
			
			travelers[numOfTravelers] =  aTraveler ;
			numOfTravelers++;
			answer = true;
		}
	else 
		{
			System.out.print("Unsuccessful\n");
			answer = false;
		}
		
		return answer;
	}
	

	/**
	 * will try to find a traveler on the list
	 * @param travelerID traveler id to be found
	 * @return the traveler if found, null otherwise
	 */
	public Traveler findTravelerById(int travelerID) 
	{
		int i ;
		//loop will go through the travelers in the array and try to match them with the one given
		for ( i = 0; i < numOfTravelers; i++) 
			{
				if (travelers[i].getID() == travelerID ) 
					{
						return travelers[i];
					}
			}
		 return null;
	}
	/**
	 * Formats the information given into a nice string to output
	 */
	public String toString() {
		int i;
		String str = null;
		for (i = 0; i < numOfTravelers; i++) {
			str = str + travelers[i].toString();
		}
		return str;
	}
}
