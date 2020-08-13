/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 4
 * Creates a Queue class*/

package assignment4;

public class Aqueue {
	
	private int capacity;//keeps track of empty spaces
	private Car[] storage;//stores Cars
	private int front, rear;//marks front and rear of array
	private boolean empty;//true if no items have been entered
	private Astack stack;//used for the reverseQueue()
	
	//constructor takes in the size of array
	public Aqueue(int size) {
		capacity = size;
		storage = new Car[capacity];
		front = 0;
		rear = -1;
		empty = true;
	}//constructor
	
	
	//inserts a new Car into Array
	public void insert(Car plate) {
		
		//tests to see if there is room in array
		if (size() < capacity) {
			rear++;//increments rear
			if (rear == capacity) {
				rear = 0;
			}//if
			
			//adds plate to storage array
			storage[rear] = plate;
			empty = false;
		}//if
		
	}//insert()
	
	
	//removes a Car in storage and returns the Car Object
	public Car remove() {
		
		
		Car result = storage[front];
		front ++;
		
		//tests to make sure there is room in array
		if (front == capacity) {
			//
			front = 0;
			
			//empty set to true if front is ahead of rear
			//or front has hit capacity and rear is capacity -1
			empty = ((front == rear + 1) || 
					((front ==0) &&(rear==(capacity-1))));
		}//if
		return result;
	}//remove()
	
	
	public boolean isEmpty() {
		return size() ==0;
		}//isEmpty()
	
	
	public Car front() {
		return storage[front];
	}//front()
	
	//returns the number of Cars in array
	public int size() {
		int result;
		int gap;//unused space in array
		
		
		if(empty) {
			result = 0;
		}//outer if
		
		//executes if array is not empty
		else {
			
			//if rear is ahead of front
			if (rear >= front) {
				result = rear-front+1;
			}//inner if
			
			//execute if array if rear is less than front
			else {
				
				//gap is the unused spaces
				gap = front - rear -1;
				result = capacity - gap;
			}//inner else
		}//outer else	
		
		return result;
	}//size()
	
	
	//prints out a neat list of Cars in Queue
	public void display() {
		
		int i = 0;
		
		//executes if there are cars in array
		if(!isEmpty()) {
			i = front;//starts at the front
			System.out.println("-------------------------"
					+ "-----------------------");
			System.out.print("FRONT <---|");
			//while front does not equal rear
			while (i != rear) {
				System.out.print(storage[i].getPlate() + "|");
				i++;
				if (i ==capacity) {
					i=0;
				}
			}//while
			String element = storage[rear].getPlate()+"|";
			System.out.print(element);
			System.out.println("<---Rear");
			System.out.println("------------------------"
					+ "------------------------");
		}//if
		
		//executes if array is empty
		else {
			System.out.print("Empty");
			System.out.println();
		
		}//else
		
	}//display()
	
	
	//reverses the order in Queue using Stack
	public void reverseQueue() {
		
		stack = new Astack(storage.length);
		
		//executes if Queue is not empty
		while (!isEmpty()) {
			
			//stores in stack
			stack.push(remove());
		}//while
		//executes while stack is not empty
		while (!stack.isEmpty()) {
			
			//puts it back in queue
			insert(stack.pop());
		}//while
		
		
	}//reverseQueue()
}//Aqueue
