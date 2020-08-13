/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 2
 * Contains main. Tests the methods created in the Kennel Class*/
package assignement1;

public class KennelTest {

	public static void main(String[] args){
		
		
		//creates a new kennel
		Kennel pound = new Kennel(10);
		
		//prints empty array
		pound.printDogs();
		
		//add 10 dogs
		pound.addDog("Fido", 4, 150, 4, "Theo",2020,2020,2020);
		pound.addDog("Rex", 3, 10, .5, "Theo");
		pound.addDog("Oliver", 10, 35, 1, "Melody");
		pound.addDog("Zoe", 13, 20, 1, "Melody",2020,2019,2020);
		pound.addDog("Precious", 11, 15, 1, "Frank",2019,2019,2020);
		pound.addDog("Princess", 10, 100, 3.5, "John",2019,2019,2020);
		pound.addDog("Akia", 7, 75, 2.5, "Frank");
		pound.addDog("Precision", 5, 55, 2, "Melody",2020,2020,2020);
		pound.addDog("Accuracy", 9,33, 1.5, "Ashlee",2020,2020,2020);
		pound.addDog("Java", 15, 145, 4, "Jason",2020,2020,2020);
		
		//prints unvaccinated dogs
		pound.showUnvaccinated();
		System.out.println();
		
		//prints vaccinated dogs
		pound.showVaccinated();
		System.out.println();
		
		
		//prints out new list
		pound.printDogs();
		System.out.println();
		
		Kennel unvaccinated = pound.moveUnvaccinated();
		
		
		pound.printDogs();
		System.out.println();
		
		unvaccinated.printDogs();
	}//main

}//KennelTest
