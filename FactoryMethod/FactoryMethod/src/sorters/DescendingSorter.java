package sorters;

import java.util.Arrays;

//По убыванию
public class DescendingSorter implements ArraySorter {
    @Override
    public void sortArray(final double[] array) {
        Arrays.sort(array);
        revers(array);
    }
    private void revers(final double[] arr) {
        double tmp;
        for (int i = 0; i < arr.length / 2; i++) {
            tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }
}
