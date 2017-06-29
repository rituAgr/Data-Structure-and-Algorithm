package Array2;

/**
 * Created by Ritu on 3/11/17.
 * http://www.geeksforgeeks.org/majority-element/
 * Time complexity : O(n)
 */
public class MajorityNumber {
    public static void main(String[] args)
    {
        int[] arr={3, 3, 4, 2, 4, 4, 2, 4, 4};//{1, 3, 3, 1, 2};
        int element=MooreVotingAlgo(arr);
        System.out.println(element);
    }
    private static int MooreVotingAlgo(int[] arr)
    {
        //part1 :
        int count=0;
        int candidate=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(count==0)
            {
                candidate=arr[i];
                count++;
            }
            else
            {
                if(candidate==arr[i])
                    count++;
                else
                    count--;
            }
        }

        //part 2:
        count=0;
        for(int i=0;i<arr.length;i++)
            if(arr[i]==candidate)
                count++;
        if(count>arr.length/2)
            return candidate;
        return -1;
    }
}
