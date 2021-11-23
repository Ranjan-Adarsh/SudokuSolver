
public class Solver extends VerifySudoku
{
	int counter=0;
	boolean hasNoEmptyCell=true;
	int qmat[][];
	Solver()
	{
		qmat=new int[9][9];
	}
	public void solveSudoku(int[][] mat,int order)
	{
		int row=-1;
		int col=-1;
		hasNoEmptyCell=true;
		for(int i=0;i<order;i++)
		{
			for(int j=0;j<order;j++)
			{
				if(mat[i][j]==0)
				{
					hasNoEmptyCell=false;
					row=i;
					col=j;
					break;
					}
				}
			if(!hasNoEmptyCell)
				break;
			}
		if(hasNoEmptyCell)  //This is the condition from where the recursion starts returning.
		{
			counter+=1;
			for(int i=0;i<order;i++)
			{
				for(int j=0;j<order;j++)
					qmat[i][j]=mat[i][j];
			}
			return;
		}
		for(int i=1;i<=order;i++)
		{
			if(CheckValidityOfSudoku(mat,order,row,col,i))
			{
				mat[row][col]=i;
				solveSudoku(mat,order);
				  //This will be executed only when the recursion starts returning 
				mat[row][col]=0;
			}
		}
		return;
		}
}