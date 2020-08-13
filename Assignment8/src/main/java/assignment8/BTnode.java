/*
 /*Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 8
 * node class to be used in BST.
 */
package assignment8;


public class BTnode {
    String data = "";//main data
    int count;//count of number of words
    BTnode left, right;
    
    BTnode(String word, BTnode l, BTnode r){
        data = word;
        left = l;
        right = r;
        count = 1;
    }
}
