package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Ritu on 3/5/17.
 * https://www.hackerrank.com/challenges/minimum-average-waiting-time
 */
public class Min_AvgWaitingTime
{
    class Order
    {
        int arrivalTime;
        int timeToCook;
        Order(int arr, int time)
        {
            arrivalTime=arr;
            timeToCook=time;
        }
    }
    int heapSize;
    Order[] heap;
    int end;
    static StringTokenizer st;

    static void nextLine(BufferedReader br) throws IOException {
        st=new StringTokenizer(br.readLine());
    }

    static int nextInt()  {

        int s= Integer.parseInt(st.nextToken());
        return s;
    }
    Min_AvgWaitingTime(int size,Order[] arr)
    {
        heapSize=size;
        heap=new Order[heapSize];
        end=arr.length-1;
        System.arraycopy(arr,0,heap,0,arr.length);
        heapify();
    }
    private void heapify()
    {
        for(int i=((end+1)/2);i>=0;i--)
            percolateDown(i);
    }
    void percolateDown(int index)
    {
        int left=getLeftChild(index);
        int right=getRightChild(index);
        int min=index;
        if(left!=-1&&(heap[left].timeToCook-heap[left].arrivalTime<heap[min].timeToCook-heap[min].arrivalTime))
            min=left;
        if(right!=-1&&(heap[right].timeToCook-heap[right].arrivalTime<heap[min].timeToCook-heap[min].arrivalTime))
            min=right;
        if(min!=index)
        {
            swap(min,index);
            percolateDown(min);
        }
    }

    void percolateUp(int index)
    {
        if(index==0)
            return;
        int parent=(index-1)/2;
        if( heap[index].timeToCook-heap[index].arrivalTime<heap[parent].timeToCook-heap[parent].arrivalTime)
        {
            swap(index,parent);
            percolateUp(parent);
        }
    }

    Order getMin()
    {
        if(end==-1)
            return null;
        Order val=heap[0];
        heap[0]=heap[end-1];
        end--;
        percolateDown(0);
        return val;
    }
    void insert(Order o)
    {
        end++;
        heap[end]=o;
        percolateUp(end);
    }
    void swap(int x, int y)
    {
        Order temp=heap[x];
        heap[x]=heap[y];
        heap[y]=temp;
    }
    int getLeftChild(int index)
    {
        int l=2*index+1;
        if(l>end)
            return -1;
        return l;
    }

    int getRightChild(int index)
    {
        int r=2*index+2;
        if(r>end)
            return -1;
        return r;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        int numCustomers=nextInt();
        if(numCustomers<=0)
            return;

        Order[] orders=new Order[numCustomers];
        for(int i=0;i<numCustomers;i++)
        {
            nextLine(br);
            orders[i].arrivalTime=nextInt();
            orders[i].timeToCook=nextInt();
        }

        int i=0;
        {
            i++;
        }while(orders[i].arrivalTime==0);
        int endTime=orders[i].arrivalTime+orders[i].timeToCook;

        Order[] firstBatch=new Order[i];
        System.arraycopy(orders,0,firstBatch,0,i);

        Min_AvgWaitingTime ob=new Min_AvgWaitingTime(numCustomers,firstBatch);
        int totalWaitingTime=0;
//        while()
//        {
//
//        }
//       // int result=ob.getOperationNumber(k);
//        System.out.println(result);

    }

}
