public class SuperArray{
    private Object[] data;
    private int currentLength = 0;
    public static void main(String[]args){
	SuperArray L = new SuperArray(3);
	System.out.println(L);
	L.add(new Integer(1));
	L.add(new Integer(2));
	L.add(0, new Integer(3));
    	System.out.println(L);
	System.out.println(L.get(2));
	L.set(0, new Integer(5));
	System.out.println(L);
	L.remove(0);
	System.out.println(L);
    }
    public SuperArray(){
	data = new Object[10];
    }
    public SuperArray(int size){
	data = new Object[size];
    }
    public String toString(){
	String ans = "[";
	for (int i = 0; i < data.length; i++){
	    ans += data[i];
	    if (i < data.length - 1){
		ans += " ";
	    }
	}
        ans += "]";
	return ans;
    }
    public void add(Object e){
	if (currentLength == data.length){
	    resize(data.length + 1);
	}
	data[currentLength] = e;
	currentLength++;
    }
    public void add(int index, Object o){
	if (index >= 0 && index < currentLength){
	    if (currentLength == data.length){
		resize(data.length + 1);
	    }
	    for (int i = currentLength; i > index; i--){
		data[i] = data[i - 1];
	    }
	    data[index] = o;
	    currentLength++;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public int size(){
	return currentLength;
    }
    public void resize(int newCapacity){
	Object[] newData = new Object[newCapacity];
	for (int i = 0; i < currentLength && i < newData.length; i++){
	    newData[i] = data[i];
	}
	if (newData.length < currentLength){
	    currentLength = newData.length;
	}
	data = newData;
    }
    public void clear(){
	data = new Object[data.length];
	currentLength = 0;
    }
    public Object get(int index){
	if (index >= 0 && index < currentLength){
	    return data[index];
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public Object set(int index, Object o){
	if (index >= 0 && index < currentLength){
	    Object replaced = data[index];
	    data[index] = o;
	    return replaced;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public Object remove(int index){
	if (index >= 0 && index < currentLength){
	    Object removed = data[index];
	    for (int i = index; i < currentLength - 1; i++){
		data[i] = data[i + 1];
	    }
	    if (currentLength == data.length){
		resize(data.length - 1);
	    }else{
		data[currentLength - 1] = null;
		currentLength--;
	    }
	    return removed;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
}
