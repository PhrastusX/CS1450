/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 2
 * Creates a data structure to hold Dogs, and provides useful methods
 * for manipulating that data*/
package assignement1;

public class Kennel {
	
	private Dog[] kennel;//an array to hold Dog objects
	private int maxSize;//the maximum size of the array
	private int numDogs;//the number of Dogs currently in the array
	
	//creates a Kennel class
	Kennel(int maxSize){
		this.maxSize = maxSize;
		kennel = new Dog[maxSize];//initializes the new array based on max size
		numDogs = 0;
		
	}//Kennel
	
	//places a newly created dog in kennel array with vaccinations
	public boolean addDog(String name, int age, double weight, double food, String owner,
			int rabies, int distemper, int parvo) throws RuntimeException {
		
		//this block will execute if all the conditions for dog return true
		try {
			if (numDogs <= maxSize -1) {
				kennel[numDogs] = new Dog(name, age, weight, food, owner,rabies,
						distemper, parvo);
				numDogs++;
				return true;
			}//if
			
			else {
				return false;
			}//else
			
		}//try
		
		//puts null in the space if conditions for dog return false
		catch(RuntimeException ex) {
			kennel[numDogs] = null;
			return false;
		}//catch
	}//addDog()
	
	//adds a dog to the array without vaccinations.
	public boolean addDog(String name, int age, double weight, double food, String owner)
			throws RuntimeException {
		
		//this block will execute if all the conditions for dog return true
		try {
			if (numDogs <= maxSize -1) {
				kennel[numDogs] = new Dog(name, age, weight, food, owner);
				numDogs++;
				return true;
			}//if
			
			else {
				return false;
			}//else
		}//try
		
		//puts null in the space if conditions for dog return false
		catch(RuntimeException ex) {
			kennel[numDogs] = null;
			return false;
		}//catch
	}//addDog()
	
	//deletes a dog and moves all the others down the array
	public boolean deleteDog(int index) throws ArrayIndexOutOfBoundsException {
		
		
		try {
			if (index  < maxSize && index < numDogs) {
				
				//moves the deleted dog down the array to the next higher index.
				for(int i = index -1 ; i < maxSize-1; i++) {
					kennel[i] = kennel[i+1];
					kennel[i+1] = null;
				}//for
				
				//decrements numDogs if one is deleted
				numDogs--;
				return true;
			}//if
			
			
		}//try
		
		//if the user picks a negative number a message will print
		catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Please pick a positive number");
		}//catch
		
		//requires the user to delete a dog in the array if it is not full
		System.out.printf("Please pick a number within 1 and %d\n", numDogs);
		return false;
	}
	
	//prints a nice table of all dogs in the kennel
	public void printDogs() {
		
		
		try {
			if(numDogs == 0) {
				System.out.println("No Dogs in Kennel\n");
			}
			else {
			System.out.println("   Name\t\t  Age\tWeight\t  Daily Food  \tOwner\t\tStatus  ");
			System.out.println("------------------------------------------------"
					+ "-------------------------");
			
			//prints a number next to the dog information for easy
			//indexing by the user
			for(int i =0; i < numDogs;i++) {
				System.out.print(i+1+ ". ");
				kennel[i].printStr();
				}//for
			}//else
			
		}//try
		
		//prints a new line when the array does not have any more dogs
		catch (NullPointerException ex) {
			System.out.println();
		}//catch
			
	}//printDogs()
	
	//will print out all the unvaccinated dogs
	public void showUnvaccinated() {
		
		
		//the header
		System.out.println("****Dogs that are Unvaccinated****");
		System.out.println("   Name\t\t  Age\tWeight\t  Daily Food \tOwner\t\tStatus  ");
		System.out.println("------------------------------------------------"
				+ "-------------------------");
		
		//prints out dogs that are not vaccinated
		
		int numCounter =0; //counter for the indexing of the output table
		for(int i = 0; i < numDogs; i++) {
			
			if (!kennel[i].getVax()) {
				System.out.print(numCounter+1+ ". ");
				kennel[i].printStr();
				numCounter++;
				}//if
			}//for
		}//showUnvaccinated()
	
	//prints vaccinated dogs to console
	public void showVaccinated() {
		
		//the header
		System.out.println("****Dogs that are Vaccinated****");
		System.out.println("   Name\t\t  Age\tWeight\t  Daily Food \tOwner\t\tStatus  ");
		System.out.println("------------------------------------------------"
				+ "-------------------------");
		
		int numCounter=0;//for indexing the output table
		for(int i = 0; i < numDogs; i++) {
			
			if (kennel[i].getVax()) {
				System.out.print(numCounter + 1 + ". ");
				kennel[i].printStr();
				numCounter++;
				}//if
			}//for
		}//showVaccinated()
	
	//removes any unvaccinated dogs from array
	public void removeUnvaccinated() {
		
		
		for(int i = 0; i < numDogs; i++) {
			
			//if false will remove the dog from array
			if(!kennel[i].getVax()) {
				
				//special case when the first dog in array is unvaccinated
				if(i ==0) {
					
					//deletes dog
					kennel[i] = null;
					//moved the rest of the dogs up the list
					deleteDog(i+1);
					//ensures the array at that index will be tested again
					i--;
				}// inside if
				
				//all other cases for the kennel array
				else {
					
				//deletes dog and moves them all up the array
				kennel[i] = null;
				deleteDog(i+1);
				//ensures the array at that index will be tested again
				i--;
				
				}//inside else
			}//if		
			
		}//for
		
	}//removeUnvaccined()
	
	public Kennel moveUnvaccinated() {
		
		
		//creates new Kennel Class
		Kennel unvaccinated = new Kennel(maxSize);
		
		//loops through kennel that needs to be copied
		for(int i = 0; i < numDogs; i ++) {
			
			//test for dogs who need vaccine
			if (!kennel[i].getVax()) {
				
				//copies the arrays in each class for unvaccinated dogs
				unvaccinated.kennel[unvaccinated.numDogs] = kennel[i];
				
				//increments numDogs to not leave spaces in new array
				unvaccinated.numDogs++;
			}//if
			
		}//for
		
		//removes unvaccinated from original array
		removeUnvaccinated();
		
		return unvaccinated;
	}//moveUnvaccinated()
	
}//Kennel
