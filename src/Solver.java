import java.util.*;
public class Solver extends VerifySudoku
{
	public boolean solveSudoku(int[][] mat,int order)
	{
		int row=-1;
		int col=-1;
		boolean hasNoEmptyCell=true;
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
		if(hasNoEmptyCell)
			return true;  //
		for(int i=1;i<=order;i++)
		{
			if(CheckValidityOfSudoku(mat,order,row,col,i))
			{
				mat[row][col]=i;
				if(solveSudoku(mat,order))
				{
					return true;
				}
				else
				{
					mat[row][col]=0;
				}
			}
		}
		return false;
		}
}