package Graph_Revision;

import java.util.*;

/**
 * Created by Ritu on 1/21/17.
 * http://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
 * https://www.youtube.com/watch?v=2kREIkF9UAs
 */
 class graph
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
        hm.get(v2).addLast(v1);
    }
}
public class Articulation_Points {

    static int time=0;
    public static void main(String args[]) {

        graph g1 = new graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

       AP(g1);
    }
     static boolean AP(graph g)
    {
        Set<Integer> articulationPoint=new HashSet<>();
        Set<Integer> visited=new HashSet<>();
        Map<Integer,Integer> parent=new HashMap<>();
        Map<Integer,Integer> lowTime=new HashMap<>();
        Map<Integer,Integer> VisitTime=new HashMap<>();
        int vertex=0;
        parent.put(vertex,null);
        DFS(vertex,visited,articulationPoint,parent,lowTime,VisitTime,g);
        for(Integer num:articulationPoint)
            System.out.println(num);
        if(articulationPoint.size()==0)
            return false;
        return true;
    }
    private static void DFS(int vertex,Set<Integer> visited,Set<Integer> articulationPoint,Map<Integer,Integer> parent,Map<Integer,Integer> lowTime,Map<Integer,Integer> VisitTime,graph g)
    {
        visited.add(vertex);
        lowTime.put(vertex,time);
        VisitTime.put(vertex,time);
        time++;
        LinkedList<Integer> list=g.hm.get(vertex);
        int ChildCount=0;
        boolean isArticulationPoint=false;
        for(int i=0;i<list.size();i++)
        {
            int child=list.get(i);
            if(parent.get(vertex)!=null&&child==parent.get(vertex))
                continue;

            if(visited.contains(child))
                    lowTime.put(vertex,Math.min(lowTime.get(child),lowTime.get(vertex)));
            else
            {
                ChildCount++;
                parent.put(child,vertex);
                DFS(child,visited,articulationPoint,parent,lowTime,VisitTime,g);
                if(VisitTime.get(vertex)<=lowTime.get(child))
                    isArticulationPoint=true;
                else
                    lowTime.put(vertex,Math.min(lowTime.get(child),lowTime.get(vertex)));
            }
        }
        if((parent.get(vertex)==null&&ChildCount>=2)||(parent.get(vertex)!=null&&isArticulationPoint))
        articulationPoint.add(vertex);
    }
}
