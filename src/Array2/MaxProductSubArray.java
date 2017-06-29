package Array2;

/**
 * Created by Ritu on 3/28/17.
 * http://www.geeksforgeeks.org/maximum-product-subarray/
 * Time complaxity : O(n)
 */
public class MaxProductSubArray {
    public static void main(String[] args)
    {
        int arr[] = {1, -2, -3, 0, 7, -8, -2};
        find(arr);
    }
    static class block
    {
        int min,max;
        block()
        {
            min=1;
            max=1;
        }
    }
    private static void find(int[] arr)
    {
        int n=arr.length;
        block[] blocks=new block[n];

        blocks[0]=new block();
        if(arr[0]>0)
            blocks[0].max=arr[0];
        if(arr[0]<0)
            blocks[0].min=arr[0];

        int maxTillnow=Integer.MIN_VALUE;
        for(int i=1;i<n;i++)
        {
            blocks[i]=new block();
            int product=Math.max(arr[i]*blocks[i-1].max,arr[i]*blocks[i-1].min);
            if(arr[i]<product)
                blocks[i].max=product;
             else
                blocks[i].max=arr[i];
            if( blocks[i].max<1)
                blocks[i].max=1;
            if(maxTillnow<product)
                maxTillnow=product;

            product=Math.min(arr[i]*blocks[i-1].max,arr[i]*blocks[i-1].min);
            if(arr[i]>product)
                blocks[i].min=product;
            else
                blocks[i].min=arr[i];

            if( blocks[i].min>1)
                blocks[i].min=1;

        }
        System.out.println(maxTillnow);
    }
}
