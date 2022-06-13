import singleton.ArrayGenerator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final ArrayGenerator arrayGenerator1 = ArrayGenerator.getInstance();
        final double[] arr1 = arrayGenerator1.getRandomArray(10);
        System.out.println(Arrays.toString(arr1));

        final ArrayGenerator arrayGenerator2 = ArrayGenerator.getInstance();
        final double[] arr2 = arrayGenerator2.getRandomArray(20);
        System.out.println(Arrays.toString(arr2));

        if (arrayGenerator1 == arrayGenerator2) {
            System.out.println("Singleton is work!");
        } else {
            System.err.println("Something is wrong...");
        }

    }
}
