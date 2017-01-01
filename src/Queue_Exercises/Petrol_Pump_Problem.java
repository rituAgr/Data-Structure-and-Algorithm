package Queue_Exercises;

/**
 * Created by Ritu on 12/18/16.
 * Link : http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 * Space complexity : O(1)
 * Time Space : O(n)
 */
public class Petrol_Pump_Problem {
    public static void main(String args[])
    {
        int[][] petrol_Pumps={{4,4},{2,3},{6, 4}, {4,3}, {3,7}};
        //{x,y} => x is amount of petrol and y is distance
        int start=getStart(petrol_Pumps);
        if(start==-1)
            System.out.print("It is not possible to cover all petrol pump because of shortage of oil");
        else
            System.out.print("One should start from "+start);
    }
    private static int getStart(int[][] info)
    {
        int start=-1;
        int sum=0;
        for(int row=0;row<info.length;row++)
            sum=sum+info[row][0]-info[row][1];
        if(sum<0)
            return -1;
        for(int row=0;row<info.length;row++)
        {
            int dis=info[row][0]-info[row][1];
            if(dis<0)
            {
                start=-1;
                continue;
            }

            if(dis>0)
            {
                if(start==-1)
                    return row+1;
                else
                    return start+1;
            }
            start=row;

        }
        return -1;
    }

}
