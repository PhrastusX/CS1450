/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 6
 * I created this class so I can pass integer values by reference 
 * I think the code is pretty straight forward.  */


package assignment5;

public class IntRef {

	private int integer;
	
	public IntRef(int i) {
		integer = i;
	}

	public void setInt(int i) {
		integer = i;
		
	}
	
	public int returnInt() {
		return integer;
	}
}

