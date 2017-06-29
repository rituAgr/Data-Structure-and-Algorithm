package String_geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ritu on 2/17/17.
 * http://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
 * https://www.youtube.com/watch?v=V-sEwsca1ak&t=399s
 */
public class All_Palidrome_LinearTime
{
    public static void main(String args[])
    {
        String s = "abbaeae";
        allPalidrome(s);
    }
    private static void allPalidrome(String s)
    {
        int l=s.length();
        int len=2*l-1;
        char[] letters=new char[len];
        int[] pali_len=new int[len];
        Arrays.fill(pali_len,1);
        int pos=0;
        for(int i=0;i<l;i++)
        {
            letters[pos++]=s.charAt(i);
            if(pos<len)
                letters[pos++]='$';
        }
        int max_pos=0, max_left=-1,max_right=-1;
        for(int i=0;i<len;i++)
        {
            if(i==0||i==(len-1))
                continue;
            if(max_right==-1||i>=max_right)
            {
                int  curr_max=getLength(letters,i);
                max_right=i+curr_max/2;
                max_left=i-curr_max/2;
                pali_len[i]=curr_max;
                max_pos=i;
            }
            else
            {
                int dis=i-max_pos;
                int left=max_pos-dis;
                int right=pali_len[left];
                if((right/2+i)>=max_right)
                {
                    int  curr_max=getLength(letters,i);
                    max_right=i+curr_max/2;
                    max_left=i-curr_max/2;
                    pali_len[i]=curr_max;
                    max_pos=i;
                }
                else
                pali_len[i]=pali_len[left];
            }
        }
        ArrayList<String> result=new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            if(pali_len[i]>=3)
            {
                StringBuilder str=new StringBuilder();
                max_left=i-pali_len[i]/2;
                max_right=i+pali_len[i]/2;
                while(max_left<=max_right)
                {
                    if(letters[max_left]!='$')
                        str.append(letters[max_left++]);
                    max_left++;
                }

                while(str.length()>=2)
                {
                    result.add(str.toString());
                    str.deleteCharAt(0);
                    str.deleteCharAt(str.length()-1);
                }
            }
        }
        for(String str:result)
            System.out.println(str);
    }
    private static int getLength(char[] letters, int pos)
    {
        int len=1;
        int right=pos+1;
        int left=pos-1;
        while(letters[left]==letters[right])
        {
            len=len+2;
            left--;
            right++;
            if(left<0||right==letters.length)
                break;
        }
        return len;
    }
}
