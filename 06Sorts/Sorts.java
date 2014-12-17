import java.util.*;
public class Sorts{
    public static int[] bubble(int[]c){
	boolean sorted = false;
	for (int i = 0; i < c.length && !sorted; i++){
	    sorted = true;
	    for (int j = 0; j < c.length - i - 1; j++){
		if (c[j] > c[j + 1]){
		    int a = c[j];
		    c[j] = c[j + 1];
		    c[j + 1] = a;
		    sorted = false;
		}
	    }
	}
	return c;
    }
    public static int[] insertion(int[]c){
	for (int i = 1; i < c.length; i++){
	    int current = c[i];
	    int j;
	    for (j = i - 1; j > -1 && c[j] > current; j--){
		c[j + 1] = c[j];
	    }
	    c[j + 1] = current;
	}
	return c;
    }	
    public static int[] selection(int[]c){
	for (int i = 0; i < c.length; i++){
	    int lowest = c[i];
	    int swapIndex = i;
	    for (int j = i; j < c.length; j++){
		if (c[j] < lowest){
		    lowest = c[j];
		    swapIndex = j;
		}
	    }
	    c[swapIndex] = c[i];
	    c[i] = lowest;
	}
	return c;
    }
}
