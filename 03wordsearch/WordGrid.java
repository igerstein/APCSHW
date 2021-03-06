import java.io.*;
import java.util.*;
public class WordGrid{
    Random r;
    ArrayList<String> addedWords;
    private char[][]data;

    /**Initialize the grid to the size specified and fill all of the positions
     *with underscores.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows, int cols){
	r = new Random();
	addedWords = new ArrayList<String>();
	data = new char[rows][cols];
	for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
		data[i][j] = '_';
	    }
	}
    }

    /**Load words from a file into the WordGrid.
     *@param filename is the name of the file containing words.
     *@param fillRandomLetters is whether the WordGrid will be filled with random letters.
     */
    public void loadWordsFromFile(String filename, boolean fillRandomLetters) throws FileNotFoundException{
	File infile = new File(filename);
	Scanner sc = new Scanner(infile);
	ArrayList<String> L = new ArrayList<String>();
	while (sc.hasNext()){
	    L.add(sc.next());
	}
        addManyWordsToList(L);
	if (fillRandomLetters){
	    fillGrid();
	}
    }

    /**Add a list of words randomly to the WordGrid.
     *@param L is the list of words
     */
    public void addManyWordsToList(ArrayList<String> L){
	while (L.size() > 0){
	    int index = r.nextInt(L.size());
	    boolean added = false;
	    for (int i = 0; i < 1000 && !added; i++){
		int row = r.nextInt(data.length);
		int col = r.nextInt(data[row].length);
		for (int j = 0; !added && j < 20; j++){
		    int dx = r.nextInt(3) - 1;
		    int dy = r.nextInt(3) - 1;
		    if (addWord(L.get(index), row, col, dx, dy)){
			addWord(L.get(index), row, col, dx, dy);
			added = true;
			addedWords.add(L.get(index));
		    }
		}
	    }
	    L.remove(index);
	}
    }

    /**Returns a formatted string of text with several successfully added words per line.
     *@return the string.
     */
    public String wordsInPuzzle(){
	String ans = "";
	for (int i = 0; i < addedWords.size(); i++){
	    if (i % 4 == 0){
		ans += "\n";
	    }
	    for (int j = 0; j < 18 - addedWords.get(i).length(); j++){
		ans += " ";
	    }
	    ans += addedWords.get(i);
	}
	return ans;
    }

    /**Fill in the underscores with random characters.
     */
    public void fillGrid(){
	for (int i = 0; i < data.length; i++){
	    for (int j = 0; j < data[i].length; j++){
		if (data[i][j] == '_'){
		    data[i][j] = (char)(r.nextInt(26) + 'a');
		}
	    }
	}
    }

    /**Set the random seed of the WordGrid.
     */
    public void setSeed(long seed){
	r.setSeed(seed);
    }

    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for (int i = 0; i < data.length; i++){
	    for (int j = 0; j < data[i].length; j++){
		data[i][j] = '_';
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
}


