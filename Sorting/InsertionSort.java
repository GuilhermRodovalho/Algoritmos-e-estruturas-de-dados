/**
 * Implementation of the inplace sorting algorithm, InsertionSort This algorithm
 * runs in a O(n^2) time, and O(1) space
 * 
 * @author Guilherme R. Rodovalho
 */

class InsertionSort {

    public static void insertionsort(int[] array) {
        if (array == null)
            return;

        for (int i = 1; i < array.length; i++) {
            int cvalue = array[i];

            int j = i - 1;
            while (j >= 0 && cvalue < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = cvalue;
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr = { 6, 4, 3, 2, 18, 1, 5, 67, 12, 32 };

        InsertionSort.insertionsort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
