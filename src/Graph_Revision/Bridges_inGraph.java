package Graph_Revision;

import java.util.*;

/**
 * Created by Ritu on 1/23/17.
 */
public class Bridges_inGraph {
    public static void main(String args[]) {
        // Create graphs given in above diagrams
        System.out.println("Bridges in first graph ");
        graph g1 = new graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        bridge(g1);
        System.out.println();
    }
    static int time=0;
    private static void bridge(graph g)
    {
        Map<Integer,Integer> visitedTime=new HashMap<Integer,Integer>();
        Map<Integer,Integer> lowTime=new HashMap<Integer,Integer>();
        Map<Integer,Integer> parent=new HashMap<Integer,Integer>();
        int vertex=0;
        parent.put(vertex,null);
        Map<Integer,Integer> ap=new HashMap<Integer,Integer>();
        Set<Integer> visited=new HashSet<>();
        bridgeUtil(g,lowTime,visitedTime,parent,vertex,visited, ap);
        for(Map.Entry entry: ap.entrySet())
            System.out.println(entry.getKey()+" -> "+entry.getValue());

    }
    private static void bridgeUtil(graph g,Map<Integer,Integer> lowTime,Map<Integer,Integer> visitedTime, Map<Integer,Integer> parent,int vertex, Set<Integer> visited, Map<Integer,Integer> ap )
    {
        visited.add(vertex);
        visitedTime.put(vertex,time);
        lowTime.put(vertex,time);
        time++;
        LinkedList<Integer> list=g.hm.get(vertex);
        int ChildCount=0;
        for(int i=0;i<list.size();i++)
        {
            int element=list.get(i);
            if(parent.get(vertex)!=null&&parent.get(vertex)==element)
                continue;
            if(visited.contains(element))
                lowTime.put(vertex,Math.min(lowTime.get(element),lowTime.get(vertex)));
            else
            {
                ChildCount++;
                parent.put(element,vertex);
                bridgeUtil(g,lowTime,visitedTime,parent,element,visited, ap);
                if(visitedTime.get(vertex)<=lowTime.get(element))
                    ap.put(vertex,element);
                else
                    lowTime.put(vertex,Math.min(lowTime.get(element),lowTime.get(vertex)));
            }
        }
        if(parent.get(vertex)==null&ChildCount>=2)
            for(int element:list)
                ap.put(vertex,element);

    }
}
