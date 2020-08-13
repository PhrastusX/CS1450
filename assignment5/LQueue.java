/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 5
 * Implimintation of Queue using linked lists*/


package assignment5;

public class LQueue {
	private Node front, rear;//creates front and rear nodes
	
	//sets front and rear equal to null on initialization
	public LQueue() {
		front = null;
		rear = null;
	}//constructor
	
	//inserts a new car into Queue
	public void insert(Car newCar) {
		
		//executes if the Queue is empty
		if (isEmpty()) {
			front = new Node(newCar, null);
			rear = front;
		}//if
		else {
			//sets the next node equal to new Car
			rear.next = new Node(newCar, null);
			//sets the new rear equal to node just created
			rear = rear.next;
		}//else
	}//insert()
	
	//removes a Car from the front of Queue
	//returns the Car removed
	public Car remove() {
		Car temp = front.car;
		front = front.next;
		return temp;
	}//remove()
	
	//tests if queue is empty
	public boolean isEmpty() {
		return (front == null);
	}//isEmpty()
	
	//returns size of queue
	public int size() {
		
		
		int count = 0;//keeps track of nodes in LL
		
		Node current = front;//starting point of count
		
		//terminates when the last item in Queue is reached
		while(current != null) {
			count++;//keeps track of moves
			current = current.next;//moves through Queue
		}//while
		
		return count;
	}//size()
	
	//prints a neat list of Cars in Queue
	public void display() {
		
		
		Node current;//current node
	
		
		//will not execute if Queue is empty
		if(!isEmpty()) {
			
			current = front;//starts at the front
			System.out.println("-------------------------"
					+ "------------------------");
			System.out.print("FRONT <---|");
			//while the current node does not point to null
			while (current != null) {
				System.out.print(current.car.getPlate() + "|");
				current = current.next;
				
			}//while
			
			System.out.println("<---Rear");
			System.out.println("------------------------"
					+ "-------------------------");
		}//if
		
		//executes if Queue is empty
		else {
			System.out.print("Empty");
			System.out.println();
		
		}//else
	
	}//display
	
	//reverses the order of Queue
	public void reverseQueue() {
		
		//initialize new stack for holding Queue
		LStack stack = new LStack();
		
		//while stack is not empty
		while (!isEmpty()) {
			//stores it in queue
			stack.push(remove());
		}//while
		
		//while queue is not empty
		while(!stack.isEmpty()) {
			//puts items back in stack
			insert(stack.pop());
		}//while
		
		
	}//reverseStack
}//LQueue
