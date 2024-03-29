import java.math.BigInteger;
import java.util.*;

public class array3 {


    static int[] union(int arr1[], int arr2[]){
        int[] inter = new int[arr1.length+arr2.length];
        int i = 0;
        System.out.println(arr1.length);
        for(i = 0; i < arr1.length; i++){
            inter[i] = arr1[i];
        }

        System.out.println("Here i is: "+i);
        for(int k = 0; k < arr2.length; k++){
            int flag  = 1;
            for(int j = 0; j < arr1.length; j++){
                if(arr2[k] == arr1[j]){
                    // System.out.println("Here check is: "+arr2[k]+" with "+arr1[j]);
                    flag = 0;
                }
            }
            if(flag == 1){
                // System.out.println("Here add is: "+arr2[k]);
                inter[i] = arr2[k];
                i++;
            }
        }

        return inter;
    }

    static int[] rotate(int arr1[]){

        // System.out.println(arr1.length-1);
        int x = arr1[arr1.length-1];

        for(int i = arr1.length - 1; i > 0; i--){
            // int n = arr1[i];
            arr1[i] = arr1[i - 1];
        }

        arr1[0] = x;

        return arr1;

    }

    static int findMissingNumber(int arr[]){
        int n = arr.length;
        int m = n+1;
        int sum = (m*(m+1))/2;
        int sum1 = 0;

        for(int i = 0; i<n; i++){
            sum1 = sum1 + arr[i];
        }

        return sum-sum1;
    }

    static int countSumCheck(int arr[]){
        int sum = 6;
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                    if(arr[i]+arr[j]==sum){
                        count++;
                    }
                }
            }
        return count;
    }

    static void countSumPairPrint(int arr[]){
        int sum = 6;
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                    if(arr[i]+arr[j]==sum){
                        System.out.println(arr[i]+" "+arr[j]);
                    }
                }
            }
    }

    static int[] intersect(int arr1[], int arr2[]){
        int[] inter = new int[10];
        int n = 0;

        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2.length; j++){
                if(arr1[i] == arr2[j]){
                    inter[n] = arr1[i];
                    n++;
                }
            }
        }

        return inter;
    }

    static int[] duplicates(int arr[]){
        int[] arr1 = new int[10];
        int n = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j < arr.length; j++){

                if(arr[i] == arr[j]){
                    arr1[n++] = arr[i];
                    break;
                }
            }
        }

        return arr1;
    }

    static void quickSort(int arr[], int start, int end){


        if(start >= end){
            return;
        }

        int pivot = partition(arr, start, end);

        quickSort(arr, start, pivot - 1);

        quickSort(arr, pivot + 1, end);
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int arr[], int start, int end){

        int pivot = arr[end];

        int pIndex = start;

        for ( int i = start; i < end; i++ ){

            if(arr[i] <= pivot){

                swap(arr, i, pIndex);
                pIndex++;
            }
        }

        swap(arr, end, pIndex);

        return pIndex;
    }

    public static int[] commonOfThree(int arr1[], int arr2[], int arr3[]){

        int temp[] = intersect(arr1, arr2);
        int temp2[] = intersect(temp, arr3);
        return temp2;

    }

    public static int duplicatesOnce(int arr[]){

        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    int data = arr[i];
                    return data;
                }
            }
        }
        return -1;
    }

    public static int duplicatesOnceNotRepeat(int arr[]){

        int flag = 0;
        for(int i = 0; i < arr.length; i++){
            flag = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j] && i != j){
                    flag = 1;
                }
            }
            if(flag == 0){
                int data = arr[i];
                return data;
            }
        }
        return -1;
    }

    public static boolean contains(int a[], int num){

        for(int i: a){
            if(i == num){
                return true;
            }
        }
        return false;
    }

    public static int subsequence(int a[]){
        int currentCount = 0;
        int maxCount = 0;

        for(int i : a){
            int num = i;
            currentCount = 1;
            while(contains(a, num+1)){
                num++;
                currentCount += 1;
            }
            if(currentCount > maxCount){
                maxCount = currentCount;
            }
        }
        return maxCount;
    }

    public static void countOccurence(int[] a) 
    {
        if(a.length == 0){
            return;
        }
        int count1 = 0, count2 = 0;
        int number1 = a[0], number2 = a[0];
        // List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < a.length; i++){

            if(number1 == a[i]){
                count1++;
            }
            else if(number2 == a[i]){
                count2++;
            }
            else if(count1 == 0){
                number1 = a[i];
                count1 = 1;
            }
            else if(count2 == 0){
                number2 = a[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] == number1){
                count1++;
            }
            else if(a[i] == number2){
                count2++;
            }
        }
        if(count1 > a.length/3){
            System.out.println(number1);
        }
        if(count2 > a.length/3){
            System.out.println(number2);
        }
    }


    public int maxProfit3(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        
        for(int i : prices){
            release2 = Math.max(release2, hold2+i);
            hold2 = Math.max(hold2, release1-i);
            release1 = Math.max(release1, hold1+i);
            hold1 = Math.max(hold1, -i);
        }
        return release2;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        
        for(int i = 1; i < prices.length; i++)
            profit += Math.max(0, prices[i] - prices[i-1]);
        
        return profit;
    }
    

    public int maxProfit1(int[] prices) {
        int release = 0;
        int hold = Integer.MIN_VALUE;
        
        for(int i : prices){
            release = Math.max(release,hold+i);
            hold = Math.max(hold, -i);
        }
        
        return release;
    }

    public static int findDuplicate(int[] nums){
        int count;
        int repeat;
        for(int i : nums){
            count = 0;
            repeat = i;
            for(int j = 0; j < nums.length; j++){
                if(repeat == nums[j]){
                    count++;
                }
                if(count == 2){
                    return repeat;
                }
            }
        }
        return -1;
    }

    public static String isSubset( int a1[], int a2[], int n, int m) {
        int y = 0;
        int j;
        for(int i = 0; i < m; i++){
            for(j = 0; j < n; j++){
                System.out.println("a2[i] "+a2[i]+" a1[j] "+a1[j]);
                if(a2[i] == a1[j]){
                    y = 1;
                    break;
                }
            }
            if(j == n){
                y = 0;
                break;
            }
        }
        if(y == 1){
            return "Yes";
        }else{
            return "No";
        }
            
        }

    public int findMin(int[] a) {
        int left = 0;
        int right = a.length - 1;
        
        while(a[left] > a[right]){
            int middle = (left + right) / 2;
            
            if(a[middle] >= a[left])
                left = middle + 1;
            else
                right = middle;
        }
        
        return a[left];
    }

    public static void largest(int a[]){

        int first,second,third;

        first = second = third = Integer.MIN_VALUE;

        for(int i = 0; i < a.length; i++){
            if(a[i] > first){
                third = second;
                second = first;
                first = a[i];
            }
            else if(a[i] > second){
                third = second;
                second = a[i];
            }
            else if(a[i] > third){
                third = a[i];
            }
        }
        System.out.println(first+" "+second+" "+third);
        
    }

    public static int partitionR(int a[]){

        int j = 0;
        int pivot = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] < pivot){
                swap(a, i , j);
                j++;
            }
        }

        return j;
    }

    public static void reArrange(int a[]){

        int p = partitionR(a);
    
        for(int n = 0; p < a.length && n < p; p++, n += 2){
            swap(a, n, p);
        }
    }

    public static void zeroSum(int arr[]){

        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length; j++){
                sum = sum + arr[j];
                // System.out.println(sum+" i "+i+" j "+j);
                if(sum == 0){
                    System.out.println("Found");
                    return;
                }
            }
        }
        System.out.println("Not found");
    }

    public static void maximumSubArray(int arr[]){

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i : arr){

            currSum += i;

            if(currSum > maxSum){
                maxSum = currSum;
            }

            if(currSum < 0){
                currSum = 0;
            }
        }

        System.out.println(maxSum);
    }

    public static void maximumProdSubArray(int arr[]){

        int max = arr[0];

        for(int i = 0; i < arr.length; i++){
            int sum = arr[i];
            for(int j = i+1; j < arr.length; j++){

                if(sum > max){
                    max = sum;
                }
                sum *= arr[j];
            }
        }

        System.out.println(max);
    }

    public static int multiplyF(int fact, int res[], int resSize){

        int carry = 0;

        for(int i = 0; i < resSize; i++){
            
            int prod = res[i] * fact + carry;

            res[i] = prod % 10;
            carry = prod / 10;
            
        }

        while(carry != 0){
            res[resSize] = carry % 10;
            carry = carry / 10;
            resSize++;
        }

        return resSize;
    }

    public static void bigFact(int n){
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++)
            fact = fact.multiply(BigInteger.valueOf(i));
        System.out.println(fact);
    }

    public static void factorial(int n){
        int res[] = new int[500];

        res[0] = 1;
        int resSize = 1;

        for(int i=2; i<=n; i++){
            resSize = multiplyF(i, res, resSize );
        }

        System.out.println("Factrorial is");
        for(int i = resSize-1; i >= 0; i--){
            System.out.print(res[i]);
        }
    }

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        System.out.println("Array 1");

        int n = sc.nextInt();
        int[] array1 = new int[n];

        for(int i = 0; i < n; i++){
            array1[i] = sc.nextInt();
        }
        
        System.out.println("Array 2");

        n = sc.nextInt();

        int[] array2 = new int[n];

        for(int i = 0; i < n; i++){
            array2[i] = sc.nextInt();
        }

        // System.out.println("Array 3");

        // n = sc.nextInt();

        // int[] array3 = new int[n];

        // for(int i = 0; i < n; i++){
        //     array3[i] = sc.nextInt();
        // }

        // int[] array3 = intersect(array1, array2); 

        // System.out.println();
        // for(int i = 0; i < array3.length; i++){
        //     System.out.println(array3[i]);
        // }

        // int[] array4 = union(array1, array2); 

        // System.out.println();
        // for(int i = 0; i < array4.length; i++){
        //     System.out.println(array4[i]);
        // }

        // int arrR[] = rotate(array1);

        // for (int i = 0; i < arrR.length; i++){
        //     System.out.println(arrR[i]);
        // }

        // System.out.println("Remaining number is "+findMissingNumber(array1));

        // System.out.println("Count Sum "+countSumCheck(array1));

        // quickSort(array1, 0, array1.length - 1);

        // System.out.println(Arrays.toString(array1));

        // System.out.println(Arrays.toString(duplicates(array1)));

        // System.out.println("Common of 3 "+Arrays.toString(commonOfThree(array1, array2, array3)));

        // System.out.println("Duplicate is "+(duplicatesOnce(array1)));

        // System.out.println("Duplicate is "+(duplicatesOnceNotRepeat(array1)));

        // largest(array1);

        // reArrange(array1);

        // System.out.println(Arrays.toString(array1));

        // countSumPairPrint(array1);

        // zeroSum(array1);

        // maximumSubArray(array1);

        // bigFact(100);
    
        // maximumProdSubArray(array1);

        // subsequence(array1);

        // countOccurence(array1);

        // findDuplicate(array1);

        System.out.println(isSubset(array1, array2, array1.length, array2.length));
    }
}
