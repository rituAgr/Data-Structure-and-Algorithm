package Array;

/**
 * Created by Ritu on 11/9/16.
 */
public class Next_Greater_Element {
    public static void main(String args[]){
        int[] arr={11, 13, 21, 3};
        find(arr);
    }
    private static void find(int[] arr)
    {
        int count = 1;
        int prev=arr[0];
        for(int pos=1;pos<arr.length;pos++)
        {
            if(arr[pos]>prev)
            {
                while(count>0)
                {
                    System.out.println(arr[pos]);
                    count--;
                }
                count=1;
                prev=arr[pos];
            }
            else
                count++;
        }
        while(count>0)
        {
            System.out.println(" -1 ");
            count--;
        }
    }
}
