package stringprograms;

/**
 * Created by Goutam on 8/25/2017.
 */
public class Atoi {
    
    public static boolean isEmpty(String str){
        return((str == null && (str.length() < 1)) ? true : false);
    }
    
    public static boolean isNumeric(char chr){
        return ((chr >= '0' && chr <='9')? true : false);
    }
    
    public static int atoi(String str){
        /*case-1:Check if the String is Empty or NULL*/
        if(isEmpty(str))
            return 0;
        
        /*case-2: handle spaces*/
        str = str.trim();
        
        /*case-3: handle sign character '+'/'-'*/
        char signChar = '+';
        int indexCount = 0;
        if(str.charAt(0) == '-'){
            signChar = '-';
            indexCount++;
        }else if (str.charAt(0) == '+'){
            indexCount++;
        }
        
        /*case-4: handle noNumeric characters, this will also handle the case for floating numbers*/
        /*Store result in Double datatype to avoid overflow of the given number*/
        double result = 0;
        
        /*case-5: calculate the String expression*/
        while(str.length()>indexCount && isNumeric(str.charAt(indexCount))){
            result = result*10 + (str.charAt(indexCount)-'0');
            indexCount++;
        }
        
        /*check for negative Char validation*/
        if(signChar == '-')
            result = -result;
        
        /*case-6: handle MINVALUE and MAXVALUE scenarios*/
        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE; 
        
        if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        
        return (int)result;
    }
    
    public static void main(String args[]){
        String s = "anbd9";
        System.out.print("The integer no corresponding to given String " + s + " is : " + atoi(s));
    }
    
}
