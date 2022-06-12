import command.Command;
import command.ToBeginCommand;
import command.ToEndCommand;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        initFile(new double[] {1, 4, 5, 0, 1, 12, 0, 5, 7, 0, 9});
        try(final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Входной файл: ");
            final String input = br.readLine();
            System.out.println("Выходной файл: ");
            final String output = br.readLine();
            System.out.println("Имя входного файла: " + input);
            System.out.println("Имя выходного файла: " + output);

            final Command command1 = new ToEndCommand();
            final Command command2 = new ToBeginCommand();

            System.out.println("ToEndCommand: ");
            command1.doMove(input, output);
            check(output);

            System.out.println("ToBeginCommand: ");
            command2.doMove(input, output);
            check(output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void check(final String outputFileName) {
        try (final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(outputFileName))) {
            final double[] resArr = (double[]) ois.readObject();
            System.out.println(Arrays.toString(resArr));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void initFile(final double[] arr) {
        try(final FileWriter dos = new FileWriter("input.txt")) {
            dos.write(arr.length + "\n");
            for (double v : arr) {
                dos.write(v  + "\n");
            }
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
