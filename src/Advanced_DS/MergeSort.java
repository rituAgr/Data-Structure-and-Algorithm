package Advanced_DS;

/**
 * Created by Ritu on 2/16/17.
 * Auxiliary Space: O(n)
 * Time complexity - O(nlog n)
 * http://quiz.geeksforgeeks.org/merge-sort/
 */
public class MergeSort {
    public static void main(String[] args)
    {
        int arr[] = {12, 11,11, 13, 5, 6, 7};
        arr=doMergeSort(arr);
        for(int num: arr)
            System.out.print(num+" ");
    }
    private static int[] doMergeSort(int[] arr)
    {
        int l=arr.length;
        if(l==0||l==1)
            return arr;
        int start=0,end=l-1;

        int mid=(start+end)/2+1;
        int[] arr1=new int[mid];
        System.arraycopy(arr,0,arr1,0,mid);

        int arr2[]=new int[l-mid];
        System.arraycopy(arr,mid,arr2,0,l-mid);

        arr1=doMergeSort(arr1);
        arr2=doMergeSort(arr2);

        return merge(arr1,arr2);
    }
    private static int[] merge(int[] arr1, int[] arr2)
    {
        int l1=arr1.length;
        int l2=arr2.length;
        int[] arr=new int[l1+l2];
        int pos=0,i=0,j=0;
        while(i<l1&&j<l2)
        {
            if(arr1[i]<arr2[j])
            {
                arr[pos]=arr1[i];
                i++;
            }
            else
            {
                arr[pos]=arr2[j];
                j++;
            }
            pos++;
        }
        if(i<l1)
            System.arraycopy(arr1,i,arr,pos,l1-i);
        if(j<l2)
            System.arraycopy(arr2,j,arr,pos,l2-j);
        return arr;
    }
}
