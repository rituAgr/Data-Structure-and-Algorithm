package Backtracking;

public class subsetSum {

    public boolean subsetsum(int input[], int total)
    {

        boolean T[][] = new boolean[input.length + 1][total + 1];
        for (int i = 0; i <= input.length; i++) 
            T[i][0] = true;
        for (int i = 1; i <= input.length; i++) 
        {
            for (int j = 1; j <= total; j++) 
            {
                if (j - input[i - 1] >= 0)
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                 else 
                    T[i][j] = T[i-1][j];
            }
        }
        return T[input.length][total];
    }
    public static void main(String args[]) {
    	subsetSum ss = new subsetSum();
        int arr1[] = {2, 3, 7, 8};
        System.out.print(ss.subsetsum(arr1, 11));

    }
}