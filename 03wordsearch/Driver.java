import java.io.*;
import java.util.*;
public class Driver{
    public static void main(String[]args){
	try{
	    WordGrid a = new WordGrid(15, 15);
	    ArrayList<String> L = a.createList();
	    System.out.println("\nAdded these words:");
	    System.out.println(a.addWordList(L));
	    a.fillGrid();
	    System.out.println(a);
	}
	catch (Exception e){
	    e.printStackTrace();
	}
    }
}
