package Graph_Revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Ritu on 1/7/17.
 * http://www.geeksforgeeks.org/topological-sorting/
 * Topological sort in possible in undirected graph and directed cycle graph
 * Topological sort is only possible with DAG(Directed acyclic graph)
 */
public class Topological_Sort
{
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
                hm.put(i,list);
            }
        }
        void addEdge(int v1, int v2)
        {
            hm.get(v1).addLast(v2);
        }
    }
    public static void main(String args[])
    {
        graph g=new graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        Stack<Integer> res=topological_Sort(g);
        while(!res.isEmpty())
        System.out.print(res.pop()+"  ");
    }
    private static Stack<Integer> topological_Sort(graph g)
    {
        Stack<Integer> res=new Stack<Integer>();
        boolean[] visited=new boolean[g.v];

        for(int i=0;i<g.v;i++)
            if(!visited[i])
                topological_SortUtil(g, i,res,visited);
        return res;
    }
    private static void topological_SortUtil(graph g,int start, Stack<Integer> res,boolean[] visited)
    {
        visited[start]=true;
        LinkedList<Integer> list=g.hm.get(start);
        for(int i=0;i<list.size();i++)
        {
            int element=list.get(i);
            if(!visited[element])
             topological_SortUtil(g,element,res,visited);
        }

        res.push(start);
    }
}
