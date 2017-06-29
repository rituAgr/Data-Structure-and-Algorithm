package Advanced_DS;

import java.util.Stack;

/**
 * Created by Ritu on 2/28/17.
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * Time & Space complexity - O(n)
 */
public class MaxAreaHistogram {
    public static void main(String[] args) {
        int[] arr = {6, 2, 1, 1, 5, 4, 5};//{6, 2, 5, 4, 5, 2, 6};//
        find(arr);
    }

    private static void find(int[] arr) {
        int l = arr.length;
        if (l == 0)
            return;
        int maxArea = 0, area = 0;
        int top = 0;
        int start = -1, end = -1, i=-1;
        Stack<Integer> st = new Stack<>();

        for ( i = 0; i < l; ) {
            if (st.isEmpty() || arr[st.peek()] <= arr[i])
                st.push(i++);
            else
            {
                 top=st.pop();
                if (st.isEmpty())
                    area = arr[top] * i;
                else
                    area = arr[top] * (i - st.peek()-1);
                if (maxArea < area) {
                    maxArea = area;
                    if (st.isEmpty())
                        start = 0;
                    else
                        start = st.peek()+1;
                    end = i - 1;
                }
            }
        }
        while(!st.isEmpty())
        {
            top = st.pop();
            if (st.isEmpty())
                area = arr[top] * i;
            else
                area = arr[top] * (i - st.peek()-1);
            if (maxArea < area) {
                maxArea = area;
                if (st.isEmpty())
                    start = 0;
                else
                    start = st.peek() + 1;
                end = i - 1;
            }
        }
        System.out.println("Max area is " + maxArea);
        for (int k = start; k <= end; k++)
            System.out.print(arr[k] + " ");
    }
}

