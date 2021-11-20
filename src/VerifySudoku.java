//Check if the whole Sudoku is Valid 
public class VerifySudoku {
	int mat[][];
	int order;
	int SRN;
	boolean CheckValidityOfSudoku(int mat[][],int order)
	{
		this.order=order;
		SRN=(int)Math.sqrt(order);
		this.mat=new int[order][order];
		for(int i=0;i<order;i++)
		{
			for(int j=0;j<order;j++)
			this.mat[i][j]=mat[i][j];
		}
		
		for(int i=0;i<order;i++)
		{
			for(int j=0;j<order;j++)
			{
				if((unUsedInRow(i,this.mat[i][j]) && unUsedInCol(j,this.mat[i][j]) && unUsedInBox(i-i%SRN,j-j%SRN,this.mat[i][j])) == false)
					return false;
			}
		}
		return true;	
	}
	boolean unUsedInBox(int rowStart, int colStart, int num)
    {
		if(num>=0 && num<=9)
		{
			if(num!=0)
			{
				for (int i = 0; i<SRN; i++)
					for (int j = 0; j<SRN; j++)
						if (mat[rowStart+i][colStart+j]==num)
							return false;
			}
        return true;
		}
		else 
			return false;
    }
	boolean unUsedInRow(int i,int num)
    {
		if(num>=0 && num<=9)
		{
			if(num!=0)
			{
				for (int j = 0; j<order; j++)
					if (mat[i][j] == num)
						return false;
			}
        return true;
		}
		else 
			return false;
    }
	boolean unUsedInCol(int j,int num)
    {
		if(num==0)
			return true;
        for (int i = 0; i<order; i++)
            if (mat[i][j] == num)
                return false;
        return true;
    }

}
