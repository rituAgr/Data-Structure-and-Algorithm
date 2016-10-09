package Divide_Conquer.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

//Refer link for reference : 
//http://www.geeksforgeeks.org/divide-and-conquer-set-7-the-skyline-problem/
public class SkyLineProblem
{
	static class BuildingPoint implements Comparable<BuildingPoint>
	{
		int x;
		int height;
		boolean isStart;
		public int compareTo(BuildingPoint o)
		{
			/*if (this.x != o.x) {
                return this.x - o.x;
            }
			else
				return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
			/*
			 */ if(this.x<o.x)
				return -1;
			else if(this.x>o.x)
				return 1;

			else if(this.isStart==true&&o.isStart==false)
			{
				return 1;
			}
			else if(this.isStart==false&&o.isStart==true)
			{
				return -1;
			}
			else if(this.isStart&&o.isStart)
			{
				if(this.height>o.height)
					return 1;
				else
					return -1;
			}
			else // when both building is end
			{
				if(this.height>o.height)
					return -1;
				else
					return 1;
			}
		}
	}
	public static ArrayList<int[]> getSkyLine(int buildings[][])
	{
		BuildingPoint[] building_points = new BuildingPoint[2*buildings.length];//buildings.length returns number of rows
	    int index=0;
	    for(int building[] : buildings)
	    {
	    	building_points[index]=new BuildingPoint();
	    	building_points[index].x=building[0];
	    	building_points[index].isStart=true;
	    	building_points[index].height=building[1];
	    	
	    	building_points[index+1]=new BuildingPoint();
	    	building_points[index+1].x=building[2];
	    	building_points[index+1].isStart=false;
	    	building_points[index+1].height=building[1];
	    	index=index+2;
	    }
	    Arrays.sort(building_points);
	    TreeMap<Integer, Integer> queue = new TreeMap<Integer, Integer>();
	    ArrayList<int[]> result = new ArrayList<>();
	    queue.put(0, 1);
	    int MaxPrevHeight=0;
	    //int max=0;
	    for(BuildingPoint point : building_points)
	    {
	    	if(point.isStart)
	    	{
	    		queue.compute(point.height,(key,value)->
	    		{
	    			if(value==null)
	    				return 1;
	    			return value+1;
	    		});
	    	}
	    	else
	    	{
	    		queue.compute(point.height,(key,value)->
	    		{
	    			if(value==1)
	    				return null;
	    			return value-1;
	    		});
	    	}
	    	int currMax=queue.lastKey();
	    	if(currMax!=MaxPrevHeight)
	    	{
	    		int r[]=new int[2];
	    		r[0]=point.x;
	    		r[1] =currMax;
	    		result.add(r);
	    		MaxPrevHeight=currMax;
	    	}
	    }
	   return result; 
	}
	public static void main(String args[])
	{
		int building[][]={{1,11,5},{2,6,7},{3,13,9},{12,7,16},{14,3,25},{19,18,22},{23,13,29},{24,4,28}};
		ArrayList<int[]> output=getSkyLine(building);
		for(int r[]: output)
		   System.out.println("X- axis : "+r[0]+", Height : "+r[1]);
	}
	
}
