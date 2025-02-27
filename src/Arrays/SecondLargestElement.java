package Arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2};
        findLargestAndSecondLargest(arr);
        findSmallestandSecondSmallest(arr);
    }

    private static void findSmallestandSecondSmallest(int[] arr) {
        int smallest = arr[0];
        int sSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length ; i++) {
            if(arr[i] < smallest){
                sSmallest = smallest;
                smallest = arr[i];
            } else if(arr[i] >= smallest && arr[i] < sSmallest){
                sSmallest = arr[i];
            }
        }
        System.out.println("Smallest: " + smallest + " -- Second Smallest: "+ sSmallest);
    }

    private static void findLargestAndSecondLargest(int[] arr) {
        int largest = arr[0];
        int sLargest = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > largest){
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > sLargest){
                sLargest = arr[i];
            }
        }
        System.out.println("Largest: " + largest + " -- Second Largest: "+ sLargest);
    }
}
