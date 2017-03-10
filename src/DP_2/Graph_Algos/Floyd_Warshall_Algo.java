package DP_2.Graph_Algos;

import java.util.ArrayList;

/**
 * Created by Ritu on 3/3/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
 * Time Complexity: O(V^3)
 */
public class Floyd_Warshall_Algo {
    static int INF = Integer.MAX_VALUE;

    public static void main(String args[]) {
        int[][] distances = {
                {0, 3, 6, 15},
                {INF, 0, -2, INF},
                {INF, INF, 0, 2},
                {1, INF, INF, 0}
        };
        Algo(distances);
    }

    private static void Algo(int[][] distances)
    {
        int l=distances.length;
        int[][] path=new int[l][l];

        for(int i=0;i<l;i++)
            for(int j=0;j<l;j++)
                if(distances[i][j]==0||distances[i][j]==INF)
                    path[i][j]=-1;
                else
                    path[i][j]=i;

        for(int k=0;k<l;k++)
            for(int i=0;i<l;i++)
                for(int j=0;j<l;j++)
                    if(distances[i][k]!=INF&&distances[k][j]!=INF&&distances[i][j]>distances[i][k]+distances[k][j])
                    {
                        distances[i][j]=distances[i][k]+distances[k][j];
                        path[i][j]=k;
                    }
        //Detecting negative weight cycle
        for(int j=0;j<l;j++)
            if(distances[j][j]<0)
            {
                System.out.println("Negative weight cycle exist");
                return;
            }
        printPath(path,distances,0,l-2);
        printPath(path,distances,1,l-1);

    }
    private static void printPath(int[][] path,int[][]dis, int src, int des)
    {
        if(des<0||src<0)
            return;
        int l=path.length;
        if(des>=l||src>=l)
            return;
        int total=dis[src][des];
        System.out.println("The route from "+src+" to "+des);
        ArrayList<Integer> route=new ArrayList<>();
        while(des>=0&&des!=src)
        {
            route.add(0,des);
            des=path[src][des];
        }
        route.add(0,src);
        System.out.println(route.toString());
        System.out.println("The total distance of route is "+total);
    }
}
