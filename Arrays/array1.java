import java.util.*;

public class array1{

    static Scanner sc=new Scanner(System.in);

    public static void main(String arr[]){
        
        int n;
        n=sc.nextInt();
        int[] arr1=new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }

        //Function calls
       // printArr(arr1);
       // System.out.println("Element returned "+search(arr1));
       // System.out.println("Min-Max "+Arrays.toString(minMax(arr1)));
       // System.out.println("Reverse "+Arrays.toString(reverse(arr1)));
       // System.out.println("Sort "+Arrays.toString(sort(arr1)));
       // System.out.println("Min-Max "+Arrays.toString(minMaxK(arr1)));
       // System.out.println("Occurances "+occurances(arr1));
       //System.out.println("Sort ZeroOneTwo "+Arrays.toString(sortZeroOneTwo(arr1)));
       //System.out.println("Range returned "+range(arr1));
       System.out.println("Sort "+Arrays.toString(moveNegatives(arr1)));
    }

    public static void printArr(int arr1[]){
        System.out.println("\nPrint");
        for(int i=0; i<arr1.length; i++){
            System.out.println(arr1[i]);
        }
    }

    public static int search(int arr1[]){
        System.out.println("\nEnter search element");
        int ele=sc.nextInt();
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] == ele){
                return ele;
            }
        }
        return -1;
    }

    public static int[] minMax(int arr1[]){
        System.out.println("\nMin-Max");
        int min=arr1[0];
        int max=arr1[0];
        for(int i=0; i<arr1.length; i++){
            if(min > arr1[i]){
                min = arr1[i];
            }
            if(max < arr1[i]){
                max = arr1[i];
            }
        }
        return new int[]{min,max}; 
    }

    public static int[] reverse(int arr1[]){
        System.out.println("\nReverse");
        int[] rev = new int[arr1.length];
        int len=arr1.length-1;

        for(int i=0; i<arr1.length; i++){
            rev[i]=arr1[len];
            len--;    
        }
        return rev;
    }

    public static int[] sort(int arr1[]){
        System.out.println("\nSort");
        int[] sorted = arr1.clone();

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1.length; j++){
                if(sorted[i]<sorted[j]){
                    int temp=sorted[i];
                    sorted[i]=sorted[j];
                    sorted[j]=temp;
                }
            }
        }
        return sorted;
    }

    public static int[] minMaxK(int arr1[]){
        System.out.println("\nMin-MaxK");
        int min=arr1[0];
        int max=arr1[0];

        int[] sorted = sort(arr1);
        System.out.println("\nEnter K");
        int k = sc.nextInt();
        min = sorted[k-1];
        max = sorted[sorted.length-k];
        return new int[]{min,max}; 
    }

    public static int occurances(int arr1[]){
        System.out.println("\nEnter search element");
        int ele=sc.nextInt();
        int count=0;
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] == ele){
                count++;
            }
        }
        return count;
    }

    public static int modifiedOccurances(int arr1[], int ele){
        int count=0;
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] == ele){
                count++;
            }
        }
        return count;
    }

    public static int[] sortZeroOneTwo(int arr1[]){
        System.out.println("\nSort");
        int zero=modifiedOccurances(arr1, 0);
        int one=modifiedOccurances(arr1, 1);
        int two=modifiedOccurances(arr1, 2);
        int[] sorted = new int[arr1.length];

        int i=0;
        for(i=0; i<zero; i++){
            sorted[i]=0;
        }
        for(i=zero; i<zero+one; i++){
            sorted[i]=1;
        }
        for(i=zero+one; i<zero+one+two; i++){
            sorted[i]=2;
        }
        return sorted;
    }

    public static int range(int arr1[]){
        System.out.println("\nRange");
        int min=minMax(arr1)[0];
        int max=minMax(arr1)[1];

        int range = max - min;
        
        return range;
    }

    public static int[] moveNegatives(int arr1[]){
        System.out.println("\nMove Negatives");
        int[] sorted = arr1.clone();

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1.length; j++){
                if(sorted[i]<sorted[j] && sorted[j]>0){
                    System.out.println("Swapping "+sorted[i]+" "+sorted[j]);
                    int temp=sorted[i];
                    sorted[i]=sorted[j];
                    sorted[j]=temp;
                    break;
                }
            }
        }
        return sorted;
    }

}

