/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 2
 * Creates Dog class to use with Kennel and Kennel test. Stores data 
 * for each Dog*/

package assignement1;

	class Dog {
		
	private String name;//name of the dog
	private int age;//the age of dog
	private double weight;//weight
	private double food;//how much daily food it requires
	private String owner;//who the owner is
	private DogVax vaccine;//the dog's vaccine status
	
	 Dog(String name, int age, double weight, double food, String owner){
		
		 
		//exceptions if any of the setters return false
		if(!setName(name)) {
			throw new RuntimeException("You did not enter a valid name");
		}	
		else{
			setName(name);
		}
		if(!setAge(age)) {
			throw new RuntimeException("You did not enter a valid age");
		}
		else {
			setAge(age);
		}
		if(!setWeight(weight)) {
			throw new RuntimeException("You did not enter a valid weight");
		}
		else {
			setWeight(weight);
		}
		if(!setFood(food)) {
			throw new RuntimeException("You did not enter a valid food weight");
			
		}
		else {
			setFood(food);
		}
		if(!setOwner(owner)) {
			throw new RuntimeException("You did not enter a valid owner");
		}
		else {
			setOwner(owner);
		}
		
		//By default if no information for vaccines were entered sets
		//all dates to 0
		vaccine = new DogVax(0,0,0);
		
		
	}// Dog Constructor
	 
	 //constructor with vaccine dates
	 Dog(String name, int age, double weight, double food, String owner,
			 int rabies, int distemper, int parvo){
		
		 
		//exceptions if any of the setters return false
		if(!setName(name)) {
			throw new RuntimeException("You did not enter a valid name");
		}	
		else{
			setName(name);
		}
		if(!setAge(age)) {
			throw new RuntimeException("You did not enter a valid age");
		}
		else {
			setAge(age);
		}
		if(!setWeight(weight)) {
			throw new RuntimeException("You did not enter a valid weight");
		}
		else {
			setWeight(weight);
		}
		if(!setFood(food)) {
			throw new RuntimeException("You did not enter a valid food weight");
			
		}
		else {
			setFood(food);
		}
		if(!setOwner(owner)) {
			throw new RuntimeException("You did not enter a valid owner");
		}
		else {
			setOwner(owner);
		}
		
		//adds the user input data into a new vaccine class for this dog
		vaccine = new DogVax(rabies, distemper, parvo);
	 }//Second dog constructor with vaccines
	 
	 
	//Setters that test varibles that go into dog.
	//all truncate input data within acceptable range.
	public boolean setName(String name) {
		
		
		if (name.length() > 0 && name.length() <=12) {
			this.name = name;
			return true;
			
		}//if
		else {
			return false;
		}//else
	}//setName()
	
	public boolean setAge(int age) {
		
		
		if (age >= 0 && age <=18) {
			this.age = age;
			return true;
		}//if
		
		else {
			return false;
		}//else
	}//setAge()
	
	public boolean setWeight(double weight) {
		
		
		if (weight >= 0.5 && weight <= 150.00) {
			this.weight = weight;
			return true;
		}//if
		
		else {
			return false;
		}//else
	}//setWeight()
	
	public boolean setFood(double food) {
		
		
		if (food >= 0.5 && food <= 5.0) {
			this.food = food;
			return true;
		}//if
		
		else {
			return false;
		}//else
	}//setFood
	
	public boolean setOwner(String owner) {
		
		
		if (owner.length() > 0 && owner.length() < 20) {
			this.owner = owner;
			return true;
		}//if
		
		else {
			return false;
		}//else
	}//setOwner()
	
	//All Getters return a String from the data provided
	public String getName() {
		return name;
	}//getName()
	
	public String getAge() {
		return String.valueOf(age);
	}//getAge
	public String getWeight() {
		return String.format("%.1f", weight);
	}//getWeight()
	public String getFood() {
		return String.format("%.1f", food);
	}//getFood()
	public String getOwner() {
		return owner;
	}//getOwner
	
	//Special getter for the vaccine. Returns True or false
	//Used in Kennel Class
	public boolean getVax() {
		return vaccine.upToDate(2020);
	}//getVax
	
	//prints out neat table for each dog object
	public void printStr() {
		
		//by default all dogs need vaccine.
		String vax = "Needs vax";
		
		if (vaccine.upToDate(2020)) {
			vax = "Up To Date";
		}//if
	
		//formatted table
		System.out.printf("%-10s\t%4s\t%4s\t%8s\t%-10s\t%s\n", 
				getName(),getAge(),getWeight(),getFood(),getOwner(),vax);
		
	}//printStr()
}









































