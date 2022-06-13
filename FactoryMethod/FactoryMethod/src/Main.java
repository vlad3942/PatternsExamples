import factories.AscendingCreator;
import factories.DescendingCreator;
import factories.SorterFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final double[] array = new double[] {4, 1, 5, 7, 9, 7, 23, 15, 32, 44, 37, 41, 63, 12, 45, 1};

        final SorterFactory creator1 = new AscendingCreator();
        final double[] res1 = Arrays.copyOf(array, array.length);
        creator1.createSorter().sortArray(res1);
        System.out.println(Arrays.toString(res1));

        final SorterFactory creator2 = new DescendingCreator();
        final double[] res2 = Arrays.copyOf(array, array.length);
        creator2.createSorter().sortArray(res2);
        System.out.println(Arrays.toString(res2));
    }
}
