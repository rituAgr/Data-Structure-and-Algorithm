package Graph_Revision;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Ritu on 1/8/17.
 */

public class LongestPath_DAG {
    static int INF=Integer.MIN_VALUE;
    public static void main(String[] args)
    {
        int[][] graph={{0,5,3,0,0,0},
                {0,0,2,6,0,0},
                {0,0,0,7,4,2},
                {0,0,0,0,-1,1},
                {0,0,0,0,0,-2},
                {0,0,0,0,0,0}};
        longestPath(graph,1);
    }
    private static void longestPath(int[][] graph,int source)
    {
        int len=graph.length;
        int[] dis=new int[len];
        // Notes that in Longest path, we initialize the dis array with Integer.MIN_VALUE
        //Whereas in primMSt we do it with Integer.MAX_VAlUE
        Arrays.fill(dis,INF);
        int[] parent=new int[len];
        Arrays.fill(parent,-1);
        dis[source]=0;
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[len];
        for(int i=0;i<len;i++)
            if(!visited[i])
                topologicalSort(graph,st,visited,i);

        while(!st.isEmpty())
        {
            int curr=st.pop();
            if(dis[curr]<0)     // To start from the source position
                continue;
            for(int col=0;col<len;col++)
            {
                if(graph[curr][col]==0)
                    continue;
                if(dis[col]<dis[curr]+graph[curr][col]) // Checking the condition if there the distance is greater than alraedy existing
                {                                       //If Yes, Update the values
                    dis[col]=dis[curr]+graph[curr][col];
                    parent[col]=curr;
                }
            }
        }

        int maxDis=-1;
        int Position_des=-1;
        for(int i=0;i<dis.length;i++)
            if(maxDis<dis[i])
            {
                maxDis=dis[i];
                Position_des=i;
            }

        Stack<Integer> res=new Stack<>();

        while(Position_des!=-1)
        {
            res.push(Position_des);
            Position_des=parent[Position_des];
        }
        System.out.println("The max distance is "+maxDis);
        System.out.println("The path is as follows - ");
        while(!res.isEmpty())
            System.out.print(res.pop()+" ");
    }
    private static void topologicalSort(int[][] graph, Stack<Integer> st,boolean[] visited, int start)
    {
        for(int i=0;i<graph.length;i++)
        {
            int element=graph[start][i];
            if(element==0||visited[i])
                continue;
            topologicalSort(graph,st,visited,i);
        }
        visited[start]=true;
        st.push(start);
    }
}
