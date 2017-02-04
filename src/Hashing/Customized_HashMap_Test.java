package Hashing;

/**
 * Created by Ritu on 1/21/17.
 * https://github.com/PriyankaPandey27/Data-Structure-And-Algorithms/tree/master/LinkedList/src/customhashmap
 * http://javarevisited.blogspot.in/2011/02/how-hashmap-works-in-java.html
 * A very important hashMap Ques
 */
class Customized_HashMap<K,V>
{
    Entry<K,V>[] table;
    int capacity;
    Customized_HashMap(int capacity)
    {
        this.capacity=capacity;
        table=new Entry[capacity];
    }

    //A very important helper method
    int hash(K key)
    {
        int code=key.hashCode();
        int pos=code%capacity;
        return pos;
    }


    //Adding key/value pair to Hashmap
    //if key is null; it won't enter the value
    void put(K key, V value)
    {
        if(key==null)
            return;
        Entry<K,V> entry=new Entry(key,value,null);
        int position=hash(key);
        if(table[position]==null)
            table[position]=entry;
        else
        {
            Entry<K,V> curr=table[position];
            Entry<K,V> last=null;
            while(curr!=null)
            {
                if(curr.next==null)
                    last=curr;
                if(curr.key==key)
                {
                    curr.value=value;
                    return;
                }
                curr=curr.next;
            }
            last.next=entry;
        }
    }


    //Retrieving the value of given key
    V get(K key)
    {
        if(key==null)
            return null;
        V val=null;
        int position=hash(key);
        if(table[position]!=null)
        {
            Entry<K,V> curr=table[position];
            while(curr!=null&&curr.key!=key)
                curr=curr.next;
            if(curr!=null)
                val=curr.value;
        }
        return val;
    }


    //Retrieving the value of given key
     boolean remove (K key)
    {
        if(key==null)
            return false;
        //Entry<K,V> entry=new Entry(key,value,null);
        int position=hash(key);
        if(table[position]==null)
            return false;
        else
        {
            Entry<K,V> curr=table[position];
            Entry<K,V> prev=null;
            while(curr!=null)
            {
                if(curr.key==key)
                {
                    if(prev==null)
                    {
                        table[position]=curr.next;
                        curr=null;
                        return true;
                    }
                    else
                    {
                        prev.next=curr.next;
                        curr=null;
                        return true;
                    }
                }
                prev=curr;
                curr=curr.next;
            }
            return false;
        }
    }

//Dislaying all entries
    void display()
    {
        for(int k=0;k<capacity;k++) {
            Entry<K, V> entry=table[k];
            if (entry == null)
                continue;

            while(entry!=null)
            {
                System.out.print(entry.key+" -> "+entry.value+"  ,");
                entry=entry.next;
            }
            System.out.println();
        }
    }

}
class Entry<K,V>
{
    K key;
    V value;
    Entry<K,V> next;
    Entry( K key, V value, Entry<K,V> next)
    {
        this.key=key;
        this.value=value;
    }

}
public class Customized_HashMap_Test
{
    public static void main(String args[])
    {
        Customized_HashMap<String, Integer> hashMapCustom = new Customized_HashMap<String, Integer>(16);
        hashMapCustom.put("abc", 12);
        hashMapCustom.put("abc", 100);
        hashMapCustom.put("nikki", 121);
        hashMapCustom.put("abc", 200);
        hashMapCustom.put("nikki", 122);
        hashMapCustom.put("abc", 150);
        hashMapCustom.put("nikki", 125);
        hashMapCustom.display();

        String key="nikki";
        System.out.println("value corresponding to key "+key+" = "+ hashMapCustom.get("nikki"));


        System.out.println("\n\nvalue corresponding to key "+key+" removed = "+  hashMapCustom.remove("nikki"));
        hashMapCustom.display();
    }
}