package Graph_Revision;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Ritu on 1/10/17.
 */
public class Kahns_TopologicalSort {
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
    public static void main(String args[])
    {
        graph g=new graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
      //  g.addEdge(1, 5);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        Queue<Integer> res=topological_Sort(g);
        if(res==null)
            System.out.print("There exist a cycle");
        else
        {
            while(!res.isEmpty())
                System.out.print(res.poll()+"  ");}
    }
    private static Queue<Integer> topological_Sort(graph g)
    {
        int in_degree[]=new int[g.v];
        Queue<Integer> res =new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<g.v;i++)
        {
            LinkedList<Integer> list=g.hm.get(i);
            for(int pos=1;pos<list.size();pos++)
            {
                int element=list.get(pos);
                in_degree[element]++;
            }
        }
        for(int k=0;k<g.v;k++)
            if(in_degree[k]==0)
                q.add(k);
        while(!q.isEmpty())
        {
            int element=q.poll();
            res.add(element);
            LinkedList<Integer> list=g.hm.get(element);
            for(int i=1;i<list.size();i++)
            {
                int num=list.get(i);
                in_degree[num]--;
                if(in_degree[num]==0)
                    q.add(num);
            }
        }
        if(res.size()!=g.v)
            return null;
        return res;

    }
}
