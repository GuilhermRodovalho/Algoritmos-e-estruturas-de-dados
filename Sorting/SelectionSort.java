/**
 * This code is the implementation of the inplace sorting algorithm, Selection
 * Sort. Runs in a O(n^2) time, and O(1) space.
 * 
 * @author Guilherme R. Rodovalho
 */

public class SelectionSort {
  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int pos = i;

      int j;
      for (j = i; j < array.length; j++) {
        if (array[j] < array[pos]) {
          pos = j;
        }
      }

      if (pos != i) {
        int temp = array[i];
        array[i] = array[pos];
        array[pos] = temp;
      }

    }
  }

  public static void main(String[] args) {
    int[] array = { 4, 56, 23, 12, 57, 4, 6 };

    SelectionSort.selectionSort(array);

    for (int i = 0; i < array.length; i++) {
      System.out.printf("%d ", array[i]);
    }
  }
}
