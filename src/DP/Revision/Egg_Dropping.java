package DP.Revision;

/**
 * Created by Ritu on 10/16/16.
 */
public class Egg_Dropping {
    public static void main(String args[])
    {
        int eggs=2;
        int floors=6;
        int attempts=find(eggs,floors);
        System.out.print("The minimum no of attempt required is "+attempts);
    }
    private static int find(int eggs, int floors)
    {
        int matrix[][]=new int[eggs+1][floors+1];
        for(int col=1;col<=floors;col++)
            matrix[1][col]=col;
        for(int egg=2;egg<=eggs;egg++)
            for(int floor=1;floor<=floors;floor++)
            {
               if(egg>floor)
               {
                   matrix[egg][floor]=matrix[egg-1][floor];
                   continue;
               }
                int min=Integer.MAX_VALUE;
               for(int i=1;i<=floor;i++)
               {
                   int attempt_Count=1+Math.max(matrix[egg-1][i-1],matrix[egg][floor-i]);
                   if(min>attempt_Count)
                       min=attempt_Count;
               }
                matrix[egg][floor]=min;
            }
        return matrix[eggs][floors];
    }
}
