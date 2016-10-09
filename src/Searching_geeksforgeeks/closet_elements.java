package Searching_geeksforgeeks;

public class closet_elements {

	public static void main(String[] args) {
		int A[] = {1, 4, 10};
		int B[] = {2, 15, 20};
		int C[] = {10, 12};
		print_closet_elements(A,B,C);
	}
	static void print_closet_elements(int[] A,int[] B,int[] C)
	{
		int p=A.length, q=B.length, r=C.length;
		int i=0,j=0,k=0;
		int res_i=0,res_j=0,res_k=0;
		int diff=Integer.MAX_VALUE;

		while(i<p&&j<q&&k<r)
		{
			int max=Math.max(A[i], Math.max(B[j], C[k]));
			int min=Math.min(A[i], Math.min(B[j], C[k]));
			if(max-min<diff)
			{
				diff=max-min;
				res_i=i;res_j=j;res_k=k;
			}
			if(A[i]==min)
				i++;
			else if(B[j]==min)
				j++;
			else
				k++;
		}
		System.out.println("i= "+A[res_i]+" j= "+B[res_j]+" k= "+C[res_k]);
	}
}
