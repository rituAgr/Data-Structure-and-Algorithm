package Matrix_geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 */
public class Search_InSortedArray {

	public static void main(String[] args) {
		int[][] matrix={ {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		int num=34;
		boolean found=IsPresent(matrix,num);
		System.out.println(found);
	}
	static boolean IsPresent(int[][] matrix,int num)
	{
	int row=matrix.length;
	int col=matrix[0].length;
	if(row==0&&col==0)
		return false;
	if(num<matrix[0][0]||num>matrix[row-1][col-1])
		return false;
	int row_pos=0,col_pos=col-1;
	while(row_pos<row&&col_pos>=0)
	{
		int k=matrix[row_pos][col_pos];
		if(k==num)
			return true;
		if(num>k)
			row_pos++;
		else
			col_pos--;		
	}
	return false;
	}
}
