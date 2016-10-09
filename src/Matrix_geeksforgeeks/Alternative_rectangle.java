package Matrix_geeksforgeeks;//http://www.geeksforgeeks.org/create-a-matrix-with-alternating-rectangles-of-0-and-x/

public class Alternative_rectangle {

	public static void main(String[] args) 
	{
		int row=5;
		int col=6;
		char[][] res=form_alternate_rect(row,col);
		for(int i=0;i<res.length;i++)
		System.out.println(res[i]);//(Arrays.deepToString(res). This will print 2D array in one go, without changing line
	}
	static char[][] form_alternate_rect(int row,int col)
	{
		char[][] res=new char[row][col];
		int start_row=0,start_col=0;
		int end_row=row-1,end_col=col-1;
		char c='X';
		while(end_row>=start_row&&end_col>=start_col)
		{
			fill(res,start_row,start_col,end_row,end_col,c);
			start_row++;end_row--;
			start_col++;end_col--;
			if(c=='X')
				c='0';
			else
				c='X';
		}
		return res;
	}
	static void fill(char res[][], int start_row,int start_col,int end_row,int end_col, char c)
	{
		for(int i=start_row;i<=end_row;i++)
		{
			res[i][start_col]=c;
			res[i][end_col]=c;
		}
		for(int i=start_col;i<=end_col;i++)
		{
			res[start_row][i]=c;
			res[end_row][i]=c;
		}
	}
}
