package Graph_Revision;

import java.util.*;

/**
 * Created by Ritu on 1/13/17.
 * http://www.geeksforgeeks.org/applications-of-minimum-spanning-tree/
 * Time complexity : O(ElogE+ E)
 * Space ceomplexity : O(E+V)
 */
public class KruskalMST
{
    static class Edge implements Comparable<Edge>
    {
        int Vertex1,Vertex2,wt;
        Edge(int v1, int v2,int weight)
        {
            Vertex1=v1;
            Vertex2=v2;
            wt=weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.wt-o.wt;
        }
    }



    public static void main(String args[]) {

        KruskalMST mst=new KruskalMST();
        int ver=4;
        Edge[] edges=new Edge[5];
        edges[0]=new Edge(0,1,10);
        edges[1]=new Edge(0,2,6);
        edges[2]=new Edge(0,3,5);
        edges[3]=new Edge(1,3,15);
        edges[4]=new Edge(2,3,4);
        //Collections.sort operates on a List, and Arrays.sort operates on an array
        Arrays.sort(edges);
        for(Edge edge : edges)
            System.out.println(edge.Vertex1+" -> "+edge.Vertex2+" Weight = "+edge.wt);
        System.out.println(("******"));
        Set<Edge> result=mst.Kruskal_mst(edges,ver);
        for(Edge edge : result)
            System.out.println(edge.Vertex1+" -> "+edge.Vertex2+" Weight = "+edge.wt);
    }
    private Set<Edge> Kruskal_mst(Edge[] edges,int ver)
    {
        DisjointSet set=new DisjointSet(ver);
        set.makeSet(ver);
        Set<Edge> result=new HashSet<>();
        for(int i=0;i<edges.length;i++)
        {
            if(set.union(edges[i].Vertex1,edges[i].Vertex2))
                result.add(edges[i]);
            if(result.size()==ver-1)
                break;
        }
        return result;
    }
     class DisjointSet
    {
        int vertices;
        int[] parent;
        DisjointSet(int vertices)
        {
            this.vertices=vertices;
            parent=new int[vertices];
        }
        void makeSet(int v)
        {
            for(int i=0;i<vertices;i++)
                parent[i]=i;
        }
        int findSet(int ver)
        {
            while(parent[ver]!=ver)
                ver=parent[ver];
            return ver;
        }
        boolean union(int ver1, int ver2)
        {
            int parent1=findSet(ver1);
            int parent2=findSet(ver2);
            if(parent1==parent2)
                return false;
            parent[parent2]=parent1;
            return true;
        }
    }
}
