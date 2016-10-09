package Matrix_geeksforgeeks;/*
 * http://www.geeksforgeeks.org/minimum-positive-points-to-reach-destination/
 */
import java.util.ArrayList;
public class Minimum_Points {

	public static void main(String[] args) {
		int  points[][] = { {-2, -3,   3}, 
                {-5, -10,  1}, 
                {10,  30, -5} 
              };
		ArrayList<Integer> res=new ArrayList<Integer>();
		getSum(res,points,0,0,0);
		System.out.println(res.get(0));
	}
	public static void getSum(ArrayList<Integer> res,int[][] mat,int x,int y,int sum)
	{
		if(x>=mat.length||y>=mat[0].length)
			return;
		sum=sum+mat[x][y];
		if(x==mat.length-1&&y==mat[0].length-1)
		{
			int val=Math.abs(sum)+1;
			if(res.isEmpty())
				res.add(0,val);
			else if(val<res.get(0))
				res.add(0,val);
			return;
		}
		getSum(res,mat,x,y+1,sum);
		getSum(res,mat,x+1,y,sum);
	}

}
