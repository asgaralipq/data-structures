import java.util.*;

public class array2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array1");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter array2");
        int n1 = sc.nextInt();
        int[] arr2 = new int[n1];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println("Union " + Arrays.asList(unionArr(arr1, arr2)));

        sc.close();

    }

    static int index = 0;

    public static int[] unionArr(int[] arr1, int[] arr2) {

        int[] arr3 = new int[arr1.length];
        int[] arr4 = new int[arr2.length];
        int[] counter = new int[arr1.length + arr2.length];
        int[] arr5 = new int[arr1.length + arr2.length];

        arr3 = findUnion(arr1, counter, index);
        arr4 = findUnion(arr2, counter, index + arr3.length);

        arr5 = merge(arr3, arr4);
        return arr5;
    }

    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i;
        for (i = 0; i < a.length; i++)
            c[i] = a[i];

        for (int j = 0; j < b.length; j++)
            c[i++] = b[j];
        return c;
    }

    public static int[] findUnion(int[] arr, int[] counter, int index) {

        int[] arrReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            System.out.println("findUnion()" + i);
            if (repeated(arr[i], counter, index) == false) {
                arrReturn[i] = arr[i];
                System.out.println(arrReturn[i]);
            }
            index++;
        }
        return arrReturn;
    }

    public static boolean repeated(int value, int[] counter, int index) {
        int flag = 0;
        int repeat = 0;
        counter[index] = value;
        System.out.println("Index " + index);
        for (int i = 0; i < counter.length; i++) {

            if (value == counter[i]) {
                repeat++;
            }
            ;
            System.out.println(Arrays.asList(counter));
            System.out.println(value + " " + repeat);
            if (repeat > 1) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static HashSet<Integer> unionArr1(Integer arr1[], Integer arr2[]) {

        HashSet<Integer> hash = new HashSet<>();

        hash.addAll(Arrays.asList(arr1));
        hash.addAll(Arrays.asList(arr2));

        return hash;
    }
}
