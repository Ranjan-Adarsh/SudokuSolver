//Make a menu type in main method.
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 9, K = 50; //K decides the level of difficulty
        Generator sudoku = new Generator(N, K);
        sudoku.fillValues();
        sudoku.printSudoku();	
	}

}