package Array;

import java.util.Arrays;

/**
 * Created by Ritu on 10/28/16.
 */
public class Count_Inverse {
    static int count=0;
    public static void main(String args[])
    {
        int[] arr={1, 20, 6, 4, 5};
        arr=mergeSort(arr);
        System.out.print("The number of swaps are "+count);
        System.out.print("\n the sorted array is\n"+ Arrays.toString(arr));
    }
    private static int[] mergeSort(int[] arr)
    {
        int count=arr.length;
        if(count<=1)
            return arr;
        if(count==2)
        {
            if(arr[1]<arr[0])
                swap(arr,1,0);
            return arr;
        }
        int mid=arr.length/2;
        int[] arr1=new int[mid];
        int[] arr2=new int[arr.length-mid];
        System.arraycopy(arr,0,arr1,0,mid);
        System.arraycopy(arr,mid,arr2,0,arr.length-mid);
        arr1=mergeSort(arr1);
        arr2=mergeSort(arr2);
        arr=merge(arr1,arr2);
    return arr;

}
static int[] merge(int[] arr1, int[] arr2)
{
    int len1=arr1.length;
    int len2=arr2.length;
    int [] array=new int[len1+len2];
    int pos1=0,pos2=0,pos=0;
    while(pos1<len1&&pos2<len2)
    {
        if(arr1[pos1]<=arr2[pos2])
        {
            array[pos]=arr1[pos1];
            pos1++;
        }
        else
        {
            array[pos]=arr2[pos2];
            pos2++;
            count++;
        }
        pos++;
    }
    if(pos1<len1)
        System.arraycopy(arr1,pos1,array,pos,len1-pos1);
    if(pos2<len2)
        System.arraycopy(arr2,pos2,array,pos,len2-pos2);
    return array;
}
    static void swap(int[] array, int pos1, int pos2)
    {
        int temp=array[pos1];
        array[pos1]=array[pos2];
        array[pos2]=temp;
    }
}
