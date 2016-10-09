package Divide_Conquer.src;

/**
 ** Java Program to Implement Strassen Algorithm
 * See the link for codes http://www.sanfoundry.com/java-program-strassen-algorithm/
 * Refer this link for explanatory video https://www.youtube.com/watch?v=JQ3AgsGEnKM
 * By Master's Theorem Time complexity of above method is O(NLog7)
 * Constrint : The order of matrix should be of order of 2 like 2, 4 ,8,16;
 **/
public class Strassen_Algo_Matrices_multiply 
{
	public static void main(String args[])
	{
		int a[][]={{2,3,1,6},{4,0,0,2},{4,2,0,1},{0,3,5,2}};
		int b[][]={{3,0,4,3},{1,2,0,2},{0,3,1,4},{5,1,3,2}};
		int c[][]=multiply(a,b);
		System.out.println("The matrix A :");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		System.out.println("The matrix B :");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
				System.out.print(b[i][j]+" ");
			System.out.println();
		}
		System.out.println("The product of both matrix :");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
				System.out.print(c[i][j]+" ");
			System.out.println();
		}
	}
	static int[][] multiply(int a[][], int b[][])
	{
		int n=a.length;
		int result[][]=new int[n][n];
		if(n==1)
		{
			result[0][0]=a[0][0]*b[0][0];
			return result;
		}
		int a11[][]=new int[n/2][n/2];
		int a12[][]=new int[n/2][n/2];
		int a21[][]=new int[n/2][n/2];
		int a22[][]=new int[n/2][n/2];
		int b11[][]=new int[n/2][n/2];
		int b12[][]=new int[n/2][n/2];
		int b21[][]=new int[n/2][n/2];
		int b22[][]=new int[n/2][n/2];

		//spilting the bigger matrix a into smaller ones
		spilt(a,a11,0,0);
		spilt(a,a12,0,n/2);
		spilt(a,a21,n/2,0);
		spilt(a,a22,n/2,n/2);

		//spilting the bigger matrix b into smaller ones
		spilt(b,b11,0,0);
		spilt(b,b12,0,n/2);
		spilt(b,b21,n/2,0);
		spilt(b,b22,n/2,n/2);

		//calculating the 7 different parameters
		/** 
        M1 = (A11 + A22)(B11 + B22)
        M2 = (A21 + A22) B11
        M3 = A11 (B12 - B22)
        M4 = A22 (B21 - B11)
        M5 = (A11 + A12) B22
        M6 = (A21 - A11) (B11 + B12)
        M7 = (A12 - A22) (B21 + B22)
		 **/

		int [][] M1 = multiply(add(a11, a22), add(b11, b22));
		int [][] M2 = multiply(add(a21, a22), b11);
		int [][] M3 = multiply(a11, sub(b12, b22));
		int [][] M4 = multiply(a22, sub(b21, b11));
		int [][] M5 = multiply(add(a11, a12), b22);
		int [][] M6 = multiply(sub(a21, a11), add(b11, b12));
		int [][] M7 = multiply(sub(a12, a22), add(b21, b22));

		/**
      C11 = M1 + M4 - M5 + M7
      C12 = M3 + M5
      C21 = M2 + M4
      C22 = M1 - M2 + M3 + M6
		 **/
		int [][] c11 = add(sub(add(M1, M4), M5), M7);
		int [][] c12 = add(M3, M5);
		int [][] c21 = add(M2, M4);
		int [][] c22 = add(sub(add(M1, M3), M2), M6);

		//joining all sub- matrix to form bigger matrix
		join(c11,result, 0,0);
		join(c12,result, 0,n/2);
		join(c21,result, n/2,0);
		join(c22,result,n/2, n/2);
		return result;
	}
	static void spilt(int A[][], int S[][], int i1, int j1)
	{
		int n=A.length;
		for(int i=0;i<n/2;i++)
			for(int j=0;j<n/2;j++)
				S[i][j]=A[i+i1][j+j1];
	}
	static int[][] add(int a[][], int b[][])
	{
		int l=a.length;
		int c[][]=new int[l][l];
		for(int i=0;i<l;i++)
			for(int j=0;j<l;j++)
				c[i][j]=a[i][j]+b[i][j];
		return c;
	}
	static int[][] sub(int a[][], int b[][])
	{
		int l=a.length;
		int c[][]=new int[l][l];
		for(int i=0;i<l;i++)
			for(int j=0;j<l;j++)
				c[i][j]=a[i][j]-b[i][j];
		return c;
	}
	static void join(int P[][], int R[][], int i1,int j1)
	{
		int l=P.length;
		for(int i=0;i<l;i++)
			for(int j=0;j<l;j++)
				R[i+i1][j+j1]=P[i][j];
	}
}
