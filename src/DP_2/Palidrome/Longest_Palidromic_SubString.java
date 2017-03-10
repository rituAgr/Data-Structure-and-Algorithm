package DP_2.Palidrome;

/**
 * Created by Ritu on 2/13/17.
 * https://www.youtube.com/watch?v=V-sEwsca1ak&t=399s
 * Generally , finding longest palidromic substring is done in O(n^2) time .
 * However, Manacher's Algo does the same in O(n) time.
 */
public class Longest_Palidromic_SubString
{
    public static void main(String args[])
    {
        String s = "abaxabaxabybaxabyb";//"abaxabaxabb";//;//"abba";//"babcbcabcbaccba";
        palidromeLen(s);


    }
    private static void palidromeLen(String s)
    {
        int l=s.length();
        if(l==0||l==1)
            return;
        boolean madeOdd=false;
        if(l%2==0)
        {
            madeOdd=true;
            StringBuilder s1=new StringBuilder();
            for(int k=0;k<l-1;k++)
                s1.append(s.charAt(k)).append('$');
            s1.append(s.charAt(l-1));
            s=new String(s1);
            l=s.length();
        }
       int[] paliLen=new int[l];
        int leftend=-1,rightend=-1,mid=-1,i=0;
        while(i<l&&rightend<l)
        {
            if(i>rightend)
            {
                paliLen[i]=palidromeUtil(s,i);
                rightend=i+paliLen[i]/2;
                leftend=i-paliLen[i]/2;
                mid=i;
                i++;
            }
            else
            {
                int distance=i-mid;
                paliLen[i]=paliLen[mid-distance];
                if((paliLen[i]/2+i)==rightend)
                {
                    if((i-paliLen[i]/2)>=leftend)
                        paliLen[i]=palidromeUtil(s,i);
                    else
                        paliLen[i]=rightend-i;
                }
                else if((paliLen[i]/2+i)>rightend)
                    paliLen[i]=rightend-i;
                i++;
            }
        }
        int max=-1,pos=-1;
        for( i=0;i<l;i++) {
            System.out.print(paliLen[i] + " ");
            if (max < paliLen[i]) {
                max = paliLen[i];
                pos = i;
            }
        }
        int start = pos - max / 2;
        System.out.println();
        if(!madeOdd) {
            System.out.println(s.substring(start, start + max));
            System.out.println("pos is " + pos+ " Length is "+max);
        }
        else
        {
            String sub=s.substring(start, start + max);
            for(int k=0;k<sub.length();k++)
                if(sub.charAt(k)!='$')
                    System.out.print(sub.charAt(k));
            System.out.println( " Length is "+(max/2+1));
        }
    }
    private static int palidromeUtil(String s , int mid)
    {
        int left=mid-1;
        int right=mid+1;
        int count=1;
        while((left>=0&&right<s.length())&&(s.charAt(left)==s.charAt(right)))
        {
            count=count+2;
            left--;right++;
        }
        return count;
    }
}
