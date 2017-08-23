package stringprograms;

/**
 * Created by Goutam on 8/23/2017.
 */
public class RomanToInteger {
    
    int intValue(char r){
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
    
    private int convert2Integer(String str){
        int currentResult =0;
        for(int i=0; i<str.length(); i++){
            int charValue1 = intValue(str.charAt(i));
            if(i+1<str.length()) {
                int charValue2 = intValue(str.charAt(i + 1));
                if(charValue1>= charValue2){
                    currentResult = currentResult+charValue1;
                }else{
                    currentResult = currentResult + charValue2 - charValue1;
                    i++;
                }
            } else {
                currentResult = currentResult + charValue1;
                i++;
            }
        }
        return currentResult;    
    }
    
    public static void main(String args[]){
        RomanToInteger rti = new RomanToInteger();
        String s = "MCMIV";
        System.out.println("The Integer value of given Roman String is: " + rti.convert2Integer(s));
    }
}
