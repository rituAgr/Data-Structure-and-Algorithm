package Graph_Revision;

import java.util.*;

/**
 * Created by Ritu on 1/7/17.
 */
public class MotherVertex {
    //Finding mother vertex can be done by both DFS as well as BFS,
    //Ultimately, for each vertex; it is just to check if via DFS or BFS; count of all vertex is number of vertex
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
        graph g=new graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);
        ArrayList<Integer> res=get_MotherVertex(g);
            System.out.print(res.toString());
    }

    private static ArrayList<Integer> get_MotherVertex(graph g)
    {
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<g.v;i++)
        {
            boolean[] visited=new boolean[g.v];
            ArrayList<Integer> nodes=new ArrayList<Integer>();
            BFS(g,i,visited,nodes);
            if(nodes.size()==g.v)
                res.add(i);
        }
        return res;
    }
    private static void BFS(graph g, int start,boolean[] visited,ArrayList<Integer> nodes )
    {
        LinkedList<Integer> list=(g.hm).get(start);
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<list.size();i++)
        {
            int element=list.get(i);
            if(visited[element])
                continue;
            q.add(element);
            nodes.add(element);
            visited[element]=true;
        }

        while(!q.isEmpty())
        {
            int element=q.remove();
            BFS(g,element,visited,nodes);
        }
    }
}
