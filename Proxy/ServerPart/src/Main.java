import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try (final ServerSocket ss = new ServerSocket(8080)) {
            try (final Socket socket = ss.accept()) {
                final ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                final DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                final double[] arr = (double[]) ois.readObject();
                final int result = Calc.calculateAbsUnics(arr); //Calc.calculateUnics(arr);
                dos.writeInt(result);
                dos.flush();
            } catch (ClassNotFoundException e) {
                System.err.println("Возникла ошибка ввода/вывода.");
            }
        } catch (IOException e) {
            System.err.println("Возникла ошибка ввода/вывода.");
        }

    }
}
