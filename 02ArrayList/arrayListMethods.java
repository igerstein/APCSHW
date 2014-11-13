import java.util.*;
public class Collapse{
    ArrayList<Integer> L = new ArrayList<Integer>();
    public static void main(String[]args){
	Collapse a = new Collapse();
        a.L.add(1);
	a.L.add(1);
	a.L.add(3);
	a.L.add(4);
	a.L.add(3);
	a.L.add(3);
	System.out.println(a.getL());
        a.collapseDuplicates(a.getL());
	System.out.println(a.getL());
    }
    public void collapseDuplicates(ArrayList<Integer> L){
	for (int i = 0; i < L.size(); i++){
	    if (i > 0 && L.get(i) == L.get(i - 1)){
		L.remove(i);
	    }
	}
    }
    public ArrayList<Integer> getL(){
	return L;
    }
}
