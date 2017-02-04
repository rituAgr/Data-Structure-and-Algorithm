package String_geeksforgeeks;

/**
 * Created by Ritu on 2/2/17.
 */
public class KMP_Pattern_matching {
    public static void main(String args[]) {
        String txt = "THIS IS A TEST TEXT";//"abcxabcdabcdabcy";//
        String pattern =  "TEST";//"abcdabcy";//
        find(txt,pattern);
    }
    private static void find(String txt, String pattern)
    {
        int start=0;
        int l=pattern.length();
        int[] len=KMP_suffix_Prefix(pattern);
        int pos=0;
        while(pos<txt.length())
        {
            if(txt.charAt(pos)==pattern.charAt(start))
            {
                start++;
                pos++;
            }
            else if(start>0)
                start=len[start-1];
            else
                pos++;
            if(start==l)
            {
                System.out.println("Position is "+((pos-1)-(l-1)));
                return;
            }
        }


    }
    private static int[] KMP_suffix_Prefix(String s)
    {
        int l=s.length();
        int[] len=new int[l];
        int i=0,j=1;
        while(j<l)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                len[j]=i+1;
                i++;
                j++;
            }
            else if(i>0)
                i=len[i-1];
            else
                j++;

        }
        return len;
    }
}
