package Advanced_DS;

import java.util.*;

/**
 * Created by Ritu on 4/16/17.
 * http://www.geeksforgeeks.org/divide-and-conquer-set-7-the-skyline-problem/
 */
public class SkyLine_Problem
{
    public static void main(String args[]) {
        int building[][] = {{1, 11, 5}, {2, 6, 7}, {3, 13, 9},
                {12, 7, 16}, {14, 3, 25}, {19, 18, 22},
                {23, 13, 29}, {24, 4, 28}};
        System.out.println("********");
        find2(building);
    }

    static class buildingPoint implements Comparable<buildingPoint>
    {
        int x_pos;
        int height;
        boolean isStart;
        buildingPoint(int x, int h, boolean s)
        {
            x_pos=x;
            height=h;
            isStart=s;
        }

        @Override
        public int compareTo(buildingPoint o) {

            if(this.x_pos>o.x_pos)
                return 1;
            else if(this.x_pos<o.x_pos)
                return -1;

            if(this.isStart&&o.isStart)
            {
                if(this.height>o.height)
                    return 1;
                return -1;
            }

            if(!this.isStart&&!o.isStart)
            {
                if(this.height>o.height)
                    return -1;
                return 1;
            }

            if(this.isStart)
                return 1;
            return -1;
        }
    }
    private static void find2(int[][] buildings)
    {
        int n=buildings.length;
        buildingPoint[] points=new buildingPoint[2*n];

        int k=0;
        for(int i=0;i<n;i++)
        {
            points[k++]=new buildingPoint(buildings[i][0],buildings[i][1],true);
            points[k++]=new buildingPoint(buildings[i][2],buildings[i][1],false);
        }
        Arrays.sort(points);
        Set<Integer> set =new HashSet<>();
        set.add(0);
        int prevMax=0;
        Map<Integer,Integer> result=new TreeMap<>();

        for(k=0;k<2*n;k++)
        {
            if(points[k].isStart)
                set.add(points[k].height);
            else
                set.remove(points[k].height);

            int currMax=getMax(set);
            if(currMax!=-1&&currMax!=prevMax)
            {
                prevMax=currMax;
                result.put(points[k].x_pos,currMax);
            }
        }

        for(Map.Entry e: result.entrySet())
            System.out.println(e.getKey()+" -> "+e.getValue());
    }

    // Helper Func
    private static int getMax(Set<Integer> set)
    {
        int max=-1;
        for(Integer i: set)
            if(max<i)
                max=i;
        return max;
    }
}
