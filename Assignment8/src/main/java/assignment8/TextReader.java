/*
 * Theophrastus Gamboni-Diehl
 * CS1450-2
 * Assignment 7
 * Reads individual strings from a text file.
 */
package assignment8;

import java.util.*;
import java.io.*;

public class TextReader {


private Scanner read;
private String currline;

public TextReader(String filename){
 try{
 currline = "";
 read = new Scanner(new File(filename));
    }//try
 catch (Exception ex)
        {   //Gets here if any errors occur; we will print the error stuff
            System.out.println("File does not exist error: "+ex.toString());
 //           ex.printStackTrace();
        }//catch

    }//TextReader
    
    //accepts only letters and - and \
    private boolean isLetter(char ch) {
        return ((ch >= 'A')&&(ch <= 'Z') ||
                (ch >= 'a')&&(ch <= 'z') ||
                (ch == '-') || (ch == '\'')  //Allow dash and apostrophe
                );  }
    
    
    private String removeNextWord(String s) {
        //Returns the string with the first 'word' removed
        //First,  pull all non-letters off front
        while ((s.length()>0) && (isLetter(s.charAt(0))== false))
          s = s.substring(1);
        //Now, pull all letters off front
        while ((s.length()>0) && (isLetter(s.charAt(0))== true))
          s = s.substring(1);
        //Finally remove all non-letters off front
        while ((s.length()>0) && (isLetter(s.charAt(0))== false))
          s = s.substring(1);

        return s;//Return the resulting string
    }
    
    
    private String getNextWord(String s) {
        //Returns first 'word' of the string
        //First,  pull all non-letters off front
        String word="";
        while ((s.length()>0) && (isLetter(s.charAt(0))== false))
          s = s.substring(1);
        //Now, keep all letters as we pull them off the front
        while ((s.length()>0) && (isLetter(s.charAt(0))== true))
        {   word = word + s.charAt(0);//build up the word
            s = s.substring(1);//remove letters from string input
        }
        return word;//Return the resulting word string
    }

    
   public String GetWord(){
     // throws FileNotFoundException  //required throw line
    {   String nextword;

        while ((currline != null)&&(currline.length()== 0)){
            if (read.hasNext())
              currline =  read.nextLine().trim();
            else
              currline = null;
        }
        if (currline != null)
        {    nextword = getNextWord(currline);   //get word from front of line
             currline = removeNextWord(currline).trim();  //update the line w/o word
        }
        else
        {
             nextword = null;
        }
       return nextword;
    }
    }
}
 



