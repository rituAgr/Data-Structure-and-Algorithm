package Array;
import java.util.Arrays;
/**
 * Created by Ritu on 10/26/16.
 */
public class RotateArray {
    public static void main(String args[])
    {
        char[] arr={'A','B','C','D','E','F','G','H','I'};
        rotate(arr,3);
         System.out.print("The rotated array is "+Arrays.toString(arr));
    }
    private static void rotate(char[] arr, int d)
    {
        int len=arr.length;
        boolean flag=false;
        if(len%d==0&&d!=1)
        {
            flag=true;
            d=d-1;
        }
        int count=1,pos=len-1;
        char temp1=arr[pos],temp2;
        while(count<=len)
        {
            pos=(pos-d)%len;
            if(pos<0)
                pos=len+pos;
            temp2=arr[pos];
            arr[pos]=temp1;
            temp1=temp2;
            count++;
        }
       if(flag)
           rotate(arr,1);
    }
}
