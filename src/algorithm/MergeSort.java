package algorithm;

public class MergeSort {

    private static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, start, mid, temp);
            mergeSort(arr, mid + 1, end, temp);

            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int index = start;

        int[] temp = new int[arr.length];

        while ((i <= mid) && (j <= end)) {
            if (arr[i] < arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }

        while (i <= mid) {
            temp[index] = arr[i];
            index++;
            i++;
        }
        while (j <= end) {
            temp[index] = arr[j];
            index++;
            j++;
        }

        for (int l = start; l <= end; l++) {
            arr[l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
