package stringprograms;

import java.util.HashMap;

/**
 * Created by Goutam on 8/23/2017.
 */
public class Anagrams {
    public static HashMap<Character, Integer> count = new HashMap<>();
    public static boolean anagramChecks(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        
        for(int i=0; i<s1.length(); i++) {
            if(!count.containsKey(s1.charAt(i)))
               count.put(s1.charAt(i), 1);
            else
                count.put(s1.charAt(i), count.get(s1.charAt(i))+1);
        }

        for(int i=0; i<s2.length(); i++) {
            if(!count.containsKey(s2.charAt(i)))
                count.put(s2.charAt(i), 1);
            else {
                count.put(s2.charAt(i), count.get(s2.charAt(i)) - 1);
                int zeroCheck = count.get(s2.charAt(i));
                if(zeroCheck == 0)
                    count.remove(s2.charAt(i));
            }
        }
        
        if(count.isEmpty())
            return true;
        else
            return false;
    }
    
    public static void main(String args[]){
        String s1 = "geeks";
        String s2 = "gekms";
        System.out.println(anagramChecks(s1,s2)?"YES":"NO");
    }
}
