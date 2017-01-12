package Graph_Revision;

import java.util.*;

/**
 * Created by Ritu on 1/8/17.
 */
public class All_Topological_Sort {
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
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        All_topological_Sort(g);
    }
    private static void All_topological_Sort(graph g)
    {
        int Indegree[]=new int[g.v];
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<g.v;i++)
        {
            LinkedList<Integer> list=g.hm.get(i);
            for(int pos=1;pos<list.size();pos++)
            {
                int element=list.get(pos);
                Indegree[element]++;
            }
        }
        boolean[] visited=new boolean[g.v];
        ArrayList<Integer> res=new ArrayList<Integer>();
        doTopologicalSort(g, result,res, Indegree,visited);
        int l=result.size();
        System.out.println("**************"+result.size());
        for(int i=0;i<l;i++)
            System.out.println(result.get(i).toString());
    }

    private static void doTopologicalSort(graph g,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> res, int[] Indegree, boolean[] visited)
    {
        int l=g.v;

        for(int element=0;element<l;element++)
        {
            if(visited[element])
                continue;
            if(Indegree[element]==0)
            {
                visited[element]=true;
                res.add(element);
                LinkedList<Integer> list=g.hm.get(element);
                for(int i=1;i<list.size();i++)
                {
                    int num=list.get(i);
                    Indegree[num]--;
                }
                if(res.size()==l)
                {
// It need to create a new arraylist because the exiting one will change as well as
// same arraylist wil be added again giving empty arraylist
                    ArrayList<Integer> r=new ArrayList<>(res);
                    Collections.copy(r,res);
                    result.add(r);
                }
                else
                    doTopologicalSort(g,result,res,Indegree,visited);
                for(int k=0;k<res.size();k++)
                    if(res.get(k)==element)
                        res.remove(k);
                visited[element]=false;
                for(int i=1;i<list.size();i++)
                {
                    int num=list.get(i);
                    Indegree[num]++;
                }
            }

        }

    }
}
