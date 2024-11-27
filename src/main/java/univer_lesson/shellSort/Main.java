package univer_lesson.shellSort;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {33, 45, 62, 12, 98};

        System.out.print("Array before Sorting: ");

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.println();

        int gap;

        for (gap = n / 2; gap > 0; gap = gap / 2) { // calculating the gap by progressively reducing it
            for (int j = gap; j < n; j++) {
                for (int k = j - gap; k >= 0; k -= gap) { // starting from Gap Index (index start from 0)
                    if (arr[k + gap] >= arr[k]) // skipping if the element greater
                        break;
                    else {
                        int temp = arr[k + gap];
                        arr[k + gap] = arr[k];
                        arr[k] = temp;

//                        arr[k + gap] = arr[k + gap] + arr[k];
//                        arr[k] = arr[k + gap] - arr[k];
//                        arr[k + gap] = arr[k + gap] - arr[k];

//                        arr[k + gap] = arr[k + gap] ^ arr[k];
//                        arr[k] = arr[k] ^ arr[k + gap];
//                        arr[k + gap] = arr[k + gap] ^ arr[k];
                    }
                }
            }
        }
        System.out.println("Array after sorting: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}