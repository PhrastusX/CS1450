/*
 /*Theophrastus Gamboni-Diehl
 * CS-2
 * Assignment 9
 * Code for implementing a BST. includes insert() and display()
 * to be used in main added method for finding height, size and 
 * and finding average searches.
 */
package assignment8;

public class BStree {
    private BTnode root;//pointer to first element in BST
    private int wordCount;//keeps track of number of words
    private int counter;//how many times visitS was used
    private int searchCount;//number of searches through whole tree
    BStree(){
        root = null;
        wordCount = 0;
        searchCount = 0;
    }
    
    public int returnSearchCount(){
        return searchCount;
    }
    
    //inserts a new word into BST
    public BTnode insert(String newWord, boolean isLowerCase){
        
        
        BTnode newNode = null;//initializes new node
        
        //if is lower case is true converts all words coming in to lower
        if(isLowerCase){
            newWord = newWord.toLowerCase();
        }
        
        //if the tree is empty root points to new node
        if(root == null){
            root = new BTnode(newWord, null, null);
            newNode = root;
        }//if
        
        //recursive function to find a spot in tree for new word
        else{
            newNode = AddR(root,newWord);
            
        }
        
        //returns the new node
        return newNode;
    }//insert()
    
    
    //recursive function used in insert
    private BTnode AddR(BTnode node, String newWord){
        
        //initilizes new node
        BTnode newNode = null;
        
        //if the new word is less than the node compared to insert to left
        if(newWord.compareTo(node.data) < node.data.compareTo(newWord)){
            if(node.left == null){
                node.left = new BTnode(newWord, null, null);
                newNode = node.left;
                
            }//if
            
            //recurses again if there is no room until it finds a null pointer
            else{
                AddR(node.left,newWord);
            }//else
        }//if
        //if the word exists then it increments count
        else if(newWord.equals(node.data)){
            node.count++;
        }
        //if new word is greater than the old word inserts to the right
        //when it finds a null pointer
        else{
            if(node.right == null){
                node.right = new BTnode(newWord, null, null);
                newNode = node.right;
            }
            else{
                AddR(node.right, newWord);
            }
        }
        return newNode;
    }//AddR
    
    //returns the wordCount
    private int wordCount(){
        
        
      return inOrder(root);
    }
    

    //an in order traversal of tree to 
    private int inOrder(BTnode node){
        
        //base case when the node equals null
        if(node != null){
            //traverses left first then visits the lowest node
            //then traverses right
            inOrder(node.left);
            wordCount += visit(node);
            inOrder(node.right);
        }
        return wordCount;

    }//inOrder
    
    //same as above method but used for printing
    private void inOrderS(BTnode node){
        
        if(node != null){

            inOrderS(node.left);
            
            inOrderS(node.right); 
            visitS(node);
            
        }
    }//inOrderS
    
    //inOrder Recursion for the average search method
    private void inOrderC(BTnode node){
        if(node != null){
            
            inOrderC(node.left);
            visitC(node);
            inOrderC(node.right);
            
        }
    }
    
    //returns the count at the node
    private int visit(BTnode node){
        return node.count;
    }//visit()
    
    //prints out a neet list of all words and the counts
    private void visitS(BTnode node){
        
        //creates temp variables so the data in tree is not changed
        String tempString = node.data;
        int tempCount = node.count;
        
        //every 4 itterations prints out a new line
        if(counter % 4 == 0){
           
            System.out.print("\n|");
        }
        //truincates the length down to 8 characters
        if(tempString.length() > 10){
            tempString = tempString.substring(0,8) + "..";
        }
        
        //formatted output
        System.out.printf("%-10s %3d |", tempString, tempCount);
        counter++;
    }//visitS()
    
    //used for inOrderC when visiting a node
    private void visitC(BTnode node){
        
        
        int searchCountEach = searchCount(node.data);
        System.out.printf("%s %d\n", node.data, searchCountEach);
        searchCount += searchCountEach;
    }
    
    
    //calculates height of tree
    private int heightR(BTnode node, int level){
        int result = level;
        if (node != null){
            
            //returns the maximum height by recusing throught the left and
            //right of tree
            result = Math.max(heightR(node.left, level +1),
                heightR(node.right, level + 1)
                );
        }
        return result;
    }//heightR()
    
    
    //calculates the number of nodes in the tree
    private int sizeR(BTnode node){
        int result = 0;
        
        //recurses until node points to null
        if (node != null){
            
            //i is for the root adds left nodes and right nodes
            result = 1 + sizeR(node.left) + sizeR(node.right);
        }
        return result;
    }
    
    //calls searchCountR to recurse from the root
    public int searchCount(String word){
        return searchCountR(root, word);
    }
    
    
     private int searchCountR(BTnode node, String word) {

        int result = 1; //Default, it took 1 comparison, null check

        if (node != null) {

            if (node.data.compareToIgnoreCase(word) 
                    == word.compareToIgnoreCase(node.data)){

                result = 2; //it took 2 compares, null check and = check,
            }
            else{

                if (node.data.compareToIgnoreCase(word) > 
                        word.compareToIgnoreCase(node.data)){   //the third compare

                    return 3 + searchCountR(node.left, word);
                }
                else{

                    return 3 + searchCountR(node.right, word);
                }
            }
        }

           return result;

    }
    
     //calls recursive in order and calculates the average searches.
    public int averageSearch(){
        
        inOrderC(root);
        
        int nodeCount = size();
        
        int averageSearch = searchCount/nodeCount;
        
        return averageSearch;
    }
    public int size(){
        return sizeR(root);
    }
    public int height(){
        return heightR(root, -1);
    }
    
    //displays everything in tree and prints out the total word count.
    public void display(){
        inOrderS(root);
        System.out.println();
        System.out.println("WordCount:" + wordCount());
    }//display
}//BStree
