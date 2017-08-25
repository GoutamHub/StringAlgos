package stringprograms;

import java.util.LinkedHashSet;

/**
 * Created by Goutam on 8/24/2017.
 */
public class RemoveAllDuplicates {
    
    private void removeDups(String s){
        LinkedHashSet<Character> lhs = new LinkedHashSet<>();
        for(int i=0; i<s.length(); i++)
            lhs.add(s.charAt(i));
        for(Character ch : lhs)
            System.out.print(ch);
    }
    
    public static void main(String args[]){
        String s = "ggeksforgeeks";
        RemoveAllDuplicates rad = new RemoveAllDuplicates();
        rad.removeDups(s);
    }
}
