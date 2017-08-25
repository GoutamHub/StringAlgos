package stringprograms;

/**
 * Created by Goutam on 8/25/2017.
 */
public class MinCharForPalindrom {
    public static void main(String args[]){
        String str = "geeks";
        System.out.println(findMinInsertion(str.toCharArray(), 0, str.length()-1));
        System.out.println(findMinInsertion(str.toCharArray(),str.length()));
    }
    
    public static int findMinInsertion(char s[], int l, int h){
        if(l>h)
            return Integer.MAX_VALUE;
        if(l==h)
            return 0;
        if(l==h-1)
            return(s[l]==s[h]?0:1);
        
        return(s[l]==s[h]?findMinInsertion(s, l+1, h-1):Integer.min(findMinInsertion(s,l, h-1), findMinInsertion(s,l+1,h))+1);
    }
    
    public static int findMinInsertion(char s[], int n){
        // Create a table of size n*n. table[i][j]
        // will store minumum number of insertions
        // needed to convert str[i..j] to a palindrome.
        int table[][] = new int[n][n];
        int l, h, gap;

        // Fill the table
        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap; h < n; ++l, ++h)
                table[l][h] = (s[l] == s[h])? table[l+1][h-1] : (Integer.min(table[l][h-1], table[l+1][h]) + 1);

        // Return minimum number of insertions
        // for str[0..n-1]
        return table[0][n-1];
    }
}
