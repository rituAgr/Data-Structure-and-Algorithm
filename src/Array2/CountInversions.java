package Array2;

/**
 * Created by Ritu on 3/15/17.
 * http://www.geeksforgeeks.org/counting-inversions/
 * Time complexity = O(nlogn)
 */
public class CountInversions
{
    public static void main(String[] args)
    {
        int arr[] = {1, 20, 6, 4, 5};
        System.out.println(count(arr, 0, arr.length-1));
    }
    private static int count (int[] arr,int start, int end)
    {
        if(start>=end)
            return 0;
        int mid=start+(end- start)/2;
        int c1=count(arr,start,mid);
        int c2=count(arr,mid+1,end);
        int c3=merge(arr,start,mid,mid+1,end);
        return c1+c2+c3;
    }
    private static int merge(int[] arr, int s1, int e1, int s2, int e2)
    {
        int count=0;
        int len1=e1-s1+1;
        int len2=e2-s2+1;
        int mid=s2;
        int[] temp=new int[len1+len2];
        int pos=0;

        while(s1<=e1&&s2<=e2)
        {
            if(arr[s1]>arr[s2]&&s1<s2)
            {
                count+=mid-s1;
                temp[pos++]=arr[s2++];
            }
            else if(arr[s1]==arr[s2])
            {
                temp[pos++]=arr[s1++];
                temp[pos++]=arr[s2++];
            }
            else
                temp[pos++]=arr[s1++];
        }
        while(s1<=e1)
            temp[pos++]=arr[s1++];

        while (s2<=e2)
            temp[pos++]=arr[s2++];

        pos=0;
        for(int k=s1;k<=e2;k++)
            arr[k]=temp[pos++];
        return count;
    }
}
