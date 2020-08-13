/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 5
 * Creates a Car class which will be the data type for the stack
 * and queue classes*/

package assignment5;

public class Car {

private String licensePlate;
	
	//constructor tests if the right amount of characters were entered
	Car(String plate) {
		
		//Runtime Exception if the setPlate method returns false
		if(!setPlate(plate)) {
			throw new RuntimeException("Plate must be "
					+ "between 1 and 6 characters ");
		}//if
		
		else {
			licensePlate = plate;
		}//else
		
	}//constructor
	
	//setter that takes off excess spaces from input
	public boolean setPlate(String plate) {
		
		
		String unpaddedPlate = plate.strip();
		//tests for the correct characters were input. returns true
		if(unpaddedPlate.length() > 0 && unpaddedPlate.length() <=6)  {
			licensePlate = plate;
			return true;
		}//if
		else {
			return false;
		}//setPlate()
		
	}//setPlate()
	
	
	public String getPlate(){
		return licensePlate;
	}//getPlate()
	
	
	
}//Car


