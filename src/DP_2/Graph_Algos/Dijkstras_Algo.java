package DP_2.Graph_Algos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ritu on 3/3/17.
 * If the given graph is in form of Adjacency matrix => Time Complexity : O(V^2); Space complexity : O(V)
 * If the given graph is in form of Adjacency list => Time Complexity : O(ElogV); Space complexity : O(V+E)
 */
public class Dijkstras_Algo
{
    public static void main(String[] args) {
        int[][] graph=new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        Dijkstras(graph,0);
    }
    private static void Dijkstras(int[][] graph, int start)
    {
        int l=graph.length;
        if(start>=l)
            return;
        int[] distance=new int[l];
        int[] parent=new int[l];
        boolean[] isPresent=new boolean[l];

        Arrays.fill(distance,Integer.MAX_VALUE);
        Arrays.fill(parent,-1);
        Arrays.fill(isPresent,true);
        distance[start]=0;

        for(int i=0;i<l;i++)
        {
            int row=getMin(distance,isPresent);
            for(int col=0;col<l;col++)
                if(graph[row][col]!=0&&distance[col]>graph[row][col]+distance[row])
                {
                    distance[col]=graph[row][col]+distance[row];
                    parent[col]=row;
                }
        }
        int index=-1;
        while(index<=l-2)
        {
            index++;
            if(index==start)
                continue;
            int destination=index;
            System.out.println("\nRoute from "+start+" to "+destination);
            ArrayList<Integer> route=new ArrayList<Integer>();
            int sum=0;
            while(destination!=-1)
            {
                route.add(0,destination);
                destination=parent[destination];

            }
            System.out.println(route.toString());
            System.out.println("Sum is "+distance[index]);
        }

    }
    private static int getMin(int[] dis, boolean status[])
    {
        int l=dis.length;
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<l;i++)
            if(status[i]&&min>dis[i])
            {
                min=dis[i];
                index=i;
            }
        status[index]=false;
        return index;
    }

}
