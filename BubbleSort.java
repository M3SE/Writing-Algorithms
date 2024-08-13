public class BubbleSort {
    public static void bubblesort(int[] arr, int N) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[] arr = {4, 1, 3, 9, 7};
        bubblesort(arr, N);
        System.out.print("Sorted array: ");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        N = 10;
        int[] arr2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubblesort(arr2, N);
        System.out.print("Sorted array: ");
        for (int i = 0; i < N; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
