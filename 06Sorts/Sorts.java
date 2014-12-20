import java.util.*;
import java.lang.*;
public class Sorts{
    public static String name(){
	return "Gerstein, Isaac";
    }
    public static int period(){
	return 7;
    }
    public static void bubble(int[]c){
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
    }
    public static void insertion(int[]c){
	for (int i = 1; i < c.length; i++){
	    int current = c[i];
	    int j;
	    for (j = i - 1; j > -1 && c[j] > current; j--){
		c[j + 1] = c[j];
	    }
	    c[j + 1] = current;
	}
    }	
    public static void selection(int[]c){
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
    }
    public static void radix(int[]c){
	ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(10);
	for (int i = 0; i < 10; i++){
	    buckets.add(new ArrayList<Integer>());
	}
	boolean more = true;
	for(int i = 0; more; i++){
	    int digit = (int)Math.pow((double)10, (double)i);
	    more = false;
	    for (int j = 0; j < c.length; j++){
		buckets.get((c[j] / digit) % 10).add(c[j]);
		if (c[j] >= digit){
		    more = true;
		}
	    }
	    int count = 0;
	    for (int j = 0; j < buckets.size(); j++){
		for (int k = 0; k < buckets.get(j).size(); k++){
		    c[count] = buckets.get(j).get(k);
		    count ++;
		}
	    }
	    for (int j = 0; j < buckets.size(); j++){
		buckets.get(j).clear();
	    }
	}
    }
}
