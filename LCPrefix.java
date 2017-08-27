package stringprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Goutam on 8/25/2017.
 */
public class LCPrefix {
    
    public static String lcpSorting(String a[]){
        int aSize = a.length;
        if(aSize == 0)
            return "";
        if(aSize == 1)
            return a[0];

        Arrays.sort(a);
        
        int end = Math.min(a[0].length(), a[aSize-1].length());
        int i = 0;
        while(i<end && a[0].charAt(i) == a[aSize-1].charAt(i))
            i++;
        
        String lcp = a[0].substring(0,i);
        return lcp;
    }
    
    public static String lcpDCUtil(String s1, String s2){
        LinkedList<Character> result = new LinkedList<>();
        int s1Len = s1.length()-1;
        int s2Len = s2.length()-1;
        
        for(int i=0, j=0 ; i<=s1Len && j<=s2Len ; i++, j++ ){
            if(s1.charAt(i)!= s2.charAt(j))
                break;
            result.addLast(s1.charAt(i));
        }
        
        return result.getLast().toString();
    }
    
    public static String lcpDivideConquer(String a[], int l, int h){
        if(l == h)
            return a[l];
        if(h>l){
            int mid = (l + (h-l))/2;
            String s1 = lcpDivideConquer(a, l, mid);
            String s2 = lcpDivideConquer(a, mid+1, h);
            
            return lcpDCUtil(s1, s2);
        }
        return "No LCPrefix";
    }
    
    public static int findMinStringLength(String a[], int len){
        int minLength = a[0].length();
        for(int i=1; i<len; i++)
            if(a[i].length() < minLength)
                minLength = a[i].length();
        return minLength;
    }
    
    public static String lcpSortingCharByChar(String a[], int len){
        int minStringLength = findMinStringLength(a, len);
        LinkedList<Character> result = new LinkedList<>();
        char currentChar;
        for(int i=0; i<minStringLength; i++){
            currentChar = a[0].charAt(i);
            
            for(int j=1; j<len; j++)
                if(a[j].charAt(i) !=currentChar)
                    return result.toString();
            
            result.addLast(currentChar);
        }
        return (result.toString());
    }
    
    public static void main(String args[]){
        LCPrefix lcp = new LCPrefix();
        String array[] = new String[]{"apple", "apla", "abcd"};
        int arrayStartIndex = 0;
        int arrayEndIndex = array.length - 1;
        System.out.println("The Longest Common Prefix will be: " + lcpSorting(array));
        System.out.println("The Longest Common Prefix will be: " + lcpDivideConquer(array, arrayStartIndex, arrayEndIndex));
        System.out.println("The Longest Common Prefix will be: " + lcpSortingCharByChar(array, array.length).substring(1).trim());
    }
}
