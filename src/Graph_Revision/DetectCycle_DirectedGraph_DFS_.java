package Graph_Revision;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Ritu on 1/11/17.
 * http://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
 * Time complexity : O(V+E)
 * Space compexity : O(V)
 */
public class DetectCycle_DirectedGraph_DFS_ {
    static class graph
    {
        int v;
        HashMap<Integer,LinkedList<Integer>> hm;
        graph(int v)
        {
            this.v=v;
            hm=new HashMap<>();
            for(int i=0;i<v;i++)
            {
                LinkedList<Integer> list=new LinkedList<Integer>();
                list.add(i);
                hm.put(i,list);
            }
        }
        void addEdge(int v1, int v2)
        {
            hm.get(v1).addLast(v2);
        }
    }
    public static void main(String args[]) {
        graph g = new graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
//        g.addEdge(2, 0);
        g.addEdge(2, 3);
       // g.addEdge(3, 3);
        System.out.println(isCycle(g));
    }
    private static boolean isCycle(graph g)
    {
        for (int i=0;i<g.v;i++)
        {
            boolean[] visited=new boolean[g.v];
            if(isCycleUtil(g,visited,i))
                return true;
        }
        return false;
    }
    private static boolean isCycleUtil(graph g, boolean[] visited,int start)
    {
        if(visited[start])
            return true;
        visited[start]=true;
        LinkedList<Integer> list=g.hm.get(start);
        for(int i=1;i<list.size();i++)
        {
            int element=list.get(i);
            if(isCycleUtil(g,visited,element))
            return true;
            visited[element]=false;
        }
        return false;
    }
}
