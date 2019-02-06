/**
 * 
 * @author Dylan Hesser
 *class to gather the information of travelers classified as passengers
 */
public class Passenger extends Traveler 
{
	/**
	 * cost - cost of the seat
	 * firstClass - price of the first class seat
	 * businessClass - price of the business class seat
	 * coach- price of the coach class seat
	 * seat- which seat the passenger has
	 * rewardsPoints- amount of reward points the passenger has
	 */
	private double cost;
	private static double firstClass = 1499.00;
	private static double businessClass = 998.00;
	private static double coach = 449.00;
	private static double noSeat = 0;
	private static double REDUCTION_COST = .20;
	private SeatCategory seat;
	private int rewardsPoints;
/**
 * default constructor
 */
	public Passenger () 
	{
		super.name = null;
		super.currentLocation = null;
		cost = noSeat;
		rewardsPoints = 0;
		seat = null;
	}
/**
 * constructor with custom information
 * @param name name to be used
 * @param aLocation location to be used
 * @param cost cost to be used
 * @param seat seat to be used
 * @param rewardsPoints rewards points to be used
 */
	public Passenger ( String name, Location aLocation, double cost, SeatCategory seat, int rewardsPoints ) 
	{
			this.seat = seat;
			this.rewardsPoints = rewardsPoints;
			this.name = name;
			this.currentLocation = aLocation;
			cost = setCost();
			this.id = nextIDNum++;
	}
/** 
 * sets seat of the traveler
 * @param seat1 the seat to be used
 */
	public void setSeat(SeatCategory seat) 
	{
		this.seat = seat;
	}
/**
 * sets the cost of the seat based on which seat was chosen
 * @return the cost of the seat
 */
	public double setCost() 
	{
		if (this.seat == SeatCategory.NOSEAT) 
			{
				cost = noSeat;
			}
		else if(this.seat == SeatCategory.BUSINESS) 
			{
				cost = businessClass;
			}
		else if(this.seat == SeatCategory.COACH) 
			{
				cost = coach;
			}
		else if ( this.seat == SeatCategory.FIRST) 
			{
				cost = firstClass;
			}
		return cost;
	}
/**
 * sets the reward Points of the passenger		
 * @param rewardPoints reward points to be used
 */
	public void setRewardPoints(int rewardPoints) 
	{
		this.rewardsPoints = rewardPoints;
	}
/**
 * gets the reward points 		
 * @return reward points
 */
	public int getRewardPoints() 
	{
		return rewardsPoints;
	}
/**
 * gets the seat of the passenger		
 * @return seat category
 */
	public SeatCategory getSeat() 
	{
		return seat;
	}
/**
 * gets the cost of the seat
 * @return cost
 */
	public double getCost() 
	{
		return cost;
	}
/**
 * if reward points are greater than 10000, upgrade passenger to first class or gives them a discount
 */
	private void rewardUpgrade() 
	{
		if (rewardsPoints > 10000) 
			{
				// next part will check if they are in first class, if not they get bumped to it for free
				if (this.seat != SeatCategory.FIRST) 
					{
						this.seat = SeatCategory.FIRST;
						rewardsPoints = 0;
					}
				else 
						//if they are in first class, they get a discount instead
					{
						double discount = this.cost * REDUCTION_COST;
						this.cost =this.cost - discount;
						rewardsPoints = 0;
					}
			}
	}
/**
 * formats the information into a string
 */
	public String toString() 
	{
		String str;
		str = "\nPassenger[name= " + getName() + ", id= " + getID() + ", current= " + getLocation() ;
		str = str + ", seat= " + getSeat() + ", cost = $" + getCost() + ", rewardsPoints= " + getRewardPoints() + "]";
		return str;
	}
/**
 * moves the passenger based on spaceship location
 */
	public void move(Location spaceshipLocation) 
	{
		rewardUpgrade();
		currentLocation = spaceshipLocation;
		rewardsPoints = rewardsPoints + 1000;
	}
}
