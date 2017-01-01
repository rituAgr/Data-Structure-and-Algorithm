package Array;

/**
 * Created by Ritu on 11/10/16.
 */
public class isConsecutive {
    public static void main(String args[]){
        int[] arr={83, 78, 80, 81, 79, 82};
        System.out.print(find(arr));
    }
private static boolean find(int[] arr)
{
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    int count=arr.length;
    int sum=0;
    for(int i=0;i<count;i++)
    {
        if(arr[i]<min)
            min=arr[i];
        if(arr[i]>max)
            max=arr[i];
        sum=sum+arr[i];
    }
    int cal=count*(min+max)/2;
    if(sum==cal)
        return true;
    return false;
}
}

