package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Ritu on 3/4/17.
 * https://www.hackerrank.com/challenges/jesse-and-cookies
 */
public class Jessie_and_Cookie
{
    int heapSize;
    int[] heap;
    static StringTokenizer st;

    static void nextLine(BufferedReader br) throws IOException {
        st=new StringTokenizer(br.readLine());
    }

    static int nextInt()  {

        int s= Integer.parseInt(st.nextToken());
        return s;
    }
    Jessie_and_Cookie(int[] arr)
    {
        heapSize=arr.length;
        heap=new int[heapSize];
        System.arraycopy(arr,0,heap,0,heapSize);
        heapify();
    }
    private void heapify()
    {
        for(int i=(heapSize/2);i>=0;i--)
            percolateDown(i);
    }
    void percolateDown(int index)
    {
        int left=getLeftChild(index);
        int right=getRightChild(index);
        int min=index;
        if(left!=-1&&heap[left]<heap[min])
            min=left;
        if(right!=-1&&heap[right]<heap[min])
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

        if(heap[index]<heap[parent])
        {
            swap(index,parent);
            percolateUp(parent);
        }
    }

    int getMin()
    {
        if(heapSize==0)
            return -1;
       int val=heap[0];
        heap[0]=heap[heapSize-1];
        heapSize--;
        percolateDown(0);
        return val;
    }
    void insert(int cookie)
    {
        heap[heapSize]=cookie;
        heapSize++;
        percolateUp(heapSize-1);
    }
    void swap(int x, int y)
    {
        int temp=heap[x];
        heap[x]=heap[y];
        heap[y]=temp;
    }
    int getLeftChild(int index)
    {
        int l=2*index+1;
        if(l>=heapSize)
            return -1;
        return l;
    }

    int getRightChild(int index)
    {
        int r=2*index+2;
        if(r>=heapSize)
            return -1;
        return r;
    }
    int getOperationNumber(int k)
    {
        if(heapSize==0)
            return -1;
        if(heap[0]>=k)
            return 0;
        int operation=0;
        while(heapSize>1&&heap[0]<k) {
            int min1 = getMin();
            int min2 = getMin();
            if (min1 == -1 || min2 == -1)
                return -1;
            int sweetness = min1 + 2 * min2;
            insert(sweetness);
            operation++;
        }
        if(heapSize==1&&heap[0]<k)
            return -1;
        return operation;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        nextLine(br);
        int numCookies=nextInt();
        if(numCookies<=0)
            return;
        int k=nextInt();
        int[] cookies=new int[numCookies];

        nextLine(br);
        for(int i=0;i<numCookies;i++)
            cookies[i]=nextInt();

        Jessie_and_Cookie ob=new Jessie_and_Cookie(cookies);
        int result=ob.getOperationNumber(k);
        System.out.println(result);

    }
}
