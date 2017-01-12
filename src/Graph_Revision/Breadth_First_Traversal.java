package Graph_Revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.zip.Inflater;

/**
 * Created by Ritu on 1/6/17.
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 */
public class Breadth_First_Traversal
{
    int v;// number of vertex
    HashMap<Integer, LinkedList<Integer>> hm;

    //Initializing Adjacenty list
    Breadth_First_Traversal(int v)
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

    public static void main(String args[])
    {
        Breadth_First_Traversal g = new Breadth_First_Traversal(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        int start=2;
        ArrayList<Integer> res=new ArrayList<Integer>();
        // The sole purpose of this boolean array to know if the given node is already visited.
        //We can do we arrayListname.contains function too the same thing, but its inefficient
        boolean visited[]=new boolean[g.v];
        g.BFS( start, res, visited);
        for(Integer num:res)
            System.out.print(num+" ");
    }
    private void BFS( int start,  ArrayList<Integer> res, boolean visited[])
    {
        Queue<Integer> q=new LinkedList<>();
        LinkedList<Integer> list=hm.get(start);

        for(int i=0;i<list.size();i++)
        {
            int element=list.get(i);
            if(visited[element])
                continue;
            q.add(element);
            res.add(element);
            visited[element]=true;
        }
        while(!q.isEmpty())
        {
            int element=q.poll();
            BFS(element,res, visited);
        }
    }

}
