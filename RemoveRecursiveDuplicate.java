package stringprograms;

/**
 * Created by Goutam on 8/21/2017.
 */
public class RemoveRecursiveDuplicate {
    public static class Stack{
        char arr[] = new char[100];
        int top = -1;
        void push(char ch){
            if(isFull()){
                System.out.println("Stack is Full");
                return;
            }
            arr[++top]=ch;
        }
        char pop(){
            if(isEmpty()){
                System.out.println("Stack is Empty");
                return '\0';
            }
            return(arr[top--]);
        }
        
        char peekElement(int top){
            return (arr[top]);
        }
        
        boolean isEmpty(){
            return (top ==-1?true:false);
        }
        
        boolean isFull(){
            return (top ==99?true:false); 
        }
        
        void printReverse(int top){
            if(isEmpty()) {
                System.out.println("Nothing there in Stack");
                return;
            }
            char temp;
            temp = pop();
            printReverse(top);
            StringBuilder sb = new StringBuilder();
            sb.append(temp);
            System.out.print(sb);
        }
    }
    
    public static void removeDuplicate(String str, int start, int end){
        char arr[] = str.toCharArray();
        Stack s = new Stack();
        s.push(arr[0]);
        for(int i=1; i<end; i++) {
            if(arr[i-1] != arr[i] && arr[i] != s.peekElement(s.top)) {
                s.push(arr[i]);
                continue;
            }
            if(!s.isEmpty() && arr[i] == s.peekElement(s.top))
                s.pop();
        }
        s.printReverse(s.top);
        
    }
    
    public static void main(String args[]){
        String s = "azuuuuzzzxxa";
        removeDuplicate(s, 0, s.length());
    }
}
