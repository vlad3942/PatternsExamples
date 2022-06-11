import java.util.ArrayList;
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
}
