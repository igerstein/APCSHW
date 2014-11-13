import java.util.*;
public class arrayListMethods{
    public static void main(String[]args){
	ArrayList<Integer> L = new ArrayList<Integer>();
	L.add(1);
	L.add(1);
	L.add(3);
	L.add(4);
	L.add(3);
	L.add(3);
	System.out.println(L);
        arrayListMethods.collapseDuplicates(L);
	System.out.println(L);
    }
    public static void collapseDuplicates(ArrayList<Integer> L){
	for (int i = 0; i < L.size(); i++){
	    if (i > 0 && L.get(i) == L.get(i - 1)){
		L.remove(i);
	    }
	}
    }
}
