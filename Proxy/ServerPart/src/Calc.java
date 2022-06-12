import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {

    public static int calculateUnics(final double[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        final List<Double> unics = new ArrayList<>();
        int unicsCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!unics.contains(arr[i])) {
                unics.add(arr[i]);
                unicsCount++;
            }
        }
        return unicsCount;
    }

    public static int calculateAbsUnics(final double[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        Arrays.sort(arr);
        int unicsCount = 0;
        double tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != tmp || i == 0) {
                if (arr[i] != arr[i + 1]) {
                    unicsCount++;
                } else {
                    tmp = arr[i];
                }
            }
        }
        return unicsCount;
    }
}
