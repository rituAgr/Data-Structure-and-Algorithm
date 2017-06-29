package Array2;

/**
 * Created by Ritu on 3/21/17.
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 */
public class GivenSum_SubArray {
    public static void main(String[] args)
    {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
        find(arr, sum);
    }
    private static void find(int[] arr, int sum)
    {
        int start=0;
        int end=-1;
        int total =0;

        for(int i=0;i<arr.length;i++)
        {
            total+=arr[i];
            if(total==sum)
            {
                end=i;
                break;
            }
            else if(total>sum)
            {

                total-=arr[start];
                start++;
            }
        }
        if(end==-1)
        {
            System.out.println("No such sub array exist");
            return;
        }
        System.out.println("The subarray is with index "+start+" - "+end);
        while(start<=end)
            System.out.print(arr[start++]+" ");
    }
}
