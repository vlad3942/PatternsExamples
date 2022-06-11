package chain_of_responsability;

public interface ChainOfResponsibility {
    void doWork(String input, String output);
    void setNext(ChainOfResponsibility next);
}
