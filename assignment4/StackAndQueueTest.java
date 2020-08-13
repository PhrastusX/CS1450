/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 4
 * Tests the Stack and Queue classes*/

package assignment4;

import java.util.Scanner;

public class StackAndQueueTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//creates a Stack class to store cars
		Astack cars = new Astack(7);
		
		System.out.println("Input 7 licence plates to add to Astack");
		
		//executes for the length of array to fill it up
		//catches any invalid input
		while(cars.size() < 7) {
			
			try {
				System.out.println("Enter A Plate Number");
				String plate = input.next();
				
				//creates a new car and stores it in stack
				Car tempCar = new Car(plate);
				cars.push(tempCar);
			}//try
			
			//prints out an error message if invalid input
			catch(RuntimeException ex) {
				System.out.println("Enter A licence plate between 1 and 6 characters");
			}//catch
			
		}//while
		
		//creates a Queue object to hold cars
		Aqueue otherCars = new Aqueue(5);
		
		//
		System.out.println("Enter 5 license plates to add to AQueue");
		while(otherCars.size() < 5) {
			
			try {
				System.out.println("Enter A Plate Number");
				String plate = input.next();
				
				Car tempCar = new Car(plate);
				otherCars.insert(tempCar);
			}//try
			catch(RuntimeException ex) {
				System.out.println("Enter A licence plate between 1 and 6 characters");
			}//catch
			
		}//while
		
		input.close();
		
		//prints Astack Cars in the order they were input
		System.out.println("Prints Cars in Astack in order");
		cars.display();
		
		//demonstrates reversing the Stack
		System.out.println();
		System.out.println("Prints Cars in Astack in reverse order");
		cars.reverseStack();
		cars.display();
		
		//prints out Aqueue Cars in order
		System.out.println("\nPrints the Aqueue Cars in order");
		otherCars.display();
		
		//demonstrates reversing the Queue
		System.out.println();
		System.out.println("Prints Aqueue Cars with reversed order");
		otherCars.reverseQueue();
		otherCars.display();
		System.out.println();
		
		
		
		
		

	}//main

}//StackAndQueueTest
