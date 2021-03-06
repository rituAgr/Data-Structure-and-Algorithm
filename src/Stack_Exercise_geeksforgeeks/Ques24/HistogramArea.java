package Stack_Exercise_geeksforgeeks.Ques24;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 12/23/2014
 * @author tusroy
 *
 * Video link https://youtu.be/ZmnqCZp9bBs
 *
 * Given an array representing height of bar in bar graph, find max histogram
 * area in the bar graph. Max histogram will be max rectangular area in the
 * graph.
 *
 * Maintain a stack
 *
 * If stack is empty or value at index at the top of stack is less than or equal to value at current
 * index, push this into stack.
 * Otherwise keep removing values from stack till value at index at top of stack is 
 * less than value at current index.
 * While removing value from stack calculate area
 * if stack is empty 
 * it means that till this point value just removed has to be smallest element
 * so area = input[top] * i
 * if stack is not empty then this value at index top is less than or equal to 
 * everything from stack top + 1 till i. So area will
 * area = input[top] * (i - stack.peek() - 1);
 * Finally maxArea is area if area is greater than maxArea.
 *
 *
 * Time complexity is O(n)
 * Space complexity is O(n)
 *
 * References:
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */
public class HistogramArea {

    public int maxHistogram(int input[]){
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        int start=-1,end=-1;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pop();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty())
                    area = input[top] * i;
                    //if stack is not empty then everythin from i-1 to input.peek() + 1
                    //has to be greater or equal to input[top]
                    //so area = input[top]*(i - stack.peek() - 1);
                else
                    area = input[top] * (i - stack.peekFirst() - 1);

                if(area > maxArea){
                    maxArea = area;
                    if(stack.isEmpty())
                        start=0;
                    else
                        start= stack.peek()+1;
                    end=i-1;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peek() - 1);
            }
            if(area > maxArea){
                maxArea = area;
                if(stack.isEmpty())
                    start=0;
                else
                    start= stack.peek()+1;
                end=i-1;
            }
        }
        System.out.println("Elements are : ");
        for(int k=start;k<=end;k++)
            System.out.print(input[k]+"  ");
        return maxArea;
    }

    public static void main(String args[]){
        HistogramArea mh = new HistogramArea();
        int input[] = {6, 2, 5, 4, 5, 1, 6};//{90, 58, 69, 70, 82, 100, 13, 57, 47, 18};
        int maxArea = mh.maxHistogram(input);
        System.out.println("\nMax Area is "+maxArea);
        System.out.println("***************");
        int arr[] =  {2, 0, 2};//{3, 0, 0, 2, 0, 4};//{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        maxArea =mh.maxHistogram(arr);
        System.out.println("\nMax Area is "+maxArea);
        //System.out.println(maxArea);
    }
}
