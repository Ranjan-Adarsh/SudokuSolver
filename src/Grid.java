//This will receive the Sudoku as an input and make a Sudoku like Grid Everytime.
//Better will be to replace 0 with dots in this.
//Fix the indentation such that it works for any grid.This doesn't works for two digit number cause they have discrepency.
public class Grid {
	private int mat[][];
	private int N;
	private int SRN;

	public Grid(int mat[][],int N) //Received the Grid and its size as an input.
	{
		this.mat=mat.clone();
		this.N=N;
		this.numFinder();
		this.printSudoku();
	}
	public void numFinder()
	{
		Double SRNd=Math.sqrt(N);
		SRN=SRNd.intValue();
	}
	public void dashInsertor()
	{
		for(int k=0;k<N+SRN;k++)
			System.out.print("__");
		System.out.print("_");
	}
	public void printSudoku()
    {
        for (int i = 0; i<N; i++)
        {
        	if(i%SRN==0)
        	{
        		dashInsertor();
        	}
        	System.out.println("\t");
            for (int j = 0; j<N; j++)
            {
            	if(j%SRN==0)
            		System.out.print("| ");
            	if(mat[i][j]==0)
            		System.out.print(". ");
            	else
            		System.out.print(mat[i][j] + " ");
            }
            System.out.println("|");
        }
        dashInsertor();
        //System.out.println();
        
    }

}
