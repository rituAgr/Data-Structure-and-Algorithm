package Array2;

/**
 * Created by Ritu on 4/8/17.
 * http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 * Time complexity = O(n)
 * Space complexity =  O(1)
 */
public class Petrol_Pump {
    static class Pumps
    {
        int amount,distance;
        Pumps(int amt, int dis)
        {
            amount=amt;
            distance=dis;
        }
    }
    public static void main(String[] args)
    {
        //Pumps[] petrolPumps=new Pumps[]{new Pumps(6,4), new Pumps(3,6), new Pumps(7,3)};

        Pumps[] petrolPumps=new Pumps[]{new Pumps(4,6), new Pumps(6,5), new Pumps(7,3), new Pumps(4,5)};

        find(petrolPumps);
    }
    private static void find(Pumps[] petrolPumps)
    {
        int l=petrolPumps.length;
        int amt=0;
        int start=-1,curr=0;

        while(curr!=start)
        {
            if((amt+petrolPumps[curr].amount)<petrolPumps[curr].distance)
            {
                start=-1;
                amt=0;
                curr=(curr+1)%l;
                continue;
            }
            if(start==-1)
                start=curr;
            amt=amt+petrolPumps[curr].amount-petrolPumps[curr].distance;
            curr=(curr+1)%l;
        }
        System.out.println("Index of start petrol pump "+start);
    }
}
