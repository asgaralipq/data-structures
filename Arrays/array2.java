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

        System.out.println("Union "+Arrays.asList(unionArr(arr1, arr2)));

        sc.close();

    }
    static int index=0;
    public static Integer[] unionArr(Integer[] arr1, Integer[] arr2){

        Integer[] arr3 = new Integer[arr1.length];
        Integer[] arr4 = new Integer[arr2.length];
        Integer[] counter=new Integer[arr1.length + arr2.length];
        Integer[] arr5=new Integer[arr1.length + arr2.length];

        
        arr3=findUnion(arr1, counter, index);
        arr4=findUnion(arr2, counter, index+arr3.length);
        
        arr5=merge(arr3,arr4);
        return arr5;
    }

    public static Integer[] merge(Integer[] a, Integer[] b){
        Integer[] c = new Integer[a.length+b.length];
        int i;
        for(i=0; i<a.length; i++)
            c[i] = a[i];
      
        for(int j=0; j<b.length; j++)
            c[i++]= b[j];
            return c;
      }

    public static Integer[] findUnion(Integer[] arr, Integer[] counter, int index){
        
        Integer[] arrReturn = new Integer[arr.length];
        for(int i=0; i<arr.length; i++){

            System.out.println("findUnion()"+ i);
            if(repeated(arr[i], counter, index) == false){
                arrReturn[i]=arr[i];
                System.out.println(arrReturn[i]);
            }
            index++;
        }
        return arrReturn;
    }

    public static boolean repeated(Integer value, Integer[] counter, int index){
        int flag=0;
        int repeat=0;
        counter[index]=value;
        System.out.println("Index "+index);
        for(int i=0; i<counter.length; i++){

            if(value==counter[i]){
                repeat++;
            };
            System.out.println(Arrays.asList(counter));
            System.out.println(value+" "+repeat);
            if(repeat>1){
                flag=1;
                break;
            }
        }
        if(flag==0){
            return false;
        }
        else{
            return true;
        }
    }

    public static HashSet<Integer> unionArr1(Integer arr1[], Integer arr2[]){

        HashSet<Integer> hash = new HashSet<>();
        
        hash.addAll(Arrays.asList(arr1));
        hash.addAll(Arrays.asList(arr2));

        return hash;
    }
}
