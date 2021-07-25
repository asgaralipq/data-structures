import java.util.*;
// class Stack{
//     int top;
//     int max = 1000;
//     int[] a = new int[max];

//     Stack() {
//         top = -1;
//     }

//     boolean isEmpty() {
//         return top < 0;
//     }

//     int size()
//     {
//         return top + 1;
//     }

//     int search(int x){
//         if(top == -1){
//             System.out.println("Underflow");
//             return -1;
//         }

//         int pos = -1;
//         for(int i = 0; i <= top; i++){
//             if(a[i] == x){
//                 pos = i;
//                 System.out.println("Found at "+pos);
//                 return pos;
//             }
//         }

//         System.out.println("Not found");
//         return -1;
//     }

//     private boolean push(int x) {
//         if (top == max - 1) {
//             System.out.println("Overflow");
//             return false;
//         } else {
//             a[top++] = x;
//             return true;
//         }
//     }

//     private int pop() {
//         if (top == -1) {
//             System.out.println("Underflow");
//             return 0;
//         } else {
//             int x = a[top--];
//             return x;
//         }
//     }

//     private int peek() {
//         if (top == -1) {
//             System.out.println("Underflow");
//             return 0;
//         } else {
//             int x = a[top];
//             return x;
//         }
//     }
// }

class Stack1 {

    private static void reverseString(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length() - 1; i++) {
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < stack.size() - 1; i++) {
            System.out.print(stack.pop());
        }
    }

    private static java.util.Stack<Integer> recur(java.util.Stack<Integer> s, int n) {

        if (s.isEmpty()) {
            s.push(n);
        } else {
            int x = s.peek();

            s.pop();

            s = recur(s, n);

            s.push(x);
        }

        return s;
    }

    private static void insertAtEnd(java.util.Stack<Integer> s, int n) {

        s = recur(s, n);

        while (!s.isEmpty())
            System.out.println(s.pop());

    }

    private static void reverse(java.util.Stack<Integer> s) {

        if (s.size() > 0) {
            int x = s.peek();
            s.pop();
            reverse(s);
            s = recur(s, x);
        }
        // while(!s.isEmpty())
        // System.out.println(s.pop());
    }

    private static void printStack(java.util.Stack<Integer> s) {
        while (!s.isEmpty())
            System.out.println(s.pop());
    }

    public static void main(java.lang.String[] args) {

        // reverseString("Hello World");
        java.util.Stack<Integer> s = new java.util.Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // insertAtEnd(s, 8);
        reverse(s);
        printStack(s);

    }
}

