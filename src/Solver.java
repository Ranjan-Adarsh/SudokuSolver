//The problem matrix and what user is entering should appear side by side or up and down.
import java.util.*;
import java.io.*;
public class Solver extends Generator{
	int amat[][];
	public Solver(int N, int K)  //int mat[][],int qmat[][], int N
	{	
		super(N,K);
		amat=new int[N][N];
	}
	
	public void solverMainMenu()
	{
		System.out.println("\n\n\t\t\tThe rules of the game are: ");
		System.out.println("\t\tOnly the numbers from 1 through to 9 can be used.\r\n"
				+ "\t\tEach 3X3 can only contain each number from 1 to 9 once.\r\n"
				+ "\t\tEach vertical column can only contain from 1 to 9 once.\r\n"
				+ "\t\tEach horizontal row can only contain from 1 to 9 once.\r\n");
		
	}
	public void menu()
	{
		System.out.println("\n\tEnter 'Rowindex Columnindex Value' to fill/edit the particular cell \n\tOR R to reset your matrix \n\tOR A to display the answer \n\tOR Q to go back to main menu. ");
		
	}
	
	public boolean isValueValid(int num)
	{
		if(num>=1 && num<=super.N)
		{
			//System.out.println("Error here 21");
			return true;
		}
		return false;
	}
	public boolean isInputValid(int r, int c, int v)   //This checks whether the user has entered a valid input in a valid row and column.
	{
		if(isValueValid(r) && isValueValid(c) && isValueValid(v))
		{
			if(this.mat[r-1][c-1]==0)
				return true;
			else
				System.out.println("\t\tNo, You can't modify values given in challenge itself!");
			}
		return false;
	}
	
	public void fillEdit(int r, int c, int v) throws IOException,InterruptedException
	{
		if(isInputValid(r,c,v)==true)
		{
			amat[r-1][c-1]=v;
			System.out.println(amat[r-1][c-1]);
			clearScreen();
			new Grid(mat,N);
			new Grid(amat,N);
		}
		else
			System.out.println("Please enter a valid input. 34");
		
	}
	public static void clearScreen () throws IOException,InterruptedException
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
	public void driver() //This is the driver code for Solver.
	{
		Scanner sc=new Scanner(System.in);
		amat=super.cloneArray(mat);
		solverMainMenu();	
		String s="";
		int c,p;
		int inputStorage[]=new int[3];
		while(true)
		{
			try {
				menu();
				s=sc.nextLine();
				p=0;
				StringTokenizer st=new StringTokenizer(s);
				c=st.countTokens();
				if(c==3)
					{
						while(st.hasMoreTokens())
							{
								inputStorage[p]=Integer.parseInt(st.nextToken());
	
								System.out.println(inputStorage[p]);
								p++;
							}
						fillEdit(inputStorage[0],inputStorage[1],inputStorage[2]);
				
					}
				else if(c==1)
				{
					if(s.equals("A"))
					{
						new Grid(qmat,N);
					}
					else if(s.equals("Q"))
					{
						sc.close();
						return;
					}
					else if(s.equals("R"))
					{
						amat=super.cloneArray(mat);
						new Grid(amat,N);
					}
					else {
						System.out.println("Please enter a valid input. 65");
						}
					}
				}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Please enter a valid Input. 72");
			}
			
		}
		
	}		
}


