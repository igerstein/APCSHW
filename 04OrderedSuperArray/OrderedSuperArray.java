import java.util.*;
public class OrderedSuperArray extends SuperArray{
    public static void main(String[]args){
	OrderedSuperArray a = new OrderedSuperArray(3);
	a.add("b");
	a.add("a");
	a.add("c");
	a.add("e");
	a.add("d");
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
	String[] dataCopy = new String[data.length];
	int firstCurrentLength = currentLength;
	for (int i = 0; i < data.length; i++){
	    dataCopy[i] = data[i];
	}
	int index = -1;
	int added = 0;
	while (currentLength > 0){
	    int i = currentLength / 2;
	    if (data[i].equals(target)){
	        index = i;
		break;
	    }else if (data[i].compareTo(target) < 0){
		for (int j = 0; j <= i; j++){
		    remove(0);
		    added++;
		}
	    }else if (data[i].compareTo(target) > 0){
		int num = currentLength;
		for (int j = i; j < num; j++){
		    remove(i);
		}
	    }
	}
	for (int i = 0; i < dataCopy.length; i++){
	    data[i] = dataCopy[i];
	}
	currentLength = firstCurrentLength;
	if (index != -1){
	    index += added;
	}
	return index;
    }
}
