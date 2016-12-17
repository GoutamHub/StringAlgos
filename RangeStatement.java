import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Goutam on 15-12-2016.
 */
public class RangeStatement {
   public static boolean bs(int len, ArrayList<String> list, double searchValue) {
      int first = 0;
      int last = len - 1;
      int mid = (first + last) / 2;
      while (first <= last) {
         if (Double.parseDouble(list.get(mid)) > searchValue)
            last = mid - 1;
         else if (Double.parseDouble(list.get(mid)) == searchValue)
            return true;
         else
            first = mid + 1;
         mid = (first + last) / 2;
      }
      if (first > last) {
         return false;
      }
      return false;
   }

   public static boolean bs(ArrayList<String> minlist, ArrayList<String> maxlist, double searchValue, int len) {
      int first = 0;
      int last = len - 1;
      int mid = (first + last) / 2;
      while (first <= last) {
         if (Double.parseDouble(minlist.get(mid)) > searchValue)
            last = mid - 1;
         else if (searchValue >= Double.parseDouble(minlist.get(mid)) && searchValue <= Double
                        .parseDouble(maxlist.get(mid)))
            return true;
         else if (Double.parseDouble(maxlist.get(mid)) < searchValue)
            first = mid + 1;
         mid = (first + last) / 2;
      }
      if (first > last) {
         return false;
      }
      return false;
   }

   public static void main(String args[]) {
      String inputString = "2.6 .. 4 | 7.9..10| 16 | 20 .. 30| 45.8 ";
      ArrayList<String> minList = new ArrayList<>();
      ArrayList<String> maxList = new ArrayList<>();
      ArrayList<String> loanValue = new ArrayList<>();
      int n = 0;
      if (inputString.trim().contains("|")) {
         String s[] = inputString.split("\\|");
         n = s.length;
         System.out.println(Arrays.toString(s));
         System.out.println(n + "");
         for (int i = 0; i < n; i++) {
            if (s[i].trim().contains("..")) {
               String temp[] = s[i].split("\\.\\.");
               minList.add(temp[0].trim());
               maxList.add(temp[1].trim());
            } else {
               loanValue.add(s[i].trim());
            }
         }

         int len = minList.size();
         System.out.println(minList);
         System.out.println(maxList);
         System.out.println(loanValue);
         System.out.println(len + " ");
         int mid = len / 2;
         System.out.println(mid + " ");
         double inputValue = 2.7;
         int len1 = loanValue.size();
         double boundayMax = 0;
         if (Double.parseDouble(loanValue.get(len1 - 1)) > Double.parseDouble(maxList.get(len - 1))) {
            boundayMax = Double.parseDouble(loanValue.get(len1 - 1));
         } else {
            boundayMax = Double.parseDouble(loanValue.get(len1 - 1));
         }
         if (inputValue < Double.parseDouble(minList.get(0)) || inputValue > boundayMax) {
            System.out.println("Given input is out of range statement");
         } else {
            int loanValueLen = loanValue.size();
            boolean found = bs(loanValueLen, loanValue, inputValue);
            System.out.println("Value found : " + found);
            if (!found) {
               boolean ultiFound = bs(minList, maxList, inputValue, len);
               System.out.println("Value found ultimately: " + ultiFound);
            }
         }

      }
   }
}
