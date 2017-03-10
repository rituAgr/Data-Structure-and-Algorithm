package DP_2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Ritu on 2/28/17.
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MaxSizeSquare_Matrix01
{
    public static  void main(String[] args)
    {
        int[][] matrix={{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        find(matrix);
    }
    private static void find(int[][] matrix)
    {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[] arr=new int[cols];
        int area=0;
        int startRow=0,startCol=0;
        int endRow=0,endCol=0;
        ArrayList<Integer> res;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
                if(matrix[i][j]==0)
                    arr[j]=0;
                else
                    arr[j]+=matrix[i][j];
            res=maxArea(arr);
            if(area<res.get(3))
            {
                area=res.get(3);
                endCol=res.get(1);
                startCol=res.get(0);
                startRow=i-res.get(2);
                endRow=i;
            }
        }
        System.out.println("Start row is "+startRow);
        System.out.println("End row is "+endRow);
        System.out.println("Start Col is "+startCol);
        System.out.println("End Col is "+endCol);
//        for(int r=startRow;r<=endRow;r++)
//            for(int c=startCol;c<endCol;c++)
//                System.out.println();
    }
    private static ArrayList<Integer> maxArea(int[] arr)
    {
        ArrayList<Integer> res=new ArrayList<Integer>();
        Stack<Integer> st=new Stack();
        int area=0, maxArea=0;
        int start=0,end=0,height=0;
        for(int i=0;i<arr.length;)
        {
            if(st.isEmpty()||arr[st.peek()]<=arr[i])
            {
                st.push(i);
                i++;
            }
            else
            {
                int top=st.pop();
                if(st.isEmpty())
                    area=i*arr[top];
                else
                    area=arr[top]*(i-1- st.peek());
                if(area>maxArea)
                {
                    maxArea=area;
                    if(st.isEmpty())
                        start=top;
                    else
                        start=st.peek()+1;
                    end=i-1;
                    height=top;
                }
            }
        }
        res.add(start);
        res.add(end);
        res.add(height);
        res.add(maxArea);
        return res;
    }

}
