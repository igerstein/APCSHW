import java.io.*;
import java.util.*;
public class WordGrid{
    private char[][]data;

    /**Initialize the grid to the size specified and fill all of the positions
     *with underscores.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols) throws FileNotFoundException{
	data = new char[rows][cols];
	for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
		data[i][j] = '_';
	    }
	}
	File infile = new File("Words.txt");
	Scanner sc = new Scanner(infile);	
	ArrayList<String> L = new ArrayList<String>();
	while (sc.hasNext()){
	    L.add(sc.next());
	}
	Random r = new Random();
	for (int i = 0; i < L.size(); i++){
	    boolean added = false;
	    for (int j = 0; j < 1000 && !added; j++){
		int row = r.nextInt(data.length);
		int col = r.nextInt(data[row].length);
		for (int k = 0; !added && k < 20; k++){
		    int dx = r.nextInt(3) - 1;
		    int dy = r.nextInt(3) - 1;
		    if (addWord(L.get(i), row, col, dx, dy)){
			addWord(L.get(i), row, col, dx, dy);
			added = true;
		    }
		}
	    }
	}
    }

    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for (int i = 0; i < data.length; i++){
	    for (int j = 0; j < data[i].length; j++){
		data[i][j] = ' ';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String ans = "";
	for (int i = 0; i < data.length; i++){
	    for (int j = 0; j < data[i].length; j++){
		ans += data[i][j];
		if (j < data[i].length - 1){
		    ans += " ";
		}
	    }
	    if (i < data.length - 1){
		ans += "\n";
	    }
	}
	return ans;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *It must fit on the WordGrid, and must have a corresponding letter to match any letters that it overlaps.
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@param dx is an integer from -1 to 1 determining the vertical direction of the word.
     *@param dy is an integer from -1 to 1 determining the horizontal direction of the word. 
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWord(String word, int row, int col, int dx, int dy){
	if (checkWord(word, row, col, dx, dy)){
	    for (int i = 0; i < word.length(); i++){
		data[row][col] = word.charAt(i);
		row += dx;
		col += dy;
	    }
	    return true;
	}else{
	    return false;
	}
    }

    /**Checks if a word can be added to the WordGrid given the parameters of addWord.
     *@return true when the word can be added, and false otherwise.
     */
    public boolean checkWord(String word, int row, int col, int dx, int dy){
	if (dx == 0 && dy == 0 || row + dx * word.length() < 0 || row + dx * word.length() > data.length || col + dy * word.length() < 0 || col + dy * word.length() > data[row].length){
	    return false;
	}else{
	    for (int i = 0; i < word.length(); i++){
		if (data[row][col] != '_' && data[row][col] != word.charAt(i)){
		    return false;
		}
		row += dx;
		col += dy;
	    }
	}
	return true;
    }

    /**Reverses the order of the given string.
     */
    public static String reverse(String str){
	String ans = "";
	for (int i = str.length() - 1; i >= 0; i--){
	    ans += str.charAt(i);
	}
	return ans;
    }

    /**Returns the maximum value in the 2d parameter array.
     */
    public static int max(int[][] ary){
	int max = ary[0][0];
	for (int i = 0; i < ary.length; i++){
	    for (int j = 0; j < ary[i].length; j++){
		if (ary[i][j] > max){
		    max = ary[i][j];
		}
	    }
	}
	return max;
    }
    
    /**Returns the sum of the elements in Row x of ary.
     */ 
    public static int rowSum(int[][] ary, int x){
	int sum = 0;
	for (int i = 0; i < ary[x].length; i++){
	    sum += ary[x][i];
	}
	return sum;
    }

    /**Checks if the array is square(i.e. every row has the same length as AR itself).
     */
    public static boolean isSquare(int[][] AR){
	for (int i = 0; i < AR.length; i++){
	    if (AR.length != AR[i].length){
		return false;
	    }
	}
	return true;
    }

    /**Calculates the row sum for every row and returns each of the values in an array. Index i of the return array contains the sum of elements in row i.
     */
    public static int[] allRowSums(int[][] AR){
	int[] sums = new int[AR.length];
	for (int i = 0; i < AR.length; i++){
	    sums[i] = rowSum(AR, i);
	}
	return sums;
    }
    
    /**Returns the sum of the elements in Column x of AR.
     */
    public static int columnSum(int[][] AR, int x){
	int sum = 0;
	for (int i = 0; i < AR.length; i++){
	    if (x < AR[i].length){
		sum += AR[i][x];
	    }
	}
	return sum;
    }

    /**Checks if the array is row-magic (every row has the same row sum).
     */
    public static boolean isRowMagic(int[][] AR){
	for (int i = 0; i < AR.length; i++){
	    if (rowSum(AR, i) != rowSum(AR, 0)){
		return false;
	    }
	}
	return true;
    }

    /**Checks if the array is column-magic (every column has the same column sum).
     */
    public static boolean isColumnMagic(int[][] AR){
	boolean isEqual = true;
	for (int i = 0; i < AR.length; i++){
	    if (AR[i].length != AR[0].length){
		isEqual = false;
	    }
	}
	if (isEqual){
	    for (int i = 0; i < AR[0].length; i++){
		if (columnSum(AR, i) != columnSum(AR, 0)){
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }

    public static void main(String[]args) throws FileNotFoundException{
	WordGrid a = new WordGrid(15, 15);
	System.out.println(a);
    }
}


