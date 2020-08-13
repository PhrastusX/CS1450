/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 3
 * Tests all the methods in OrderedStringList Class*/


package assignment3;

public class OrderedStringListTest {

	public static void main(String[] args) {
		
		//Initializing new OrderedStringList with an array with length 9
		OrderedStringList list = new OrderedStringList(9);
        
		//Puts words into the list Using Insert
		list.insert("Hello");
		list.insert("GoodBye");
		list.insert("Forte");
		list.insert("ABC");
		list.insert("End");
        
		//Displays size of OrderedStringList
		System.out.println("Current Size of list is: "+list.size() +"\n");
        
        //prints the list with numbers vertically
        list.display();
        System.out.println();
        
        //Finds the Word in the list and 
        System.out.println("Uses find() method to find the index where End is");
        System.out.println(list.find("End")+"\n");
        
        //deletes "Forte" from list
        System.out.println("Deletes Forte from list using delete() method");
        list.delete("Forte");
        list.display();
        
        //creates a new Ordered String list to be used by insertList
        OrderedStringList newList = new OrderedStringList(100);
        
        newList.insert("What");
		newList.insert("Where");
		newList.insert("When");
		newList.insert("How");
		newList.insert("Why");
        
		//displays new list
		
		System.out.println();
		System.out.println("Displays the new list that will be merged with list");
		newList.display();
		
		//inserts newList into list
		
		System.out.println("\nDemonstrates insertList method");
		list.insertList(newList);
        list.display();
        //prints boolean value for insertList()
        System.out.println("\nShows insertListMethod() returned false and could not"
        		+ " add all the value from newList");
        System.out.println(list.insertList(newList));
        
       //Display The list in horizontal format without numbers
      	System.out.println("\nUses displayNoLF to print the list");
      	list.displayNoLF();
      	System.out.println("\n");
              
       
	}//main

}//OrderedStringListTest
