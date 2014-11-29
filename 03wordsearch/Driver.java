import java.io.*;
import java.util.*;
public class Driver{
    public static void main(String[]args){
	try{
	    int rows = Integer.parseInt(args[0]);
	    int cols = Integer.parseInt(args[1]);
	    int randomSeed = 0;
	    boolean answers = false;
	    if (args.length > 2){
		randomSeed = Integer.parseInt(args[2]);
		if (args.length > 3 && args[3].equals("1")){
		    answers = true;
		}	
	    }
	    WordGrid w = new WordGrid(rows, cols);
	    if (args.length > 2 && randomSeed != 0){
		w.setSeed(randomSeed);
	    }
	    w.loadWordsFromFile("Words.txt", !answers);
	    System.out.println(w);
	}
	catch (Exception e){
	    e.printStackTrace();
	}
    }
}
