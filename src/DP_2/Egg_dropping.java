package DP_2;

/**
 * Created by Ritu on 2/19/17.
 * https://www.youtube.com/watch?v=3hcaVyX00_4&t=595s
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 * Time complexity :
 */
public class Egg_dropping {
    public static void main(String args[]) {
int floor=6;
        int eggs=2;
        find(floor,eggs);
    }
    private static void find(int floors,int eggs)
    {
        int[][] matrix=new int[eggs+1][floors+1];
        for(int floor=1;floor<=floors;floor++)
            matrix[1][floor]=floor;
        for(int egg=2;egg<=eggs;egg++)
            for(int floor=1;floor<=floors;floor++)
            {
                if(floor<egg)
                {
                    matrix[egg][floor]= matrix[egg-1][floor];
                    continue;
                }
                int min=Integer.MAX_VALUE;
                for(int k=1;k<=floor;k++)
                {
                    int val=1+Math.max(matrix[egg][floor-k],matrix[egg-1][k-1]);
                    if(min>val)
                        min=val;
                }
               matrix[egg][floor]=min;
            }
        for(int egg=1;egg<=eggs;egg++)
        { for(int floor=1;floor<=floors;floor++)
                System.out.print(matrix[egg][floor]+"  ");
        System.out.println();}
        System.out.println(matrix[eggs][floors]);
    }
}
