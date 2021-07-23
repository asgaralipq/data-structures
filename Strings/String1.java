import java.util.*;

public class String1 {
    Scanner sc = new Scanner(System.in);

    private static void occurances(String a) {

        int[] charArr = new int[256];
        for (int i = 0; i < a.length(); i++) {
            charArr[a.charAt(i)] += 1;
        }

        // System.out.println(Arrays.toString(charArr));

        String b = new String();
        for (int i = 0; i < a.length(); i++) {
            if (b.indexOf(a.charAt(i)) == -1) {
                b += a.charAt(i);
            }
        }

        for (int i = 0; i < b.length(); i++) {
            System.out.println(b.charAt(i) + " occurs " + charArr[b.charAt(i)] + " times");
        }
        // for(int i = 0; i < a.length(); i++){
        // Character b = a.charAt(i);
        // int count = 0;
        // for(int j = 0; j < a.length(); j++){
        // if(b == a.charAt(j)){
        // count++;
        // }
        // }
        // System.out.println(b+" occured "+count+" times");
        // }
    }

    private static void removeWhiteSpaces(String a) {

        String b = new String();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != ' ') {
                b += a.charAt(i);
            }
        }

        System.out.println("New String is " + b);

    }

    private static void duplicateChars(String a) {
        for (int i = 0; i < a.length(); i++) {
            for (int j = i + 1; j < a.length(); j++) {
                if (a.charAt(i) == a.charAt(j) && a.charAt(i) != ' ')
                    System.out.println(a.charAt(i) + " is duplicate");
            }
        }
    }

    private static void reverseString(String a) {
        char[] arr = a.toCharArray();

        int i = 0, j = arr.length - 1;

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        System.out.println(new String(arr));

    }

    private static void reverseString(char[] arr, int i, int j) {

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        // System.out.println(new String(arr));
    }

    private static void reverseWord(String a) {

        if (a == null)
            return;

        char[] arr = a.toCharArray();

        int n = arr.length;

        reverseString(arr, 0, n - 1);

        System.out.println(reverseWord(arr, n));

    }

    private static String reverseWord(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < n && a[i] == ' ') {
                i++;
            }
            j = i;
            while (j < n && a[j] != ' ') {
                j++;
            }
            reverseString(a, i, j - 1);
            i = j++;
        }

        return new String(a).substring(0, i);
    }

    private static void reverseIndividual(String a) {
        char[] arr = a.toCharArray();
        int i = 0;
        int j = 0;
        int n = arr.length;
        while (i < n) {
            while (i < n && arr[i] == ' ') {
                i++;
            }
            j = i;
            while (j < n && arr[j] != ' ') {
                j++;
            }
            reverseString(arr, i, j - 1);
            i = j++;
        }
        System.out.println(new String(arr).substring(0, i));
    }

    private static boolean anagram(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] arr = new int[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            arr[b.charAt(i) - 'a']--;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean areRotations(String a, String b) {

        return (a.length() == b.length() && (a + a).indexOf(b) != -1);
    }

    // Hello
    private static String duplicatesInString(String a) {
        char[] arr = a.toCharArray();

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int j = i;
            System.out.println("Out");
            System.out.println("Out i and j " + i + " " + j);
            for (j = 0; j < i; j++) {
                System.out.println("i and j " + i + " " + j);
                if (arr[i] == arr[j]) {
                    break;
                }
            }
            if (i == j) {
                System.out.println("In at" + i);
                arr[count++] = arr[i];
            }
        }

        return String.valueOf(Arrays.copyOf(arr, count));
    }

    private static void longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // System.out.println("Start "+start+" End "+end+" I "+i);
            char c = s.charAt(i);
            int right = i;
            int left = i;

            // System.out.println(right+" R "+left+" left ");
            while (left >= 0 && c == s.charAt(left)) {
                left--;
            }

            while (right < s.length() && c == s.charAt(right)) {
                right++;
            }

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }

            left = left + 1;
            // System.out.println(right+" R "+left+" left 1");
            if ((end - start) < (right - left)) {
                start = left;
                end = right;
            }
            // System.out.println("Start "+start+" End "+end+" I "+i);
            // System.out.println(right+" R "+left+" left 2");

        }

        System.out.println(s.substring(start, end));
        // return s.substring(start, end);
    }

    private static void substrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }

    static void permute(String s, String answer) {
        if (s.length() == 0) {
            System.out.println(answer + "  ");
            System.out.println("Return");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            System.out.println(ch + " charAt "+i);
            String left_substr = s.substring(0, i);
            System.out.println(left_substr + " leftStr ");
            String right_substr = s.substring(i + 1);
            System.out.println(right_substr + " rightStr ");
            String rest = left_substr + right_substr;
            System.out.println(rest + " Rest ");
            permute(rest, answer + ch);
        }
    }

    static void countBinary(String s){
        int count0 = 0, count1 = 0;
        int maxCount = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                count0++;
            }
            else{
                count1++;
            }
            if(count1 == count0){
                maxCount++;
            }
        }

        if(maxCount == 0){
            System.out.println("Can't split");
            return;
        }
        System.out.println("Max Count is: "+maxCount);

    }

    static String reOrganizeString(String s){
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++; 
        }

        int max = 0, letterIndex = 0;

        for(int i = 0; i < 26; i++){
            if(arr[i] > max){
                max = arr[i];
                letterIndex = i;
            }
        }

        if(max > (s.length()+1)/2){
            return "";            
        }

        char[] res = new char[s.length()];
        int idx = 0;
        while(arr[letterIndex] > 0){
            res[idx] = (char) (letterIndex + 'a');
            idx = idx+2;
            arr[letterIndex]--;
        }

        for(int i = 0; i < 26; i++){
            while(arr[i] > 0){
                if(idx > s.length()-1){
                    idx = 1;
                }
                res[idx] = (char)(i + 'a');
                arr[i]--;
                idx = idx + 2;
            }
        }

        return new String(res);
    }

    public static void main(String args[]) {
        String a = new String("Hello");
        // occurances(a);
        // removeWhiteSpaces(a);
        // duplicateChars(a);
        // reverseString(a);
        // reverseWord(a);
        // reverseIndividual(a);
        // System.out.println(areRotations("abcd", "dbca"));
        // System.out.println(duplicatesInString(a));
        // longestPalindrome("aaaabbaa");
        // substrings("abc");
        // permute("abc", "");
        // countBinary("0100110101");
        System.out.println(reOrganizeString("aaabc"));
    }
}