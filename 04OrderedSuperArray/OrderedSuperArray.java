public class OrderedSuperArray extends SuperArray{
    public static void main(String[]args){
	OrderedSuperArray a = new OrderedSuperArray(3);
	a.add("b");
	a.add("c");
	a.add("a");
	System.out.println(a);
    }
    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int size){
	super(size);
    }
    public void add(String e){
	if (currentLength == data.length){
	    resize(data.length * 2);
	}
	int index = 0;
	while (data[index] != null && data[index].compareTo(e) < 0){
	    index++;
	}
	for (int i = currentLength; i > index; i--){
	    data[i] = data[i - 1];
	}
	data[index] = e;
	currentLength++;
    }
    public void add(int index, String e){
	add(e);
    }
}
