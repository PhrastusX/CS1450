/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 2
 * Program adds a new element to the Dog class, testing for compliance with
 * vaccines.*/

package assignement1;

public class DogVax {

	//represents the years since the dog got a paticular vaccine
	private int rabies;
	private int distemper;
	private int parvo;
		
	DogVax(int rabies, int distemper, int parvo){
		setRabies(rabies);
		setDistemper(distemper);
		setParvo(parvo);
	}//DogVax constructor
	
	//all setters test for positive numbers
	public boolean setRabies(int rabies) {
		
		
		if(rabies > 0) {
			this.rabies = rabies;
			return true;
		}//if
		
		else {
			this.rabies = 0;
			return false;
		}//else
	}//setRabies()
	
	
	public boolean setDistemper(int distemper) {
		
		
		if (distemper > 0) {
			this.distemper = distemper;
			return true;
		}//if
		
		else {
			this.distemper = 0;
			return false;
		}//else
	}//setDistemper()
	
	
	public boolean setParvo(int parvo) {
		if (parvo > 0) {
			this.parvo = parvo;
			return true;
		}//if
		
		else {
			this.distemper = 0;
			return false;
		}//else
	}//setParvo()
	
	//returns true if dogs were given vaccines less than 2 years ago
	public boolean upToDate(int currentYear) {
		
		
		if ((currentYear - rabies)<2 && (currentYear - parvo)<2 &&
				(currentYear - distemper)<2) {
			return true;
			
		}//if
		else {
			return false;
		}//else
	}//upToDate()
	
	
}//DogVax
