import java.util.logging.Logger;

// Shortest process next
public class SPN extends  SchedulingAlgo {



    SPN(String givenName, int givenDispTime ) {
        super(givenName, givenDispTime);
    }

    @Override
    void run() {

    }

    @Override
    void log(String message) {
        System.out.println(SPN.class.getName() + ": " + message);
    }


}
