/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 6
 * Test for crazy eddies valet service using linked lists */

package assignment5;

public class ValetService2 {
	
	public static int plate = 9990;
	public static int turnAway = 1;

	public static void main(String[] args) {
		
		
		
		LQueue alley = new LQueue();
		LStack driveway = new LStack();
		
		int time;
		
		
		
		
		for(time = 1; time <= 69; time ++) {
			System.out.printf("Time: %d\n", time);
			
			
			if (time % 2 == 1) {
				Car newCar = new Car(makeNewPlate(plate));
				arrival(newCar, alley, driveway, turnAway);
				
			}//if handling incoming cars
			if(time % 5 == 0) {
				departure(alley, turnAway);
				emptyDriveway(alley, driveway);
			}//if handling removal of cars
		}//for
		
		alley.display();
		driveway.display();
	}//main
	
	
	public static String makeNewPlate(int plate) {
		
		int newPlate = plate;
		
		newPlate = 10 + plate;
		
		plate = newPlate;
		
		return Integer.toString(newPlate);
	}//makeNewPlate()
	
	public static void arrival (Car newCar, LQueue alley, LStack driveway,
			int turnAway) {
		
		final int MAX_D = 4;
		final int MAX_A = 6;
		
		
		
		if(alley.size() < MAX_A) {
			alley.insert(newCar);
			System.out.printf("Adding car %s to alley\n", newCar.getPlate());
			System.out.printf("Total number of cars in alley: %d\n\n", alley.size());
		}
		else if ((alley.size() == MAX_A) && (driveway.size() < MAX_D)) {
			driveway.push(newCar);
			System.out.printf("Adding car %s to driveway\n", newCar.getPlate());
			System.out.printf("Total number of cars in driveway: %d\n\n", driveway.size());
			
		}
		else {
			turnAway+=1;
			System.out.printf("Car number %s was turned away\n", newCar.getPlate());
			System.out.printf("New number of cars to be removed from alley: %d\n\n",
					turnAway);
			
		}
		
		
	}//arrival
	
	public static void departure( LQueue alley, int turnAway) {
		int i = turnAway;
		while(i >=1 && !alley.isEmpty()) {
			Car removed = alley.remove();
			System.out.printf("Car %s was removed from alley\n\n", removed.getPlate());
			i--;
		}
		if(alley.isEmpty()) {
			turnAway -= 1;
			System.out.printf("Number of cars to be removed reduced to %d\n", turnAway);
		}
		
	}//departure()
	
	
	public static void emptyDriveway(LQueue alley, LStack driveway) {
		
		int numInAlley = alley.size();
		
		while(!driveway.isEmpty() && numInAlley < 6) {
			Car removed = driveway.pop();
			alley.insert(removed);
			System.out.printf("Car %s was removed from driveway and added to alley\n\n", removed.getPlate());
			numInAlley++;
			}
			
		
	}
}//ValetService
