public class WordGrid{
    private char[][]data;

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
		data[i][j] = ' ';
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
     *The word is added from left to right, top to bottom, or top-left to bottom-right, depending on direction.
     *It must fit on the WordGrid, and must have a corresponding letter to match any letters that it overlaps.
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@param direction is an integer from 1 to 3, determining whether the word is added horizontally, vertically, or diagonally.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWord(String word, int row, int col, int direction){
	boolean canAddH = word.length() <= data[row].length - col;
	boolean canAddV = word.length() <= data.length - row;
	if (direction < 1 || direction > 3){
	    throw new IndexOutOfBoundsException();
	}else if (direction == 1){
	    boolean added = canAddH;
	    if (added){
		for (int i = col; i < col + word.length(); i++){
		    if (data[row][i] != ' ' && data[row][i] != word.charAt(i - col)){
			added = false;
		    }
		}
	    }
	    if (added){
		for (int i = col; i < col + word.length(); i++){
		    data[row][i] = word.charAt(i - col);
		}
	    }
	    return added;
	}else if (direction == 2){
	    boolean added = canAddV;
	    if (added){
		for (int i = row; i < row + word.length(); i++){
		    if (data[i][col] != ' ' && data[i][col] != word.charAt(i - row)){
			added = false;
		    }
		}
	    }
	    if (added){
		for (int i = row; i < row + word.length(); i++){
		    data[i][col] = word.charAt(i - row);
		}
	    }
	    return added;
	}else{
	    boolean added = canAddH && canAddV;
	    if (added){
		for (int i = col; i < col + word.length(); i++){
		    if (data[row - col + i][i] != ' ' && data[row - col + i][i] != word.charAt(i - col)){
			added = false;
		    }
		}
	    }
	    if (added){
		for (int i = col; i < col + word.length(); i++){
		    data[row - col + i][i] = word.charAt(i - col);
		}
	    }
	    return added;
	}
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

    public static void main(String[]args){
	WordGrid a = new WordGrid(6, 6);
	a.addWord("test", 1, 1, 1);
	a.addWord("test", 1, 4, 2);
	a.addWord("test", 1, 1, 3);
	System.out.println(a);
    }
}


