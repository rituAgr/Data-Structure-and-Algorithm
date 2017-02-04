package Graph_Revision;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Ritu on 1/23/17.
 * http://www.geeksforgeeks.org/eulerian-path-and-circuit/
 */
public class Eulerian {
    public static void main(String args[]) {
        // Let us create and test graphs shown in above figures
        graph g1 = new graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        test(g1);

        graph g2 = new graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        test(g2);

        graph g3 = new graph(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(1, 3);
        test(g3);

        // Let us create a graph with 3 vertices
        // connected in the form of cycle
        graph g4 = new graph(3);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 0);
        test(g4);

        // Let us create a graph with all veritces
        // with zero degree
        graph g5 = new graph(3);
        test(g5);
    }
    private static void test(graph g)
    {
        if(!isconnected(g))
        {
            System.out.println("This is not Eulerian");
            return;
        }
        int[] degree=new int[g.v];
        for(int i=0;i<g.v;i++)
        {
            LinkedList<Integer> list=g.hm.get(i);
            for(int element:list)
                degree[element]++;
        }
        int odd=0;
        for(int i=0;i<g.v;i++)
            if(degree[i]%2!=0)
                odd++;
        if(odd>2)
            System.out.println("This is not Eulerian");
        if(odd==2)
            System.out.println("This is  Eulerian path");
        //There can be never just one odd degree vertex in undirected graph
        if(odd==0)
            System.out.println("This is  Eulerian cycle");
    }
    private static boolean isconnected(graph g)
    {
        int i;
        for(i=0;i<g.v;i++)
            if(g.hm.get(i).size()>0)
                break;
        if(i==g.v)// It means there is no edge hence, not Eulerian; graph should have atleast edge to be considered
            return false;
        Set<Integer> visited=new HashSet<Integer>();
        DFSUtil(g,visited,i);
                if(visited.size()==g.v)
                    return true;
        return false;
    }
    private static void DFSUtil(graph g, Set<Integer> visited, int vertex)
    {
        visited.add(vertex);
        LinkedList<Integer> list=g.hm.get(vertex);
        for(int element:list)
        {
            if(visited.contains(element))
                continue;
            DFSUtil(g, visited, element);
        }
    }
}
