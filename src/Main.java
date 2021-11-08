//Make a menu type in main method.
import java.io.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Yo mate, Welcome to Sudoku. This will be a fun challenge for you. Ready for some action?");
		System.out.println("Press 1 to begin a new game. Press any other key to quit!");
		try {
			int i=System.in.read();
			if(i==49)
			{
			int N = 9, K = 50; //K decides the level of difficulty
	        Generator sudoku = new Generator(N, K);
	        sudoku.fillValues();
			}
			else {
				System.out.println("Adios Amigo");
				System.exit(0);
			}
			
		}
		catch(IOException e)
		{
			System.out.println("Error reading from user.");
		}
        //sudoku.printSudoku();	
	}

}