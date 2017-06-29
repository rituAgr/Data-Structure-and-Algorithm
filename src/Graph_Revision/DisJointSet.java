package Graph_Revision;

import java.util.HashMap;

/**
 * Created by Ritu on 4/15/17.
 * https://www.youtube.com/watch?v=ID00PMy0-vE
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/DisjointSet.java
 *
 * Disjoint sets using path compression and union by rank
 * Supports 3 operations
 * 1) makeSet
 * 2) union
 * 3) findSet
 *
 * Space Complexity = O(n)
 * Time complexity =O(m)
 *
 *  where n is number of vertices and m is number of operations
 */
public class DisJointSet
{
    HashMap<Integer,Node> hm=new HashMap<>();
    static class Node
    {
        int data;
        Node parent;
        int rank;
    }
    void makeSet(int i)
    {
        Node node=new Node();
        node.data=i;
        node.parent=node;
        node.rank=0;
        hm.put(i,node);
    }

    int findSet(int val)
    {
        Node node=hm.get(val);
        return findSetUtil(node).data;
    }
    Node findSetUtil(Node node)
    {
        if(node.equals(node.parent))
            return node;
        Node n=findSetUtil(node.parent);
        node.parent=n;//path compression Optimization
        return n;
    }
    boolean union(int data1, int data2)
    {
        int parent1=findSet(data1);
        int parent2=findSet(data2);
        if(parent1==parent2)
            return false;
        Node p1=hm.get(parent1);
        Node p2=hm.get(parent2);

        if(p1.rank>p2.rank)
        {
            p2.rank=0;
            p2.parent=p1;
        }
        else if(p1.rank<p2.rank)
        {
            p1.rank=0;
            p1.parent=p2;
        }
        else
        {
            p2.rank=p2.rank++;
            p1.parent=p2;
        }
        return true;
    }
    public static void main(String args[]) {
        DisJointSet ds = new DisJointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }

}
