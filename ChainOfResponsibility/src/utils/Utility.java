package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Utility {

    public static void initFile(final double[] arr) {
        try(final DataOutputStream dos = new DataOutputStream(new FileOutputStream("input.txt"))) {
            dos.writeInt(arr.length);
            for (double v : arr) {
                dos.writeDouble(v);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[] readArray(final String inputFileName) {
        if (inputFileName == null || inputFileName.isEmpty()) {
            throw new IllegalArgumentException("Input file name error");
        }
        if (!Files.exists(Path.of(inputFileName))) {
            throw new IllegalArgumentException("File " + inputFileName + " is not exist");
        }
        try (final DataInputStream dis = new DataInputStream(new FileInputStream(inputFileName))) {
            final int arrLength = dis.readInt();
            final double[] inputArr = new double[arrLength];
            for (int i = 0; i < arrLength; i++) {
                inputArr[i] = dis.readDouble();
            }
            return inputArr;
        } catch (IOException e) {
            throw new IllegalStateException("Some error reading input file with name: " + inputFileName);
        }
    }

    public static void writeList(final String outputFileName, final List<Double> list) {
        if (outputFileName == null || outputFileName.isEmpty()) {
            throw new IllegalArgumentException("Output file name error");
        }
        try (final DataOutputStream dos = new DataOutputStream(new FileOutputStream(outputFileName))) {
            dos.writeInt(list.size());
            for (Double v : list) {
                dos.writeDouble(v);
            }
            dos.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Some error reading input file with name: " + outputFileName);
        }
    }

    public static void check(final String fileName) {
        final double[] arr = readArray(fileName);
        System.out.println(Arrays.toString(arr));
    }
}
