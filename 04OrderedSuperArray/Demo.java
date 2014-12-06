import java.util.*;
public class Demo{
    public static void main(String[]args){
	SuperArray a = new SuperArray();
	for (int i = 0; i < 100000; i++){
	    a.add(Integer.toString(i));
	}
	if (args[0].equals("select")){
	    a.resize(a.currentLength);
	    a.selectionSort();
	}
	if (args[0].equals("insert")){
	    a.resize(a.currentLength);
	    a.insertionSort();
	}
	if (args[0].equals("array")){
	    a.resize(a.currentLength);
	    a.arraySort();
	}
    }
}
