//Make a menu type in main method.
//import java.io.*;
import java.util.*;
public class Main {
	public static final String ANSI_RESET="\u001B[0m";
	 public static final String ANSI_YELLOW = "\u001B[33m";
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N,K;
		String i;
		while(true)
		{	
			System.out.println("\nYo mate, Welcome to Sudoku. This will be a fun challenge for you. Ready for some action?");
			System.out.println("Press 1 to begin a new game. Press any other key to quit!");
			i=sc.nextLine();
			i=i.trim();
			if(i.equals("1"))
			{
				System.out.println("Kindly Select the difficulty level!");
				System.out.println("\tEasy\t\t1\n\tMedium\t\t2\n\tDifficult\t3\n\tInsane\t\t4");
				K=sc.nextInt();
				switch(K) {
					case 1:
						K=20;
						break;
					case 2:
						K=30;
						break;
					case 3:
						K=40;
						break;
					case 4:
						K=50;
					default:
						K=25;
						break;
				}	
				N = 9; //N decides the NXN Sudoku
				Generator sudoku=new Generator(N,K);
				sudoku.choice();
				//sc.close();
				}
			else {
				sc.close();
				System.out.println("Adios Amigo");
				System.exit(0);
			}
			
		}
        //sudoku.printSudoku();
	}

}