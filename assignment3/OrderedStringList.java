/*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 3
 * Creates an OrderedStringList data structure with various methods
 * to manipulate the data*/

package assignment3;

public class OrderedStringList {
    private int length;//length of the array -1
    public String[] storage;//array to hold strings
    private int numWords = 0;//tracks the number of words held in array
    
    
    OrderedStringList(int size){
        length = size -1;//stores length as largest reachable index.
        storage = new String[size];//initializes new String array.
        
    }//constructor
    
    //Inserts a string into the list in a sorted fashion
    public boolean insert(String word)  {
        
    	//default case for results
    	boolean result = false;
    	int index =0;
    	
    	//tests to see if there is room in the array
    	if(numWords < length) {
    		
    		//continues to loop until the word in the list is less than word being added
    		while ((index < numWords) && 
    				(storage[index].compareToIgnoreCase(word) < 
    				word.compareToIgnoreCase(storage[index]))){
    			index++;
    		}//while
    		
    		//moves all the words down an an index to make room for the new word
    		moveWordsDown(index);
    		//puts word into the index
    		storage[index] = word;
    		//increments numWords because one was added
    		numWords++;
    		//operation will return true because the word was added
    		result = true;
    	}//if
    	
    	return result;
       
        
    }//insert()
    
    //simple method that returns the number of words in the list
    public int size(){
    	return numWords;
        
    }//size()
    
    
    //finds the index where the input string is located
    public int find(String s){
    	
    	
    	boolean found = false;//default case for the word being found
    	int index = 0;//starting index
    	int result = -1;//default return if not found
    	
    	//executes while the index while found remains false and the index isnt
    	//greater than the words in the list
    	while ((index < numWords)&& (!found)) {
    		
    		//will set found to true if the input word is found
    		found = (s == storage[index]);
    		//increments index looking for the word
    		if (!found) {
    			index++;
    		}//if
    	}//while
    	
    	//if the value was found the index is stored in result
    	if (found) {
    		result = index;	
    	}
    	return result;
        
    }//find()
    
    //deletes a given string in the storage array
    public boolean delete(String s){
    	
    	
    	boolean result = false;//default return if the word was not found
    	int location;//stores the index found() finds
    	
    	//calls find(s) continues if the word was found
    	if(find(s) != -1) {
    		//stores the index of the word
    		location = find(s);
    		//deletes the word by moving all of the words up one space
    		moveWordsUp(location);
    		//decrements num Words
    		numWords--;
    		//deletes the extra value at the end of the list
    		storage[numWords] = null;
    		result = true;
    		
    	}
    	return result;
        
    }//delete()
    
    //inserts the list of words from list to another
    public boolean insertList(OrderedStringList newList){
    	
    	
    	boolean result = true;//default return
    	
    	//cycles through newList to add the words
    	for(int i = 0; i < newList.numWords ; i++) {
    		
    		//test to make sure there is room in array
    		if(numWords < length) {
    			insert(newList.storage[i]);	
    		}//if
    		
    		else {
    			return false;
    		}//else
    	}//for
    	
    	return result;
    	
    }//insertList()
    
    //prints out the full list without new lines and spaces inbetween items
    public void displayNoLF(){
    	for (int i = 0; i < numWords; i++) {
    		System.out.print(storage[i]+ " ");
    	}
        
    }//displayNoLF()
    
    //prints out all the items in the list
    public void display(){
    	
    	for(int i = 0; i< numWords; i++) {
    		System.out.print(i+1 + ". ");
    		System.out.println(storage[i]);
    	}//for
    	
        
    }//display()
    
    //moves all the words down one slot
    private void moveWordsDown(int start) {
    	for(int i = numWords -1; i>=start; i--) {
    		storage[i+1] = storage[i];
    		
    	}//for
    }//moveWordsDown()
    
    //moves all the words up one slot
    private void moveWordsUp(int start) {
    	for (int i = start; i < numWords-1; i++) {
    		storage[i] = storage[i+1];
    	}//for
    }//moveWordsUp()
    
}//OrderedStringList

