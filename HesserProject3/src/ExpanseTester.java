import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
/**
 * 
 * @author Dylan Hesser
 * tester for the spaceship program and traveler programs
 */
public class ExpanseTester 
{
	public static void main(String[] args) throws IOException 
	{
		String spaceShipName = null;
		Location SpaceshipCurrent = Location.EARTH;
		int SpaceshipCapacity = 0;
		String dateOfFlight = null;
		Location SpaceshipDestination = Location.BELT;
		int SpaceshipFlightHours = 0;
		BufferedReader inputStream = 
	               new BufferedReader(new FileReader(args[0]));
		Scanner keyboard = new Scanner(System.in);
		
		String pName = "";
		Location pLocation = null;
		SeatCategory pCat = null;
		double pCost = 0;
		int pRewardPoints = 0;
		Traveler newTraveler = null;
		
		String cName = "";
		Location cLocation = null;
		String cPosition = "";
		double cPay = 0;
		int cFHours = 0;
		
		AvailableTravelers travList = new AvailableTravelers();
		
		String line = inputStream.readLine();
		
		while(line != null) 
		{
		String[] lineArray= line.split(",");
		
			
		
		if(lineArray[0].equalsIgnoreCase("p"))
		{
			pName = lineArray[1];
			pLocation = Location.valueOf(lineArray[2]);
			pCat = SeatCategory.valueOf(lineArray[3]);
			pCost = Double.parseDouble(lineArray[4]);
			pRewardPoints = Integer.parseInt(lineArray[5]);
			newTraveler = new Passenger(pName,pLocation,pCost,pCat,pRewardPoints);
			
			travList.addTraveler(newTraveler);
		}
		else 
		{
			if(lineArray[0].equalsIgnoreCase("c")) 
			{
				cName = lineArray[1];
				cLocation = Location.valueOf(lineArray[2]);
				cPosition = lineArray[3];
				cPay = Double.parseDouble(lineArray[4]);
				cFHours = Integer.parseInt(lineArray[5]);
				newTraveler = new Crew(cName,cLocation,cPosition,cPay,cFHours);
			
				travList.addTraveler(newTraveler);
			}
		}
		
		line = inputStream.readLine();
		}
	
		System.out.println("Hello, this program will keep track of travelers on spaceships, the travelers are in a list for you to look at");
	    Spaceship spaceShip1 = new Spaceship ( spaceShipName, SpaceshipCurrent, dateOfFlight, SpaceshipDestination, SpaceshipCapacity,  SpaceshipFlightHours);
	    spaceShip1.setName("Buzzard");
	    spaceShip1.setCurrent(Location.EARTH);
	    spaceShip1.setDate("2111-05-31");
	    spaceShip1.setDestination(Location.BELT);
	    spaceShip1.setCapacity(35);
	    spaceShip1.setFlightHours(3500);
	    Spaceship spaceShip2 = new Spaceship (spaceShipName, SpaceshipCurrent,dateOfFlight, SpaceshipDestination,SpaceshipCapacity,SpaceshipFlightHours);
	    spaceShip2.setName("Raven");
	    spaceShip2.setCurrent(Location.MARS);
	    spaceShip2.setDate("2111-04-24");
	    spaceShip2.setDestination(Location.RING);
	    spaceShip2.setCapacity(15);
	    spaceShip2.setFlightHours(200);
	    //Will deliver the spaceship information to the user to look at
	    System.out.println("Here is the information for the two spaceships that can be used");
	    System.out.println("\n" + spaceShip1.toString());
	    System.out.println("\n" + spaceShip2.toString() + "\n");
		
		//Will take an int and pick a switch case based on that
		int menuItem;
		do 
		{
			System.out.println("Please select one of the following options");
			System.out.println ("1. Add traveler to a Spaceship \n2. Search for traveler on a Spaceship \n3. Move a spaceship to a new location \n4. Display a lit of available travelers \n5. Display a list of travelers on a specific spaceship \n6. Exit the program");
		    menuItem = keyboard.nextInt();
		
		switch(menuItem)
		{
		case 1: 
			System.out.println("Which traveler would you like to add to a spaceship, please use id number");
			int travelerID;
			travelerID = keyboard.nextInt();
			System.out.println("Which spaceship would you like to add the traveler to?");
			spaceShipName = keyboard.next();
			int i;
			//will check if the id entered as one of the travelers
			for (i=0; i < 10; i++) {
				if (travList.travelers[i].getID() == (travelerID)) {
					//if the spaceship name entered is the same as either spaceship name, then the action will happen
					 if (spaceShip1.getName().equalsIgnoreCase(spaceShipName)) {
						 spaceShip1.board(travList.travelers[i]);
						    System.out.println(spaceShip1.toString());
					 }
					 else if  (spaceShip2.getName().equalsIgnoreCase(spaceShipName)) {
						 spaceShip2.board(travList.travelers[i]);
						    System.out.println(spaceShip2.toString());
					 }   
				}  
			}
			
			break;
			
		case 2:
			System.out.println("Please insert the id number of the traveler you are looking for");
			travelerID = keyboard.nextInt();
			System.out.println("Which ship do you want to look in for the traveler?");
			spaceShipName = keyboard.next();
			 if (spaceShip1.getName().equalsIgnoreCase(spaceShipName))
			 {
				
					 System.out.println(spaceShip1.toString());
					 //if the id is one of the travelers in the list, will then check if that traveler is on board the specific ship
						for (i=0; i < 10; i++)
						{
							if (travList.travelers[i].getID() == (travelerID)) 
							{
								if(spaceShip1.isOnBoard(travList.travelers[i]) == true) 
								{
									System.out.println("Traveler is on board");
									System.out.println(travList.travelers[i].toString());
								}
								else 
								{
									System.out.println("Traveler is not on board");
								}	
							}
						}
				 
			 }
			 
			 else if (spaceShip2.getName().equalsIgnoreCase(spaceShipName)) 
			 {
				
					 
					 System.out.println(spaceShip2.toString());
					 
						for (i=0; i < 10; i++) 
						{
							if (travList.travelers[i].getID() == (travelerID)) 
							{
								if (spaceShip2.isOnBoard(travList.travelers[i]) == true) 
								{
									System.out.println("Traveler is on board");
									System.out.println(travList.travelers[i].toString());
								}
								else 
								{
									System.out.println("Traveler is not on board");
								}
							}
						}
			 }
			
			break;
		case 3:
			System.out.println("Which ship would you like to move?");
			spaceShipName = keyboard.next();
			
			if (spaceShip1.getName().equalsIgnoreCase(spaceShipName)) 
			{
				
				for (i= 0; i < 10; i++)
				{
					//if the traveler is on board, will move that traveler to the new location
					if(spaceShip1.isOnBoard(travList.travelers[i]) == true)
					{
						travList.travelers[i].move(spaceShip1.getCurrent());
						if (travList.travelers[i] instanceof Crew) {
							((Crew)travList.travelers[i]).setFlightHours(spaceShip1.getFlightHours());
						}
						System.out.println(travList.travelers[i].toString());
					}
				}
				if (spaceShip1.moveShip() == true ) 
				{
					System.out.println("Ship has been moved");
					System.out.println(spaceShip1.toString());
				}
				
			}
			else if (spaceShip2.getName().equalsIgnoreCase(spaceShipName)) 
			{
				
				for (i= 0; i < 10; i++)
				{
					if(spaceShip1.isOnBoard(travList.travelers[i]) == true)
					{
						travList.travelers[i].move(spaceShip1.getDestination());
						
						System.out.println(travList.travelers[i].toString());
					}
				}
				if (spaceShip2.moveShip() == true ) 
				{
					System.out.println("Ship has been moved");
					System.out.println(spaceShip2.toString());
				}
			}
			break;
		
		case 4:
			System.out.println("Here is a list of available travelers");
			System.out.println(travList + "\n");
			break;
			
		case 5:
			System.out.println("Please insert the ship that you want to see a list of travelers for");
			spaceShipName = keyboard.next();
			if (spaceShip1.getName().equalsIgnoreCase(spaceShipName)) {
				System.out.println("Here is a list of travelers on board:");
				for (i = 0; i < spaceShip1.getNumOfTravelers() ; i++) {
					if(spaceShip1.isOnBoard(travList.travelers[i]) == true) {
						System.out.println(travList.travelers[i].toString());
					}
				}
				
			}
			if (spaceShip2.getName().equalsIgnoreCase(spaceShipName)) {
				System.out.println("Here is a list of travelers on board:");
				for (i = 0; i < spaceShip2.getNumOfTravelers() ; i++) {
					if(spaceShip1.isOnBoard(travList.travelers[i]) == true) {
						System.out.println(travList.travelers[i].toString());
					}
				}
				
			}
			break;
			
		case 6:
		System.out.println("You chose to exit the program, Goodbye!");
		break;
		}
		}
		while(menuItem != 6);
	}
}
