/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 4
 * Creates a Stack class*/

package assignment4;

public class Astack {
	
	
	private Car[] storage;//array that stores Car objects
	private int top; //index at the top of stack
	private Aqueue queue;//initializes a Queue object for reverseStack()
	
	
	//constructor
	public Astack(int size) {
		storage = new Car[size];
		top = -1;
	}//Astack Constructor
	
	//puts a new car in the top of the array
	public boolean push(Car licencePlate) {
		
		//default 
		boolean entered = false;
			
			//makes sure there is room in the array to add
			if ( top < (storage.length-1)) {
				
				
				top++;//increments top
				//adds the new license plate
				storage[top]= licencePlate;
				entered = true;
			}//if
	
		return entered;
	}//push()
	
	
	//removes a Car from the top of array
	//returns the Car that was removed
	public Car pop() {
		Car result = null;
		
		//will not execute if the array is empty
		if(!isEmpty() ) {
			result = storage[top];
			top--;//decrements the top
		}//if
		return result;
	}//pop()
	

	public boolean isEmpty() {
		return top < 0;
	}//isEmpty()
	
	
	public int size() {
		return (top+1);
	}//size()
	
	//prints a neat list of the Cars in storage
	public void display() {
		
		
		int i;
		
		
		
		//will not execute if array is empty
		if(!isEmpty()) {
			i = top;
			System.out.println("-------------------------------------------------");
			System.out.print("TOP <---|");
			//executes while there is still an item in array
			while (i >=0) {
				
				System.out.print(storage[i].getPlate() + "|");
				
				i--;
			}//while
			System.out.println();
			System.out.println("-------------------------------------------------");
		}//if
		else {
			//prints out empty if there are no cars in array
			System.out.print("Empty");
			System.out.println();
		}//else
		
		
		
	}//display()
	
	//reverses the stack using AQueue
	public void reverseStack() {
		
		
		queue = new Aqueue(storage.length);
		
		//while stack is not empty
		while (!isEmpty()) {
			//stores it in queue
			queue.insert(pop());
		}//while
		
		//while queue is not empty
		while(!queue.isEmpty()) {
			//puts items back in stack
			push(queue.remove());
		}//while
		
		
	}//reverseStack
	
}//Astack
