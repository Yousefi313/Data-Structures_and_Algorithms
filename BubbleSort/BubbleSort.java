package BubbleSort;

public class BubbleSort {

  public static void main(String[] args) {

    int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
    int size = arr.length;
    int temp = 0;

    System.out.println("Original Array: ");
    System.out.println(java.util.Arrays.toString(arr));

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // swap arr[j] and arr[j+1]
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    System.out.println("Sorted Array: ");
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}