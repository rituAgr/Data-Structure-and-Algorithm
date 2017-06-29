package Array2;

/**
 * Created by Ritu on 3/12/17.
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
 * Time complexity : O(log N+ log M)
 */
public class MedianOf2_UnequalArray
{
    public static void main(String[] args)
    {
        int A[] = {1,12,15,26,38};//{5, 8, 10, 20};
        int B[] = {2,13,17,30,45,50,51};//{900};
        System.out.println(find(A,0,A.length-1,B,0,B.length-1));
    }
    //helper func1
    private static float MO2(int a , int b)
    {
        return ((float) (a+b))/2;
    }

    //helper func3
    private static float MO4(int a , int b, int c,int d)
    {
        int max=Math.max(a,Math.max(b,Math.max(c,d)));
        int min=Math.min(a,Math.min(b,Math.min(c,d)));
        float sum=(float)(a+b+c+d-max-min);

        return sum/2;
    }
    //helper func4
    private static float median(int[] arr, int start,int end)
    {
        if(start==end)
            return arr[start];
        int l=end-start+1;
        if(l%2==1)
        {
            int mid=start+(end-start)/2;
            return arr[mid];
        }
        int mid1=start+(end-start)/2;
        int mid2=mid1+1;

        return ((float)(arr[mid1]+arr[mid2]))/2;
    }
    private static float median(int a, int[] arr, int start,int end)
    {
        int l=end-start+1;
        if(l==2)
            return (arr[start]+arr[end]+a)-(Math.max(a,Math.max(arr[start],arr[end])))- (Math.min(a,Math.min(arr[start],arr[end])));

        int mid=start+(end-start)/2;
        if(l%2==1)
        {
            if(a>=arr[mid-1]&&a<=arr[mid+1])
                return ((float)(arr[mid]+a))/2;
            if(a<=arr[mid-1])
                return ((float)(arr[mid]+arr[mid-1]))/2;
            if(a>=arr[mid+1])
                return ((float)(arr[mid]+arr[mid+1]))/2;
        }
        if(a<=arr[mid])
            return arr[mid];
        else
            return ((float)(arr[mid]+arr[mid+1]))/2;
    }

    private static float find(int[] arr1,int start1,int end1, int[] arr2, int start2, int end2)
    {
        if(start1>end1||start2>end2)
            return 0.0f;
        int count1=end1-start1+1;
        int count2=end2-start2+1;

        if(count1==0)
            return median(arr2,start2,end2);
        if(count2==0)
            return median(arr1,start1,end1);

        if(count1==1&&count2==1)
            return MO2(arr1[start1],arr2[start2]);

        if(count1==1)
            return median(arr1[start1],arr2,start2,end2);
        if(count2==1)
            return median(arr2[start2],arr1,start1,end1);

        if(count1==2&&count2==2)
            return MO4(arr1[start1],arr1[end1],arr2[start2],arr2[end2]);

        float median1=median(arr1,start1,end1);
        float median2=median(arr2,start2,end2);

        if(median1==median2)
            return median1;

        int mid1=start1+count1/2;
        int mid2=start2+count2/2;

        if(median1<median2)
        {
            if(count1%2==0)
              start1=mid1+1;
            else
                start1=mid1;
            if(count2%2==0)
                end2=mid2;
            else
                end2=mid2-1;
            return find(arr1,start1,end1,arr2,start2,end2);
        }
        else
        {
            if(count1%2==0)
                end1=mid1;
            else
                end1=mid1;//done
            if(count2%2==0)
               start2=mid2+1;
            else
                start2=mid2;
            return find(arr1,start1,end1,arr2,start2,end2);
        }
    }
}
