package Graph_Revision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Ritu on 1/23/17.
 * http://www.geeksforgeeks.org/biconnectivity-in-a-graph/
 * Basically, Biconnected graph are those graphs, where are the vertices can be reached by all other vertices by one than one path.
 * It requires two criteris-
 * 1. There should be no articulation point
 * 2. By any DFS or BFD traversal; all vertices should be visited
 */
public class BiConnected_Graph {
    public static void main(String args[]) {

        graph g2 = new graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(2, 4);
        boolean status=Articulation_Points.AP(g2);
        if(status)
            System.out.println("It is not a biconnected graph");
        else
        {
            Set<Integer> visited=new HashSet<Integer>();
            DFS(g2,0,visited);
            if(visited.size()==g2.v)
                System.out.println("It is a biconnected graph");
            else
                System.out.println("It is not a biconnected graph");
        }
    }
    private static void DFS(graph g, int vertex, Set<Integer> visited )
    {
        LinkedList<Integer> list=g.hm.get(vertex);
        visited.add(vertex);
        for(int i=0;i<list.size();i++)
        {
            int element=list.get(i);
            if(visited.contains(element))
                continue;
            DFS(g,element,visited);
        }
    }
}
