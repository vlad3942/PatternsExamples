import chain_of_responsability.ChainOfResponsibility;
import chain_of_responsability.EvenWorker;
import chain_of_responsability.OddWorker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static utils.Utility.check;
import static utils.Utility.initFile;

public class Main {
    public static void main(String[] args) {
        //initFile(new double[] {4, 5, 2, 1, 12, 3, 5, 7, 9});
        initFile(new double[] {1, 4, 5, 2, 1, 12, 3, 5, 7, 9});
        try(final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Входной файл: ");
            final String input = br.readLine();
            System.out.println("Выходной файл: ");
            final String output = br.readLine();
            System.out.println("Имя входного файла: " + input);
            System.out.println("Имя выходного файла: " + output);

            final ChainOfResponsibility worker1 = new OddWorker();
            final ChainOfResponsibility worker2 = new EvenWorker();
            worker1.setNext(worker2);

            worker1.doWork(input, output);

            check(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
