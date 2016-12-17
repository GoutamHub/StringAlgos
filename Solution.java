/**
 * Created by Goutam on 17-12-2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String s = in.next();
      if (s == null) {
         System.out.println("null string is not accepted");
         return;  
      }
      int stringLength = s.length();
      if (stringLength <1 || stringLength >100) {
         System.out.println("Given input is not in specified Length");
         return;
      }
      Pattern pattern = Pattern.compile("^([a-z]+_)+[a-z]+$");
      Matcher m = pattern.matcher(s);
      boolean matchResult = m.matches();
      if (!matchResult){
         System.out.println("Given input is not maintaining specified pattern constraint");
         return;
      } else {
         String stringArray[] = s.split("_");
         int len = stringArray.length;
         System.out.println(len);
      }
   }
}

