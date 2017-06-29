package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * COMPLETED
 * Created by Ritu on 2/27/17.
 * https://www.hackerrank.com/challenges/qheap1
 */
public class qheap {


    private static StringTokenizer st;

    public static void nextLine(BufferedReader br) throws IOException
    {
        st = new StringTokenizer(br.readLine());
    }

    public static int nextInt()
    {
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        int count=nextInt();
        if(count<=0)
            return;
        int[] array=new int[count];
        int size=0;
        for(int i=0;i<count;i++)
        {
            nextLine(br);
            int operation=nextInt();
            int val=-1;
            if(operation!=3)
              val=nextInt();

            if(operation==1)//add val
            {

                array[size++]=val;
                int pos=size-1;
                while(pos>0&&array[getparent(pos)]>array[pos])
                {
                    int p=getparent(pos);
                    swap(array,pos,p);
                    pos=p;
                }
            }
            if(operation==2)//del val
            {
                int index=findIndex(array,size,val,0);
                array[index]=array[size-1];
                size--;
                while(index<size)
                {
                    int l=leftChild(size,index);
                    int r=rightChild(size,index);
                    int max=index;
                    if(l!=-1&&array[l]>array[max])
                        max=l;
                    if(r!=-1&&array[r]>array[max])
                        max=r;
                    if(max!=index)
                    {
                        swap(array,max,index);
                        index=max;
                    }
                    else
                        break;
                }
            }
            if(operation==3)//print min
            {
                if(size>0)
                    System.out.println(array[0]);
                else
                    System.out.println();

            }
        }
    }
    private static void swap(int[] arr, int i, int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static int leftChild(int size, int pos)
    {
        int l=2*pos+1;
        if(l>=size)
            return -1;
        return l;
    }
    private static int rightChild(int size, int pos)
    {
        int l=2*pos+2;
        if(l>=size)
            return -1;
        return l;
    }
    private static int getparent(int pos)
    {
        int parent=(pos-1)/2;
        return parent;
    }

    private static int findIndex(int arr[], int size,int num,int pos)
    {
        if(pos>=size)
            return -1;
        if(arr[pos]==num)
            return pos;
        int l=findIndex(arr,size,num,2*pos+1);
        if(l!=-1)
            return l;
        return findIndex(arr,size,num,2*pos+2);
    }
}
