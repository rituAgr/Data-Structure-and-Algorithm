package Array;

/**
 * Created by Ritu on 10/26/16.
 */
public class Median_UnequalLength {
    public static void main(String args[])
    {
        int[] arr1={900};//{1, 3, 6,7,9};
        int[] arr2={5, 8, 10, 20};
        int end1=arr1.length-1;
        int end2=arr2.length-1;
        Median_UnequalLength ob=new Median_UnequalLength();
        float val=ob.median(arr1,0,end1,arr2,0,end2);
        System.out.print("the median is "+val);
    }
    float MO2(int a, int b)
    {
        return (float)(a+b)/2;
    }
    float MO3(int a, int b, int c)
    {
        int max=Math.max(a,Math.max(b,c));
        int min=Math.min(a,Math.min(b,c));
        return (a+b+c)-max-min;
    }
    float MO4(int a, int b, int c, int d)
    {
        int max=Math.max(Math.max(a,b),Math.max(c,d));
        int min=Math.min(Math.min(a,b),Math.min(c,d));
        return (float)((a+b+c+d)-max-min)/2;
    }
    float median (int[] arr,int start, int end)
    {
        int count=end-start+1;
        if(count%2==1)
        {
            int mid=start+count/2;
            return arr[mid];
        }
        int mid2=start+count/2;
        int mid1=mid2-1;
        return (float)(arr[mid1]+arr[mid2])/2;
    }
    float median (int[] arr,int start, int end, int num)
    {
        int count=end-start+1;
        if(count%2==1)
        {
            int mid=start+count/2;
            if(num==arr[mid])
                return num;
            if(num<arr[mid])
            {
                if(num<arr[mid-1])
                    return (float)(arr[mid]+arr[mid-1])/2;
                else
                    return (float)(arr[mid]+num)/2;
            }
        }
        else {
            int mid2 = start + count / 2;
            int mid1 = mid2 - 1;
            if (num>arr[mid1]&&num<arr[mid2])
                return num;
            if(num<arr[mid1])
                return arr[mid1];
            else
                return arr[mid2];
        }
        return -1;
    }
    float median(int[] arr1, int start1, int end1, int arr2[], int start2, int end2)
    {
        int count1=end1-start1+1;
        int count2=end2-start2+1;
        //case 1: If first array is empty
        if(count1==0)
            return median(arr2,start2,end2);
        // case 2: If second array is empty
        if(count2==0)
            return median(arr1, start1, end1);
        //case 3: If first array is has one element
        if(count1==1&&count2==1)
            return MO2(arr1[start1],arr2[start2]);
        if(count1==1)
            return median(arr2,start2,end2,arr1[start1]);
        if(count2==1)
            return median(arr1,start1,end1,arr2[start2]);
        if(count1==2&&count2==2)
            return MO4(arr1[start1],arr1[end1],arr2[start2],arr2[end2]);
        float median1=median(arr1,start1,end1);
        float median2=median(arr2,start2,end2);
        if(median1==median2)
            return median1;
        int mid1=start1+count1/2;
        int mid2=start2+count2/2;
        if(median1<median2) {
                start1=mid1;
            if(count2%2==0)
                end2=mid2-1;
            else
                end2=mid2;
            return median(arr1, start1, end1, arr2, start2,end2);
        }
        else
        {
            if(count1%2==0)
                end1=mid1-1;
            else
                end1=mid1;
            //if(count2%2==0)
                start2=mid2;
            //else
              //  end2=mid2+1;
            return median(arr1, start1, end1, arr2, start2,end2);

        }
    }
}
