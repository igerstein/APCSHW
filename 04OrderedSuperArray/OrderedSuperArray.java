import java.util.*;
public class OrderedSuperArray extends SuperArray{
    public static void main(String[]args){
	OrderedSuperArray a = new OrderedSuperArray(3);
	a.add("b");
	a.add("a");
	a.add("c");
	a.add("e");
	a.add("d");
	System.out.println(a);
	System.out.println(a.find("a"));
	System.out.println(a.find("b"));
	System.out.println(a.find("c"));
	System.out.println(a.find("d"));
	System.out.println(a.find("e"));
    }
    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int size){
	super(size);
    }
    public void add(String e){
	int index = 0;
	while (index < currentLength && data[index].compareTo(e) < 0){
	    index++;
	}
	super.add(index, e);
    }
    public void add(int index, String e){
	add(e);
    }
    public String set(int index, String e){
	if (index >= 0 && index < currentLength){
	    String replaced = remove(index);
	    add(e);
	    return replaced;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public int find(String target){
	return find(Arrays.copyOfRange(data, 0, currentLength), target, 0, Arrays.copyOfRange(data, 0, currentLength).length - 1);
    }
    public int find(String[] data, String target, int low, int high){
	int middle = (low + high) / 2;
	if (low > high){
	    return -1;
	}else if (data[middle].equals(target)){
	    return middle;
	}else if (data[middle].compareTo(target) < 0){
	    return find(data, target, middle + 1, high);
	}else{
	    return find(data, target, low, middle - 1);
	}
    }
}
