package Heap.Ques_30;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Max_Window {

	static int[] maxSlidingWindow(int A[], int n, int w) 
	{
		int B[] = new int[n-w+1];
		 Deque<Integer> Q = new ArrayDeque<Integer>();
		for (int i = 0; i < w; i++)
		{
			while (!Q.isEmpty() && A[i] >= A[Q.getLast()])
				Q.removeLast();
			Q.addLast(i);
		}
		for (int i = w; i < n; i++) {
			B[i-w] = A[Q.peekFirst()];
			while (!Q.isEmpty() && A[i] >= A[Q.getLast()])
				Q.removeLast();
			while (!Q.isEmpty() && Q.peekFirst() <= i-w)//Q.size()>w)//
				Q.pollFirst();
			Q.addLast(i);
		}
		B[n-w] = A[Q.peekFirst()];
		return B;
	}
	public static void main(String args[])
	{
		int a[]={1,3,-1,-3,-9,3,6,9};
		int w=3;//size of window
		int b[] = maxSlidingWindow(a,a.length,w);
		for(int i : b)
			System.out.print(i+" ");
	}

}
