package Matrix_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/count-number-islands-every-island-separated-line/
 */
public class Num_of_island {
	public static void main(String[] args)
	{
		char[][] mat =  {{'O', 'O', 'O'},
	              {'X', 'X', 'O'},
	              {'X', 'X', 'O'},
	              {'O', 'O', 'X'},
	              {'O', 'O', 'X'},
	              {'X', 'X', 'O'}
	             };
		int island=find_island(mat);
		System.out.println(island);
	}
	static int find_island(char[][] mat)
	{
		int row=mat.length;
		int col=mat[0].length;
		int island=0;
		for(int x=0;x<row;x++)
			for(int y=0;y<col;y++)
			{
				if(mat[x][y]=='O'||((mat[x][y]=='X')&&(x>0)&&(mat[x-1][y])=='X'))
					continue;
				if(mat[x][y]=='X')
				{
					island++;
					y=find_ypos(mat,x,y);
				}
			}
		return island;
	}
	static int find_ypos(char mat[][], int x, int y)
	{
		for(int i=y;i<mat[0].length-1;i++)
			if(mat[x][i]=='X'&&mat[x][i+1]=='O')
				return i;
		return mat[0].length-1;
	
	}
}
