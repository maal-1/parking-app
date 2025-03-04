package se.lexicon.dao.sequencer;

public class CustomerIdSequencer {

    private static int customerId = 0;

    private CustomerIdSequencer(){
    }

    public static int nextCustomerId(){
        return ++customerId;
    }

    public static void reset(){
        customerId = 0;
    }

}
