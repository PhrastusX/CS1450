/*
 /*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 9
 * Stores a txt file in BST and prints discription of tree.
 */
package assignment8;
import java.io.*;

public class Assignment8 {


    public static void main(String[] args)
     // throws FileNotFoundException  //required throw line
    {   // PUT PATH TO FILE HERE, USE Double \\ 
        TextReader read = new TextReader("/Users/theo/NetBeansProjects"
                + "/Assignment8/Speech.txt");
        
        BStree tree = new BStree();
        int count = 0;
        String nextword;
        nextword = read.GetWord();  //initial read
        while (nextword != null)
        {
            //puts next word into the tree
            tree.insert(nextword, true);
            
            //gets the next word
            nextword = read.GetWord();
            
        }//while
        
        
        //stores values (names explain)
        int averageSearch = tree.averageSearch();
        int height = tree.height();
        int searchCount = tree.returnSearchCount();
        int nodeCount = tree.size();
        
        //prints out a nicely formatted list of info about tree
        System.out.printf("The height of the tree is: %d\n"
                +"The total number of comparisons to search: %d\n"
                + "The total number of nodes in the tree is: %d\n"
                + "The Average Search makes %d comparisons\n",
                height,searchCount,nodeCount,averageSearch);
        
        
    }//main

}//class


