package String_geeksforgeeks;

/**
 * Created by Ritu on 2/2/17.
 * http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
 * The average and best case running time of the Rabin-Karp algorithm is O(n+m)
 * But its worst-case time is O(nm).
 */
public class Rabin_Karp_Pattern_matching
{
    public static void main(String args[])
    {
        String txt =  "THIS IS A TEST TEXT";
        String pat =  "TEST";
        System.out.println(find_Pattern(txt,pat));
    }
    private static int find_Pattern(String txt,String pat)
    {
        int l=pat.length();
        int last=txt.length();
        String sub=txt.substring(0,l);
        int Subhash=generateHash(sub);
        int pathash=generateHash(pat);
        for(int i=0;i<(last-l);i++)
        {
            if(Subhash==pathash)
            {
                int pos=0;
                while (pos<l)
                {
                   if(txt.charAt(i+pos)==pat.charAt(pos))
                       pos++;
                    else
                     break;
                }
                if(pos==l)
                    return i;
            }

            Subhash=RegenerateHash(sub,txt.charAt(i+l),Subhash);
            sub=txt.substring(i+1,i+l+1);
        }
        return -1;
    }
    private static int generateHash(String str)
    {
        int hash=0;
        int pow=0;
        for(int i=0;i<str.length();i++)
        {
            int c=(int)(str.charAt(i));
            hash=hash+(int)(c*Math.pow(13,pow));
            pow++;
        }
        return hash;
    }
    private static int RegenerateHash(String str, char n, int hash)
    {
        int first_char=(int)(str.charAt(0));
        hash=hash-first_char;
        hash=hash/13;
        int power=str.length()-1;
        hash=hash+n*(int)(Math.pow(13,power));
        return hash;
    }
}
