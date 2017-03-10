package DP_2.LIS;

/**
 * Created by Ritu on 2/15/17.
 */
public class LIS_recursion {
    public static void main(String[] args) {
        int[] array={50, 3, 10, 7, 40, 80};
        int maxLen=LIS(array,0,0,-1);
        System.out.println(maxLen);
    }
    private static int LIS(int[] array, int pos, int maxLength, int prev)
    {
        int l=array.length;
        if(pos>=l)
            return maxLength;
        int max1,max2;
        if(prev==-1||array[pos]>prev)
            max1=LIS(array,pos+1,maxLength+1,array[pos]);
        else
            max1=LIS(array,pos+1,maxLength,prev);
        max2=LIS(array,pos+1,1,array[pos]);
        return Math.max(max1,max2);
    }
}
