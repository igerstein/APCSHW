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
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
     public boolean addWordHorizontal(String word,int row, int col){
	 boolean added = word.length() <= data[row].length - col;
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
     }

    //vertical + diagonal should be implemented as well.
    public static void main(String[]args){
	WordGrid a = new WordGrid(6, 6);
	a.addWordHorizontal("test", 3, 1);
	System.out.println(a);
    }
}


