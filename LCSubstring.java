package stringprograms;

import java.util.ArrayList;

/**
 * Created by Goutam on 8/24/2017.
 */
public class LCSubstring {
    
    public static void LCSubstring(String s1, String s2, int m, int n){
        int maxLength = Integer.MIN_VALUE;
        ArrayList<String> resultString = new ArrayList<>();
        int matchMatrix[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(s1.charAt(i)== s2.charAt(j)){
                    if(i==0 || j==0)
                        matchMatrix[i][j] = 1;
                    else 
                        matchMatrix[i][j] = matchMatrix[i-1][j-1]+1;
                    
                    if(matchMatrix[i][j] > maxLength){
                        maxLength = matchMatrix[i][j];
                        resultString.add(s1.substring(i-maxLength+1,i+1));
                        /*Substring Starts at Index= and Ends at Index= i
                        * but, Since Substring property exclude the last char so put endIndex as= i+1*/
                    }
                    else if(matchMatrix[i][j] == maxLength){
                        resultString.add(s1.substring(i-maxLength+1,i+1)); 
                    }
                    
                }else{
                    matchMatrix[i][j] = 0;
                }
            }
        }
        if(resultString.isEmpty())
            System.out.println("No Common substring existis between given Strings");
        else {
            System.out.print("Length of Longest Common Substring is: " + maxLength + " And the SubString is: ");
            for(int k =0; k<resultString.size(); k++){
                if(resultString.get(k).length() == maxLength)
                    System.out.print(" "+ resultString.get(k));
            }
        }
    }
    
    public static void main(String args[]){
        String s1 = "LCLC";
        String s2 = "CLCL";
        LCSubstring(s1, s2, s1.length(), s2.length());
    }
}
