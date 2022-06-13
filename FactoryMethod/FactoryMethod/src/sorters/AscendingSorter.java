package sorters;

import java.util.Arrays;

//По возрастанию
public class AscendingSorter implements ArraySorter {

    @Override
    public void sortArray(double[] array) {
        Arrays.sort(array);
    }
}
