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

        int[] array3 = intersect(array1, array2); 

        System.out.println();
        for(int i = 0; i < array3.length; i++){
            System.out.println(array3[i]);
        }

        int[] array4 = union(array1, array2); 

        System.out.println();
        for(int i = 0; i < array4.length; i++){
            System.out.println(array4[i]);
        }
    }
}
