import java.util.*;
public class ArrayListMethods{
    public static void main(String[]args){
	ArrayList<Integer> L = new ArrayList<Integer>();
        L.add(1);
	L.add(1);
	L.add(3);
	L.add(4);
	L.add(3);
	L.add(3);
	System.out.println(L);
        ArrayListMethods.collapseDuplicates(L);
	System.out.println(L);
	ArrayList<Integer> L2 = new ArrayList<Integer>();
	for (int i = 0; i < 10; i++){
	    L2.add(i);
	}
	System.out.println(L2);
	ArrayListMethods.randomize(L2);
	System.out.println(L2);
	ArrayListMethods.randomize(L2);
	System.out.println(L2);
	ArrayListMethods.randomize(L2);
	System.out.println(L2);
    }
    public static void collapseDuplicates(ArrayList<Integer> L){
	for (int i = 0; i < L.size(); i++){
	    if (i > 0 && L.get(i) == L.get(i - 1)){
		L.remove(i);
	    }
	}
    }
    public static void randomize(ArrayList<Integer> L){
	Random r = new Random();
	for (int i = 0; i < L.size(); i++){
	    int current = L.get(i);
	    int otherIndex = r.nextInt(L.size() - i) + i;
	    L.set(i, L.get(otherIndex));
	    L.set(otherIndex, current);
	}
    }
}
