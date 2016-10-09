package Matrix_geeksforgeeks;

public class Diagonal_print {

	public static void main(String[] args) {
		int[][] M={{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
				{17, 18, 19, 20},
		};
		print_diagonaly(M);
	}
	static void print_diagonaly(int[][] M)
	{
		int row=M.length;
		int col=M[0].length;
		int lines=row+col-1;
		int pos=0,dir=0;
		int r=0,c=0;
		for(int i=0;i<lines;i++)
		{
			switch (dir)
			{
			case 0:
				c=0;r=pos;
				while(r>=0&&c<col)
				{
					System.out.print(" "+M[r][c]);
					r--;c++;
				}
				System.out.println();
				pos++;
				if(pos==row)
					dir=1;
				break;
			case 1:
				 r=row-1;c=row-pos+1;
				while(r>=0&&c<col)
				{
					System.out.print(" "+M[r][c]);
					r--;c++;
				}
				System.out.println();
				pos--;
				break;
			}
		}
	}

}
