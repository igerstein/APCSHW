import java.util.*;
public class Sorts{
    public static void main(String[]args){
	int[] c = {3, 1, 4, 0, 2, 5};
	Sorts.bubble(c);
	System.out.println(Arrays.toString(c));
    }
    public static int[] bubble(int[]c){
	for (int i = 0; i < c.length; i++){
	    for (int j = 0; j < c.length - i - 1; j++){
		if (c[j] > c[j + 1]){
		    int a = c[j];
		    c[j] = c[j + 1];
		    c[j + 1] = a;
		}
	    }
	}
	return c;
    }
}
