package command;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ToBeginCommand implements Command {
    @Override
    public void doMove(String inputFileName, String outputFileName) {
        if (!Files.exists(Path.of(inputFileName))) {
            throw new IllegalArgumentException("Input File not found error.");
        }
        try (
                final BufferedReader br = new BufferedReader(new FileReader(inputFileName));
                final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFileName))
        ) {
            String tmp = br.readLine();
            final int elements = Integer.parseInt(tmp);
            final double[] arr = new double[elements];
            for (int i = 0; i < elements; i++) {
                tmp = br.readLine();
                arr[i] = Double.parseDouble(tmp);
            }
            final double[] result = moveToBegin(arr);
            oos.writeObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double[] moveToBegin(final double[] arr) {
        final int size = arr.length;
        final List<Double> first = new ArrayList<>();
        final List<Double> second = new ArrayList<>();
        for (double v : arr) {
            if (v != 0) {
                second.add(v);
            } else {
                first.add(v);
            }
        }
        first.addAll(second);
        final double[] res = new double[size];
        for (int i = 0; i < size; i++) {
            res[i] = first.get(i);
        }
        return res;
    }
}
