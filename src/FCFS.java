// First Come First Serve
import java.util.logging.*;

public class FCFS extends SchedulingAlgo {
    private static final Logger logger = Logger.getLogger(FCFS.class.getName());

    FCFS(String givenName, int givenDispTime ) {
        super(givenName, givenDispTime);
    }

    @Override
    void run() {
    }

    @Override
    void log(String message) {
        System.out.println(FCFS.class.getName() + ": " + message);
    }


}
