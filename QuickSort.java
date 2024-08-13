public class QuickSort {
    // partition the array using the last element as pivot
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // implement QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is the partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[] arr = {4, 1, 3, 9, 7};
        quickSort(arr, 0, N - 1);
        System.out.print("Sorted array: ");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        N = 9;
        int[] arr2 = {2, 1, 6, 10, 4, 1, 3, 9, 7};
        quickSort(arr2, 0, N - 1);
        System.out.print("Sorted array: ");
        for (int i = 0; i < N; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
