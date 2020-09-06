//Preemptive Priority
public class PP extends SchedulingAlgo {
    PP(String givenName, int givenDispTime ) {
        super(givenName, givenDispTime);
    }

    @Override
    void run() {

    }

    @Override
    void log(String message) {
        System.out.println(PP.class.getName() + ": " + message);
    }


}
