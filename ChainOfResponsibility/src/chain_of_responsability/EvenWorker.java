package chain_of_responsability;

import java.util.ArrayList;
import java.util.List;

import static utils.Utility.readArray;
import static utils.Utility.writeList;

//Чётные
public class EvenWorker implements ChainOfResponsibility {


    @Override
    public void doWork(String input, String output) {
        final double[] inputArr = readArray(input);
        if (inputArr.length <= 0) {
            return;
        }
        if (inputArr[0] % 2 == 0) {
            final List<Double> res = new ArrayList<>();
            for(int i = 1; i < inputArr.length; i++) {
                if (inputArr[i] % 2 != 0) {
                    res.add(inputArr[i]);
                }
            }
            writeList(output, res);
        } else {
            throw new IllegalStateException("Chain was finished");
        }
    }

    @Override
    public void setNext(final ChainOfResponsibility next) {
        throw new IllegalStateException("Not implemented");
    }
}
