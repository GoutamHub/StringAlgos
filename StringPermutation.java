/**
 * Created by Goutam on 8/21/2017.
 */
public class StringPermutation {
    private static void permute(String str, int l, int r){
        if(l==r)
            System.out.println(str);
        else{
            for(int i=l; i<=r; i++){
                str = doSwap(str,l,i);
                permute(str,l+1, r);
                str = doSwap(str,l,i);
            }
        }
    }
    
    public static String doSwap(String a, int i, int j){
        char tempVar;
        char arr[] = a.toCharArray();
        tempVar = arr[i];
        arr[i] = arr[j];
        arr[j] = tempVar;
        return String.valueOf(arr);
    }
    
    public static void main(String args[]) {
        String str = "ABC";
        int n = str.length();
        StringPermutation permutation = new StringPermutation();
        StringPermutation.permute(str, 0, n-1);
    }
}
