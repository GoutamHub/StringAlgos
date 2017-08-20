/**
 * Created by Goutam on 8/19/2017.
 */
public class ReverseWords {
    static String expression = "My name is Goutam";

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // split to words by space
        String[] arr = s.split(" ");
        /*StringBuilder should be used to avoid creating too many Strings. 
        If the string is very long, using String is not scalable since String is immutable 
        and too many objects will be created and garbage collected.*/
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1).trim();
    }


    public static String reverseWordChars(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // split to words by space
        String[] arr = s.split(" ");
        /*StringBuilder should be used to avoid creating too many Strings. 
        If the string is very long, using String is not scalable since String is immutable 
        and too many objects will be created and garbage collected.*/
        for(int i=0; i<arr.length; i++) {
            char newArray[] = arr[i].toCharArray();
            int lowIndex = 0;
            int highIndex = newArray.length-1;
            while (highIndex > lowIndex) {
                char temp = newArray[lowIndex];
                newArray[lowIndex] = newArray[highIndex];
                newArray[highIndex] = temp;
                highIndex--;
                lowIndex++;
            }
            arr[i] = String.valueOf(newArray);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1).trim();
    }
    
    public static void main(String args[]) {
      String output = reverseWordChars(expression);
      System.out.println(output);
    }
}
