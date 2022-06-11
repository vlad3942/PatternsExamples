import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Array length is not set");
        }
        final int length = Integer.parseInt(args[0]);
        final Random r = new Random();
        final double[] arr = new double[length];
        for (int i = 0; i < length; i++) {
            //arr[i] = r.nextDouble(); //Нужно вроде так, но для проверки взял Int
            arr[i] = r.nextInt(10);
        }

        System.out.println("Сгенерированный массив: ");
        System.out.println(Arrays.toString(arr));

        try (final Socket client = new Socket("localhost", 8080)) {
            final InputStream socketInputStream = client.getInputStream();
            final OutputStream socketOutputStream = client.getOutputStream();
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(socketOutputStream);
            objectOutputStream.writeObject(arr);

            final int result = new DataInputStream(socketInputStream).readInt();
            System.out.println("Число не повторяющихся элементов = " + result);

        } catch (IOException e) {
            System.err.println("Возникла ошибка ввода/вывода.");
        }
    }
}
