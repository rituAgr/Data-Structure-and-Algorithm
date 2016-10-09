package Sorting_geeksforgeeks.src;

import java.util.ArrayList;
import java.util.Collections;

/*
 * http://www.geeksforgeeks.org/find-memory-conflicts-among-multiple-threads/
 */
public class Conflict_memory_threads 
{
	static class T implements Comparable<T>
	{
		int name;
		int block;
		int Time;
		boolean R_W;
		T(int name,int block, int Time, int R_W)
		{
			this.name=name;
			this.block=block;
			this.Time=Time;
			if(R_W==1)
				this.R_W=true;
			else
				this.R_W=false;
		}
		public int compareTo(T t1)
		{
			if(this.block<t1.block)
				return 1;
			if(this.block>t1.block)
				return -1;
			return 0;
		}
	}
	public static void main(String args[])
	{
		int[][] array={ {1, 512, 1, 0},
				  {2, 432, 2, 1},
				  {3, 512, 3, 0},
				  {4, 932, 4, 0},
				  {5, 512, 5, 1},
				  {6, 932, 6, 0},
				  {7, 835, 7, 0},
				  {8, 432, 8, 0}};
		ArrayList<T> threads=new ArrayList<T>(); 
		for(int i =0;i<array.length;i++)
			threads.add(new T(array[i][0],array[i][1],array[i][2],array[i][3])); 
		Collections.sort(threads);
		conflicts(threads);
	}
	public static void conflicts(ArrayList<T> threads)
	{
		int prev_time=threads.get(0).Time;
		int prev_block=threads.get(0).block;
		int prev_name=threads.get(0).name;
		boolean prev_edit=threads.get(0).R_W;
		int curr_time=0;
		int curr_block=0;
		int curr_name=0;
		boolean curr_edit=false;
		for(int i=1;i<threads.size();i++)
		{
			curr_time=threads.get(i).Time;
			curr_block=threads.get(i).block;
			curr_name=threads.get(i).name;
			curr_edit=threads.get(i).R_W;
			if(curr_block==prev_block)
			{
				int diff=curr_time-prev_time;
				if(diff<=5&&(curr_edit||prev_edit))
					System.out.println("There is conflict between "+curr_name+" and "+prev_name);
			}
			prev_time=curr_time;
			prev_block=curr_block;
			prev_name=curr_name;
			prev_edit=curr_edit;
		}
	}
}
