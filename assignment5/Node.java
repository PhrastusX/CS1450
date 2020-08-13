/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 5
 * Creates a node class which is used to create a linked list*/

package assignment5;

public class Node {

	Car car;//data in node type Car
	Node next;//points to next node
	
	Node(Car newCar , Node nxt){
		car = newCar;
		next = nxt;
	}//node constructor
}//class
