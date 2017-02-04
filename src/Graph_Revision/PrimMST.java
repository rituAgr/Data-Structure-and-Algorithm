package Graph_Revision;

import java.util.Arrays;

/**
 * Created by Ritu on 1/17/17.
 */
public class PrimMST
{
    public static void main(String args[]) {
        int graph[][] = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };
        PrimMST mst=new PrimMST();
        mst.MST(graph,3);
    }
    private void MST(int[][] graph, int start)
    {
        int n=graph.length;
        boolean[] mset=new boolean[n];
        Arrays.fill(mset,true);
        int[] parent=new int[n];
        Arrays.fill(parent,-1);
        int weight[]=new int[n];
        Arrays.fill(weight,Integer.MAX_VALUE);
        weight[start]=0;
        for(int i=0;i<n;i++)
        {
            int u=minWeight(mset,weight);

            mset[u]=false;
            for(int v=0;v<n;v++)
            {
                if(graph[u][v]==0||mset[v]||graph[u][v]>weight[v])
                    continue;
                weight[v]=graph[u][v];
                parent[v]=u;
            }

        }
        for(int i=0;i<n;i++)
        {
            if(parent[i]==-1)
                continue;
            System.out.println(parent[i]+" -> "+i+"  =  "+graph[i][parent[i]]);
        }
    }
    private int minWeight(boolean[] mset, int[] weight)
    {
        int minWeight=Integer.MAX_VALUE;
        int minIndex=-1;
        for(int i=0;i<mset.length;i++)
            if(mset[i]&&weight[i]<minWeight)
            {
                minWeight=weight[i];
                minIndex=i;
            }
            return minIndex;
    }
}
