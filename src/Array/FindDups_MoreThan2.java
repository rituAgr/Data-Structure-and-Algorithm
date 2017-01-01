package Array;

import java.util.ArrayList;

/**
 * Created by Ritu on 11/6/16.
 * Very important interview ques.
 * Note the constraint on input value explained the below link
 * http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 * Time complexity : O(n)
 * Space complexity : O(1)
 */
public class FindDups_MoreThan2
{
    public static void main(String args[])
    {
        int[] arr= {1, 2, 3, 1, 3, 6, 6};
            ArrayList<Integer> res=find(arr);
    System.out.print(res.toString());
    }
    private static ArrayList<Integer> find(int[] arr)
    {
        ArrayList<Integer> res=new ArrayList();
        for(int i=0;i<arr.length;i++)
            if(arr[Math.abs(arr[i])]>=0)
                arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
        else
            res.add(Math.abs(arr[i]));
        return res;
    }
}
