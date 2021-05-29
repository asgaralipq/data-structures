import java.util.*;

public class array2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array1");
        int n=sc.nextInt();
        Integer[] arr1 = new Integer[n];
        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter array2");
        int n1=sc.nextInt();
        Integer[] arr2 = new Integer[n1];
        for(int i=0; i<arr2.length; i++){
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println("Union "+unionArr(arr1, arr2));

        sc.close();

    }

    public static HashSet<Integer> unionArr(Integer arr1[], Integer arr2[]){

        HashSet<Integer> hash = new HashSet<>();
        
        hash.addAll(Arrays.asList(arr1));
        hash.addAll(Arrays.asList(arr2));

        return hash;
    }
}
