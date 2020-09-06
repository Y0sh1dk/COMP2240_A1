//Priority ROund RObin
public class PRR extends SchedulingAlgo {
    private int timeQuantum;

    PRR(String givenName, int givenDispTime ) {
        super(givenName, givenDispTime);
    }

    @Override
    void run() {

    }

    @Override
    void log(String message) {
        System.out.println(PRR.class.getName() + ": " + message);
    }


}
