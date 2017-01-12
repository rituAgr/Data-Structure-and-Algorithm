package Graph_Revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ritu on 1/6/17.
 */
public class Depth_First_Traversal {
    int v;// number of vertex
    HashMap<Integer, LinkedList<Integer>> hm;

    //Initializing Adjacenty list
    Depth_First_Traversal(int v)
    {
        hm=new HashMap<Integer, LinkedList<Integer>>();
        this.v=v;
        for(int i=0;i<v;i++) {
            LinkedList<Integer> list=new LinkedList<Integer>();
            list.add(i);
            hm.put(i,list);
        }
    }
    void addEdge(int v1, int v2)
    {
        hm.get(v1).addLast(v2);
    }

    public static void main(String args[]) {
        Depth_First_Traversal g = new Depth_First_Traversal(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        int start = 2;
        ArrayList<Integer> res=new ArrayList<Integer>();
        // The sole purpose of this boolean array to know if the given node is already visited.
        //We can do we arrayListname.contains function too the same thing, but its inefficient
        boolean visited[]=new boolean[g.v];
        g.DFS( start, res, visited);
        for(Integer num:res)
            System.out.print(num+" ");
    }
    private void DFS( int start,  ArrayList<Integer> res, boolean visited[])
    {
        LinkedList<Integer> list=hm.get(start);
        for(int i=0;i<list.size();i++)
        {
            int element=list.get(i);
            if(visited[element])
                continue;
            res.add(element);
            visited[element]=true;
            DFS(element,res,visited);
        }
    }
}
