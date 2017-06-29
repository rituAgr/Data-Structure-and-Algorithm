package Array2;

/**
 * Created by Ritu on 4/12/17.
 * http://www.geeksforgeeks.org/trapping-rain-water/
 */
public class RainWater_Trapping {
    public static void main(String[] args)
    {
//        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        find(arr);
        int[] arr=new int[]{3, 0, 0, 2, 0, 4};
       find(arr);
    }
    private static void find(int[] arr)
    {
        int n=arr.length;
        int[] maxLeft=new int[n];
        int[] maxRight=new int[n];

        maxLeft[0]=arr[0];
        for(int i=1;i<n;i++)
            maxLeft[i]=Math.max(maxLeft[i-1],arr[i]);

        maxRight[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
            maxRight[i]=Math.max(maxRight[i+1],arr[i]);

        int AreaTrapped=0;
        for(int i=0;i<n;i++)
        {
            int val=Math.min(maxLeft[i],maxRight[i])-arr[i];
            val=Math.max(0,val);
            AreaTrapped+=val;
        }
        System.out.println("Maximum Area Trapped is "+AreaTrapped);
    }
}
