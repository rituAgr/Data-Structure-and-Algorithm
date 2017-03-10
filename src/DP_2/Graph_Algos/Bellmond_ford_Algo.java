package DP_2.Graph_Algos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ritu on 3/3/17.
 * Time complexity=O(VE)
 * Space complexity = O(V)
 */
public class Bellmond_ford_Algo {
    static class edge
    {
        int src,dest,weight;
        edge(int src, int dest,int weight)
        {
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    public static void main(String[] args) {
        edge[] Edges=new edge[8];
        Edges[0]=new edge(0,1,-1);
        Edges[1]=new edge(0,2,4);
        Edges[2]=new edge(1,2,3);
        Edges[3]=new edge(1,3,2);
        Edges[4]=new edge(1,4,2);
        Edges[5]=new edge(3,2,5);
        Edges[6]=new edge(3,1,1);
        Edges[7]=new edge(4,3,-3);

        BellmanFord(Edges,5,0);
    }

    private static void BellmanFord(edge[] Edges, int NumVertex, int start)
    {
        int[] parent=new int[NumVertex];
        int[]  distance=new int[NumVertex];

        Arrays.fill(parent,-1);
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start]=0;

        for(int i=1;i<=NumVertex-1;i++)
        {
            for(int j=0;j<Edges.length;j++)
            {
                int u=Edges[j].src;
                int v=Edges[j].dest;
                int wt=Edges[j].weight;

                if(distance[v]>distance[u]+wt)
                {
                    distance[v]=distance[u]+wt;
                    parent[v]=u;
                }
            }
        }
        //Checking negative weight cycle
        for(int j=0;j<Edges.length;j++)
        {
            int u=Edges[j].src;
            int v=Edges[j].dest;
            int wt=Edges[j].weight;

            if(distance[v]>distance[u]+wt)
            {
                System.out.println("There exist negative cycle");
                return;
            }
        }

        int index=-1;
        while(index<=NumVertex-2)
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
    private static void relax()
    {

    }
}
