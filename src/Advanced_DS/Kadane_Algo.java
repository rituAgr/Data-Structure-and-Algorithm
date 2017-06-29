package Advanced_DS;

/**
 * Created by Ritu on 2/25/17.
 */
public class Kadane_Algo {
    public static void main(String[] args)
    {
        int elements[] = {-5, -3, 4, -1, -2, 1, 5, -3};
        find(elements);
    }
    private static void find(int[] arr)
    {
        int l=arr.length;
        if(l==0)
            return;
        int max_so_far=Integer.MIN_VALUE;
        int max_ending_here=0;
        int start=0,end=0,s=0;
        for(int i=0;i<l;i++)
        {
            max_ending_here=max_ending_here+arr[i];
            if(max_so_far<max_ending_here)
            {
                max_so_far=max_ending_here;
                start=s;
                end=i;
            }
            if(max_ending_here<0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("maximum contiguous sum : "+max_so_far);
        for(int k=start;k<=end;k++)
            System.out.print(arr[k]+" ");
    }
}
