import java.util.Arrays;
public class SuperArray{
    String[] data;
    int currentLength = 0;
    public SuperArray(){
	data = new String[10];
    }
    public SuperArray(int size){
	data = new String[size];
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
    public void add(String e){
	if (currentLength == data.length){
	    resize(data.length * 2);
	}
	data[currentLength] = e;
	currentLength++;
    }
    public void add(int index, String o){
	if (index >= 0 && index <= currentLength){
	    if (currentLength == data.length){
		resize(data.length * 2);
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
	String[] newData = new String[newCapacity];
	for (int i = 0; i < currentLength && i < newData.length; i++){
	    newData[i] = data[i];
	}
	if (newData.length < currentLength){
	    currentLength = newData.length;
	}
	data = newData;
    }
    public void clear(){
	data = new String[data.length];
	currentLength = 0;
    }
    public String get(int index){
	if (index >= 0 && index < currentLength){
	    return data[index];
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public String set(int index, String o){
	if (index >= 0 && index < currentLength){
	    String replaced = data[index];
	    data[index] = o;
	    return replaced;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public String remove(int index){
	if (index >= 0 && index < currentLength){
	    String removed = data[index];
	    for (int i = index; i < currentLength - 1; i++){
		data[i] = data[i + 1];
	    }
	    if (currentLength < data.length / 4){
		resize(data.length / 2);
	    }else{
		data[currentLength - 1] = null;
		currentLength--;
	    }
	    return removed;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public void insertionSort(){
	for (int i = 1; i < currentLength; i++){
	    String current = data[i];
	    int j = 0;
	    while (j < i && current.compareTo(data[j]) > 0){
		j++;
	    }
	    for (int k = i; k > j; k--){
		data[k] = data[k - 1];
	    }
	    data[j] = current;
	}
    }	
    public void badInsertionSort(){
        OrderedSuperArray c = new OrderedSuperArray();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }
    public int find(String target){
	for (int i = 0; i < currentLength; i++){
	    if (data[i].equals(target)){
		return i;
	    }
	}
	return -1;
    }
    public void selectionSort(){
	for (int i = 0; i < currentLength; i++){
	    String lowest = data[i];
	    int swapIndex = i;
	    for (int j = i; j < currentLength; j++){
		if (data[j].compareTo(lowest) < 0){
		    lowest = data[j];
		    swapIndex = j;
		}
	    }
	    data[swapIndex] = data[i];
	    data[i] = lowest;
	}
    }
}
