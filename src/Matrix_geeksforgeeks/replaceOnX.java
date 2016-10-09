package Matrix_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/
 */
public class replaceOnX {

	public static void main(String[] args) {
		char mat[][]={{'X', 'X', 'X', 'X'},
        {'X', 'O', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'O', 'X', 'X'},
        {'X', 'X', 'O', 'O'},
       };
		replace(mat);
		for(int i=0;i<mat.length;i++)
			System.out.println(mat[i]);
	}
	static void replace(char[][] mat)
	{
		int row=mat.length;
		int col=mat[0].length;
		for(int i=1;i<row-1;i++)
		{
			for(int j=1;j<col-1;j++)
			{
				if(mat[i][j]=='O')
					if(replaceUtil(i,j,mat))
						mat[i][j]='X';
			}
		}
	}
	static boolean replaceUtil(int i, int j, char[][] mat)
	{
		for(int x=i+1;x<mat.length;x++)
		{
			if(mat[x][j]=='X')
				break;
			if(x==mat.length-1&&mat[x][j]=='O')
				return false;
		}
		for(int x=i-1;x>=0;x--)
		{
			if(mat[x][j]=='X')
				break;
			if(x==0&&mat[x][j]=='O')
				return false;
		}
		for(int y=j+1;y<mat[0].length;y++)
		{
			if(mat[i][y]=='X')
				break;
			if(y==mat[0].length-1&&mat[i][y]=='O')
				return false;
		}
		for(int y=j-1;y>=0;y--)
		{
			if(mat[i][y]=='X')
				break;
			if(y==0&&mat[i][y]=='O')
				return false;
		}
		return true;
	}
}
