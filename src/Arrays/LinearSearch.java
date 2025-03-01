package Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {6, 9, 14, 15, 8, 10, 11, 12, 13, 7};
        int search = 9;
        int index = findElements(arr, search);
        System.out.println(  index == -1
                ? "The element is not found" : "The element is found at position " + index );
    }

    private static int findElements(int[] arr, int search) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == search){
                return i + 1;
            }
        }
        return -1;
    }
}
