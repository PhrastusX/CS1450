/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 5
 * Tests the implimitation of The LStack, LQueue classes, and node classes uses
 * linked lists as a data structure */


package assignment5;

import java.util.Scanner;

public class LstackandQueueTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//number of iterations for stack and queue
		final int NUM_STACK = 7;
		final int NUM_QUEUE = 5;
		
		//initializing new stacks and queue linked list
		LStack newStack = new LStack();
		LQueue newQueue = new LQueue();
		
		//this block gets input from the user and puts it into newStack
		System.out.printf("Input %d licence plates to add to LStack\n\n", NUM_STACK);
		addToStack(newStack, input, NUM_STACK);
		
		//this block gets input from user and puts it into newQueue
		System.out.printf("Enter %d license plates to add to AQueue\n\n", NUM_QUEUE);
		addToQueue(newQueue, input, NUM_QUEUE);
		
		//closes input
		input.close();
		
		
		//prints out LStack
		System.out.println("This is the Lstack in order Cars were placed");
		newStack.display();
		System.out.println();
		
		//prints out LQueue
		System.out.println("This is the LQueue in order Cars were placed");
		newQueue.display();
		System.out.println();
		
		//reverses LStack and prints out new stack
		System.out.println("This is the Lstack in reverse order");
		newStack.reverseStack();
		newStack.display();
		System.out.println();
		
		//reverses LQueue and prints out new stack
		System.out.println("This is the LQueue in reverse order");
		newQueue.reverseQueue();
		newQueue.display();
		System.out.println();
		
		
		
		
	}//main
	
	//prompts user to input cars to add to stack
	public static void addToStack(LStack newStack, Scanner input, int NUM_STACK) {
		
		int stackCount = 0;//control for loop
		
		//executes until the max number of cars has been added
		while (stackCount < NUM_STACK) {
			
			try {
				//stores new car in stack
				System.out.println("Enter the plate number to put into Stack: ");
				newStack.push(new Car(input.next()));
				stackCount++;
			}
			//catches a runtime error where an incorrect input was entered
			catch(RuntimeException ex) {
				System.out.println("Plate number must be between 1 and 6 characters");
			}
			
		}//while stack
		
		System.out.println("The Stack is now full\n");
		
	}//addToStack()
	
	
	//prompts user for Cars to add to Queue
	public static void addToQueue(LQueue newQueue, Scanner input, int NUM_QUEUE) {
		
		int queueCount = 0;//control for while loop
		
		//executes until max num of Cars is reached
		while (queueCount < NUM_QUEUE) {
			
			try {
				//adds car to queue and increments count
				System.out.println("Enter the plate number to put into Queue: ");
				newQueue.insert(new Car(input.next()));
				queueCount++;
			}
			
			//catches a runtime error where an incorrect input was entered
			catch(RuntimeException ex) {
				System.out.println("Plate number must be between 1 and 6 characters");
			}
			
		}//while Queue
		
		System.out.println("The Queue is now full\n");
	}//addToQueue()

}//test Class
