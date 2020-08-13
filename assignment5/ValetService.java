/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 6
 * Test for crazy eddies valet service using linked lists */

package assignment5;

public class ValetService {

	public static void main(String[] args) {
		
		
		//create new linked queue and stack
		LQueue alley = new LQueue();
		LStack driveway = new LStack();
		
		int time;
		
		//creates a reference integer that is used to increment values
		//in my methods
		IntRef plate = new IntRef(9990);
		IntRef turnAway = new IntRef(1);
		
		
		//simulates time passing from 1 minute to 69 minutes
		for(time = 1; time <= 69; time ++) {
			
			//when time is odd a new car is made and put
			//into driveway or alley
			if (time % 2 == 1) {
				Car newCar = new Car(makeNewPlate(plate));
				arrival(newCar, alley, driveway, turnAway);
				
			}//if handling incoming cars
			
			//every 5 minutes a car leaves from alley
			if(time % 5 == 0) {
				departure(alley, turnAway);
				emptyDriveway(alley, driveway);
			}//if handling removal of cars
		}//for
		
		//this block prints the final configuration
		System.out.println("\n***FINAL CONFIGURATION***");
		System.out.println("Alley");
		alley.display();
		System.out.println();
		System.out.println("Driveway");
		driveway.display();
	}//main
	
	//this method takes in a plate number and returns 
	//a string value of it incremented by 10
	public static String makeNewPlate(IntRef plate) {
		
		int newPlate = plate.returnInt();
		
		newPlate = 10 + plate.returnInt();
		
		plate.setInt(newPlate);
		
		return Integer.toString(newPlate);
	}//makeNewPlate()
	
	
	//this method handles arrivals of cars
	public static void arrival (Car newCar, LQueue alley, LStack driveway,
			IntRef turnAway) {
		
		//final sizes of the stack and queue
		final int MAX_D = 4;
		final int MAX_A = 7;
		
		
		//if the alley has room a car is added to it
		if(alley.size() < MAX_A) {
			alley.insert(newCar);
			System.out.printf("Adding car #%s to alley\n\n", newCar.getPlate());
			
		}//if
		//if the alley does not have room the car will be added to driveway
		else if ((alley.size() == MAX_A) && (driveway.size() < MAX_D)) {
			driveway.push(newCar);
			System.out.printf("Adding car #%s to driveway\n\n", newCar.getPlate());
			
			
		}//else if
		//if there is no room in either the car will be turned away
		//and the number of cars removed from alley will be incremented
		else {
			turnAway.setInt(turnAway.returnInt() + 1);
			System.out.printf("Car number #%s was turned away\n\n", newCar.getPlate());
			System.out.printf("New number of cars to be removed from alley: %d\n\n",
					turnAway.returnInt());
			
		}//else
		
		//this block prints out the contents of alley and driveway
		System.out.println("Alley");
		alley.display();
		System.out.println();
		System.out.println("Driveway");
		driveway.display();
		System.out.println();
		
		
	}//arrival
	
	
	//this method handles cars leaving the alley
	public static void departure( LQueue alley, IntRef turnAway) {
		
		//holder variable so we do not decrement the stored value in turnAway
		int i = turnAway.returnInt();
		
		//executes as long as the holder value is greater or 
		//equal to 1. and the alley is not empty
		while(i >=1 && !alley.isEmpty()) {
			
			//executes only initially
			if(i == turnAway.returnInt()) 
				System.out.print("REMOVED: ");
			
			//prints out the car thats removed
			Car removed = alley.remove();
			System.out.printf("#%s ", removed.getPlate());
			i--;
		}//while
		
		//executes if the alley is empty decrementing turnaway by 1
		System.out.println();
		if(alley.isEmpty()) {
			turnAway.setInt(turnAway.returnInt()-1);
			System.out.printf("Number of cars to be removed reduced to %d\n", turnAway.returnInt());
		}//if
		
	}//departure()
	
	
	//this method empties the driveway into the alley
	public static void emptyDriveway(LQueue alley, LStack driveway) {
		
		//holder
		int numInAlley = alley.size();
		
		//executes while the driveway is not empty and 
		//there the alley is not maxed out
		while(!driveway.isEmpty() && numInAlley < 7) {
			
			//stores the car removed from driveway
			Car removed = driveway.pop();
			alley.insert(removed);
			System.out.printf("Car %s was removed from driveway and added to alley\n\n", removed.getPlate());
			numInAlley++;
			}//while
			
		
	}//emptyDriveway
}//ValetService
