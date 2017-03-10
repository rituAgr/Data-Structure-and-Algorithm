package DP_2.KnapSack_problem;

import java.util.Arrays;

/**
 * Created by Ritu on 2/19/17.
 */
public class Knapsack_Prblm_Normal implements Comparable<Knapsack_Prblm_Normal>{
    float weight,val;
    Knapsack_Prblm_Normal(float w, float v)
    {
        weight=w;
        val=v;
    }
    public static void main(String args[]) {
        float[] val = new float[]{1,4,5,7};
        float[] wt = new float[]{1,3,4,5};
        int l=val.length;
        Knapsack_Prblm_Normal[] items=new Knapsack_Prblm_Normal[l];
        for(int i=0;i<l;i++)
            items[i]=new Knapsack_Prblm_Normal(wt[i],val[i]);
        Arrays.sort(items);
        int W = 7;
        find(items,W);
    }
    private static void find(Knapsack_Prblm_Normal[] items, float totalWt)
    {
        int l=items.length;
        int last=-1;
        float frac=0.0f;
        float total=0;
        int i=0;
        while(i<l&&total<totalWt)
        {
            if((total+items[i].weight)<=totalWt)
               totalWt=total+items[i++].weight;
            else
            {
                float r=totalWt-total;
                frac=r/items[i].weight;
                break;
            }
        }
        float value=0;
        for(int k=0;k<i-1;k++) {
            System.out.println(items[k].weight + "  " + items[k].val + "   X  1");
            value+=items[k].val;
        }
        System.out.println(items[i-1].weight+"  "+items[i-1].val+"   X  "+frac);
        value+=items[i-1].val*frac;
        System.out.println("Total value is "+value);
    }

    @Override
    public int compareTo(Knapsack_Prblm_Normal o) {
        double f1=this.val/this.weight;
        double f2= o.val/o.weight;
        if(f1==f2)
            return 0;
        if(f1<f2)
            return 1;
        return -1;
    }
}


