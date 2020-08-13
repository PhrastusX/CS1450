/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 5
 * Implementation of Stack using linked lists */

package assignment5;

public class LStack {
	private Node top;//represents the top of the stack
	private int count;//how many items in the stack
	
	public LStack() {
		top = null;
		count = 0;
		
	}//Lstack constructor
	
	//adds a new car to Stack at top
	public void push(Car newCar) {
		top = new Node(newCar, top);
		count++;//increment count of cars
	}//push()
	
	//removes Car from stack
	//returns the car
	public Car pop() {
		
		Car oldCar = top.car;
		top = top.next;
		count--;
		return oldCar;
	}//pop()
	
	//tests if the stack is empty
	public boolean isEmpty() {
		
		if(count == 0) {
			return true;
		}//if
		
		else {
			return false;
		}//else
	}//isEmpty()
	
	public int size() {
		return count;
	}
	
	//prints out a neat list of Cars in Stack
	public void display() {
		
		Node current;//sets variable for current node
		
		//will not execute if array is empty
		if(!isEmpty()) {
			
			
			current = top;//sets current equal to top
			System.out.println("-------------------------------------------------");
			System.out.print("TOP <---|");
			
			//executes while there is still an item in array
			while (current != null) {
				
				System.out.print(current.car.getPlate() + "|");
				current = current.next;
				
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
	
	//reverses the order of the Stack using LQueue class
	public void reverseStack() {
		
		//initializes a new queue
		LQueue queue = new LQueue();
		
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
	
}//class
