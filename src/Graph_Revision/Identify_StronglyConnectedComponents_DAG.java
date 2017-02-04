package Graph_Revision;

import java.util.*;

/**
 * Created by Ritu on 1/24/17.
 * http://www.geeksforgeeks.org/strongly-connected-components/
 * https://www.youtube.com/watch?v=RpgcYiky7uw&t=313s
 * Time complexity - O(V+E)
 * Space Complexity - O(V)
 */
class graph_DAG
{
    int v;
    HashMap<Integer,LinkedList<Integer>> hm;
    graph_DAG(int v)
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
    HashMap<Integer,LinkedList<Integer>> getReverse()
    {
        HashMap<Integer,LinkedList<Integer>> reverse= new HashMap<>();

        for(int i=0;i<v;i++)
        {
            LinkedList<Integer> list=new LinkedList<Integer>();
            reverse.put(i,list);
        }
        for(int i=0;i<v;i++)
        {
            LinkedList<Integer> list=hm.get(i);
            for(Integer element:list)
                reverse.get(element).add(i);
        }
        return reverse;
    }
}
public class Identify_StronglyConnectedComponents_DAG
{
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        graph_DAG g = new graph_DAG(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components "+
                "in given graph ");
        printSCC(g);



        graph_DAG graph = new graph_DAG(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 6);

        System.out.println("\n\n Following are strongly connected components "+
                "in given graph ");
        printSCC(graph);
    }
    private static void printSCC(graph_DAG g)
    {
        Set<Integer> visited=new HashSet<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<g.v;i++)
        {
            if(!visited.contains(i))
                DFS(g,visited,st,i);
        }
        HashMap<Integer,LinkedList<Integer>> reverse=g.getReverse();
        visited.clear();
        ArrayList<Integer> component=new ArrayList<>();
        while(!st.isEmpty())
        {
            int num=st.peek();
            if(visited.contains(num))
                st.pop();
            else
            {
                StronglyConnectedComponent(reverse,visited,num,component);
                System.out.println(component.toString());
                component.clear();
            }

        }
    }
    private static void DFS(graph_DAG g,Set<Integer> visited,Stack<Integer>st,int start) {
        visited.add(start);
        LinkedList<Integer> list=g.hm.get(start);
        for(int element: list)
        {
            if(visited.contains(element))
                continue;
            DFS(g,visited,st,element);
        }
        st.add(start);
    }
    private static void StronglyConnectedComponent(HashMap<Integer,LinkedList<Integer>> reverse,Set<Integer> visited,int start, ArrayList component)
    {
        visited.add(start);
        component.add(start);
        LinkedList<Integer> list=reverse.get(start);
        for(Integer element:list)
        {
            if(visited.contains(element))
                continue;
            StronglyConnectedComponent(reverse,visited,element,component);
        }

    }
}
