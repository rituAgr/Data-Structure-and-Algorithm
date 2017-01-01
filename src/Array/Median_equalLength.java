package Array;

import java.util.Arrays;

/**
 * Created by Ritu on 10/17/16.
 */
public class Median_equalLength {
    public static void main(String args[])
    {
        int[] arr1={1, 3, 6,7,9};
        int[] arr2={4, 6, 8, 10,14};
        double median=find_Median(arr1,0,arr1.length-1,arr2,0,arr2.length-1);
        System.out.print("The median is "+median);
    }
    private static double find_Median(int[] arr1,int start1,int end1, int[] arr2, int start2, int end2)
    {
        int count=end1-start1+1;
        if(count==1)
            return (arr1[start1]+arr2[start2])/2;
        if(count==2) {
            int[] array=new int[4];
            System.arraycopy(arr1,start1,array,0,2);
            System.arraycopy(arr2,start2,array,2,2);
            Arrays.sort(array);
            return (double)(array[1]+array[2])/2;
        }
        double mid_pos1,mid_pos2,mid1,mid2;
        if(count%2==0) {
            mid_pos1 =(double)(start1+end1)/2;
            mid1=(double)((arr1[(int)mid_pos1])+(arr1[(int)mid_pos1+1]))/2;
            mid_pos2 =(double)(start2+end2)/2;
            mid2=(double)((arr2[(int)mid_pos2])+(arr2[(int)mid_pos2+1]))/2;
        }
        else
        {
            mid_pos1 =(double)(start1+end1)/2;
            mid1=(arr1[(int)mid_pos1]);
            mid_pos2 =(double)(start2+end2)/2;
            mid2=(double)(arr2[(int)mid_pos2]);
        }
       //Comaparing
        if(mid1==mid2)
            return mid1;
        if(mid1<mid2) {
            if(count%2==0)
                return find_Median(arr1,(int)mid_pos1+1,end1,arr2,start2,(int)mid_pos2);
            else
               return find_Median(arr1,(int)mid_pos1+1,end1,arr2,start2,(int)mid_pos2);
        }
        else
        {
            if(count%2==0)
                return find_Median(arr1,start1,(int)mid_pos1,arr2,(int)mid_pos2,end2);
            else
                return find_Median(arr1,start1,(int)mid_pos1,arr2,(int)mid_pos2,end2);
        }
    }
}
