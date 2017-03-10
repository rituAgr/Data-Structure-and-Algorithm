package DP_2.LIS;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Ritu on 2/25/17.
 */
public class Box_Stacking
{
    static class Box implements Comparable<Box>
    {
        int l,b,h;
        Box(int l1, int b1, int h1)
        {
            l=l1;
            b=b1;
            h=h1;
        }

        @Override
        public int compareTo(Box o) {
            int val1=this.l*this.b;
            int val2=o.l*o.b;
            int res=val2-val1;
            return res;
        }
    }
    public static void main(String args[])
    {
        Box arr[] = new Box[]{ new Box(4, 6, 7),  new Box(1, 2, 3),  new Box(4, 5, 6),  new Box(10, 12, 32) };
                //{new Box(1,2,4),new Box(3,2,5)};
        box_Stack(arr);
    }
    private static void box_Stack(Box[] arr)
    {
        int l=arr.length;
        Box[] boxes=new Box[l*3];
        int i=0;
        for(int pos=0;pos<l;pos++)
        {
            int len=arr[pos].l;
            int width=arr[pos].b;
            int height=arr[pos].h;
            boxes[i++]=new Box(len,width,height);
            boxes[i++]=new Box(width,height,len);
            boxes[i++]=new Box(height,len,width);
        }
        Arrays.sort(boxes);

        int total_height[]=new int[l*3];
        for(i=0;i<(l*3);i++)
            total_height[i]=boxes[i].h;

        int parent[]=new int[l*3];
        Arrays.fill(parent,-1);

        for(i=1;i<l*3;i++)
            for(int j=0;j<i;j++)
                if(boxes[i].l<boxes[j].l&&boxes[i].b<boxes[j].b&&total_height[i]<(total_height[j]+boxes[i].h))
                {
                    total_height[i]=(total_height[j]+boxes[i].h);
                    parent[i]=j;
                }
        int index=0;
        for(int k=1;k<(l*3);k++)
            if(total_height[index]<total_height[k])
                index=k;
        System.out.println("Maximum height is "+total_height[index]);
        Stack<Box> st=new Stack();
        while(index!=-1)
        {
            st.push(boxes[index]);
            index=parent[index];
        }
        while(!st.isEmpty())
        {
            Box k=st.pop();
            System.out.println("len : "+k.l+", Width : "+k.b+", Height : "+k.h);
        }
    }

}
