package Graphs;

import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.SystemException;

import java.util.ArrayList;

/**
 * Created by Ritu on 10/9/16.
 * http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
 * Time complexity = O(V^3)
 * Space complexity =O(n^2)
 */
public class FloydWarshall
{
    static int INF= 10000000;
    public static void main(String args[])
    {
        int dist[][]=new int[][]{{0,   3,   6,   15},
                {INF, 0,  -2,   INF},
                {INF, INF, 0,   2},
                {1,   INF, INF, 0}};
        findPaths(dist);
    }
    private static void findPaths(int[][] dist)
    {
        int n=dist.length;
        int[][] paths=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(dist[i][j]!=INF||i!=j)
                    paths[i][j]=i;
                else
                    paths[i][j]=-1;
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                {
                    if(dist[i][k]==INF||dist[k][j]==INF)
                        continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        paths[i][j] =paths[k][j];
                    }
                }
        for(int i=0;i<n;i++)
            if(dist[i][i]<0)
            {
                System.out.print("There exist negative weight cycle");
                return;
            }
        //Print all paths
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                if(paths[i][j]==INF)
                    continue;
                printPaths(paths,i,j);
            }

    }
    private static void printPaths(int[][] paths, int source, int destination)
    {
        if(source==destination)
            return;
        ArrayList<Integer> route=new ArrayList<Integer>();
        System.out.println("Path from "+source+" to "+destination);
        route.add(destination);
        while(paths[source][destination]!=source) {
            route.add(0,paths[source][destination]);
            destination=paths[source][destination];
        }
        route.add(0,source);
        System.out.println(route);
    }

}
