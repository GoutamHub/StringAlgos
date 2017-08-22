package stringprograms;

/**
 * Created by Goutam on 8/22/2017.
 */
public class RotatedString {
    public static boolean validateStrings(String s1, String s2){
        
        if(s1.length()!=s2.length())
            return false;
        
        String clockWise ="";
        String antiClockWise ="";
        
        clockWise = clockWise+s2.substring(2,s2.length())+s2.substring(0,2);
        
        antiClockWise = antiClockWise+s2.substring(s2.length()-2,s2.length())+s2.substring(0,s2.length()-2);
        
        return((clockWise.equals(s1)||antiClockWise.equals(s1))?true:false);
        
    }
    
    public static void main(String args[]){
        String s1 = "AMAZON";
        String s2 = "AZONAM";
        System.out.println(validateStrings(s1,s2)?"YES":"NO");
    }
}
