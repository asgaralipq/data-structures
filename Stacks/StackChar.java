import java.util.Stack;

class StackChar{
 
    private static void reverseString(String s){
        Stack stack = new Stack();
        for(int i = 0; i < s.length() - 1; i++){
            stack.push(s.charAt(i));
        }
        
        for(int i = 0; i < stack.size() - 1; i++){
            System.out.print(stack.pop());
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '['){
                stack.push(']');
            }
            else if(c == '('){
                stack.push(')');
            }
            else if(c == '{'){
                stack.push('}');
            }
            else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        
        return stack.isEmpty();
    }
    public static void main(java.lang.String[] args){

    





    }
}
