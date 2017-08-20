/**
 * Created by Goutam on 8/19/2017.
 */
public class MatchParentheses {
    
    /*Will hold all the basic utility function for LIFO phenomenon*/
    static class stack{
        int top=-1;
        char stack[] = new char[100];
        
        /*PUSH Operation*/
        public void push(char chr){
            if(top == 99)
                System.out.println("Stack is in Overloading State..");
            else
                stack[++top] = chr;
        }
        
        /*POP Operation*/
        public char pop() {
          if(isEmpty()){
              System.out.println("The Stack is Empty");
              return '\0';
          }
          return (stack[top--]);
        }
        
        /*ISEMPTY Operation*/
        public boolean isEmpty() {
            return (top == -1 ? true : false);
        }
        
    }
    
    /*Will decide the match between two char exp1 and exp2*/
    public static boolean isMatch(char exp1, char exp2){
        return (((exp1 == '(' && exp2 == ')')|| (exp1 == '{' && exp2 == '}')|| (exp1 == '[' && exp2 == ']'))?true:false);
            
    }
    
    /*will take each char from the expression String and check
     * whether its a starting brace or closing and based on that
     * (1)PUSH or (2)POP or (3)ISEMPTY operation will be performed
     * and call will go to isMatch(exp1,exp2) from here*/
    public static boolean isBalanced(char expression[]){
        stack obj = new stack();
        for(int i=0; i<expression.length; i++){
            if(expression[i] == '('||expression[i] == '{'||expression[i]=='[')
                obj.push(expression[i]);
            else if(expression[i] == ')'||expression[i] == '}'||expression[i]==']'){
                if(obj.isEmpty())
                    return false;
                if(!isMatch(obj.pop(), expression[i]))
                    return false;
            }
        }
        return (obj.isEmpty()?true:false);
    }
    
    /*Driver Function to start execution of the program
    * this will call the isBalanced(expr) method */
    public static void main(String args[]){
        char expression[] = new char[]{'{','(',')','}','[',']'};
        if(isBalanced(expression))
            System.out.println("The expression is having balanced Parentheses");
        else
            System.out.println("The expression is not having balanced Parentheses");
    }
}
