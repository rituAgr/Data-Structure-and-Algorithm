package Array2;

/**
 * Created by Ritu on 3/12/17.
 */
public class LinearArrayRotation
{
    public static void main(String[] args)
    {
        int arr1[] = {1, 2, 3, 4, 5, 6, 7,8,9,10,11,12};
        int arr2[] = {1, 2, 3, 4, 5, 6, 7 ,8,9,10,11,12};
        int d=3;
        rotate_Clockwise(arr1,d);
        System.out.println("*********");
        rotate_AntiClockwise(arr2,d);
        //rotate_AntiClockwise(arr2,d);
    }
    private static void rotate_Clockwise(int[] arr, int d)
    {
        int n=arr.length;
        int pos=0;

        int sets=GCD(n,d);
        while(sets!=0)
        {
            int position=pos;
            int temp=arr[position];
            do
            {
                int next=(position-d+n)%n;
                temp=shift(arr,next,temp);
                position=next;
            } while(position!=pos);
            pos++;
            sets--;
        }
        for(int i:arr)
            System.out.println(i);
    }
    private static void rotate_AntiClockwise(int[] arr, int d)
    {
        int n=arr.length;
        int pos=0;

        int sets=GCD(n,d);
        while(sets!=0)
        {
            int position=pos;
            int temp=arr[position];
            do
            {
                int next=(position+d)%n;
                temp=shift(arr,next,temp);
                position=next;
            } while(position!=pos);
            pos++;
            sets--;
        }
        for(int i:arr)
            System.out.println(i);
    }


    //helper func
    private static int GCD(int n1, int n2)
    {
        if(n1==0)
            return n2;
        if(n2==0)
            return n1;
        if(n1>n2)
            return GCD(n1%n2,n2);
        return GCD(n2%n1,n1);

    }

    //helper func
    private static int shift(int[] arr, int position, int value)
    {
        int temp=arr[position];
        arr[position]=value;
        return temp;
    }


}

