public class Sorts{
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
    public static int[] insertion(int[]c){
	for (int i = 1; i < c.length; i++){
	    int current = c[i];
	    int j = 0;
	    while (j < i && current > c[j]){
		j++;
	    }
	    for (int k = i; k > j; k--){
		c[k] = c[k - 1];
	    }
	    c[j] = current;
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
