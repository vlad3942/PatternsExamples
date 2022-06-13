package singleton;

import java.util.Random;

public class ArrayGenerator {

    private final Random random = new Random();

    private static ArrayGenerator INSTANCE;

    private ArrayGenerator() {}

    public static ArrayGenerator getInstance() {
        if (INSTANCE == null) {
            synchronized (ArrayGenerator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ArrayGenerator();
                }
            }
        }
        return INSTANCE;
    }

    public double[] getRandomArray(final int length) {
        final double[] res = new double[length];
        for (int i = 0; i < length; i++) {
            res[i] = random.nextDouble();
        }
        return res;
    }
}
