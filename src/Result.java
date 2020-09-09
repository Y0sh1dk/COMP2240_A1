import java.util.ArrayList;

public class Result {
    protected ArrayList<Event> eventList;
    protected ArrayList<Job> finishedJobs;
    private int dispTime; // Why? idk
    private String algoName;

    Result(String n, int d, ArrayList<Event> eList, ArrayList<Job> jList) {
        this.algoName = n;
        this.dispTime = d;
        this.eventList = eList;
        this.finishedJobs = jList;

    }

    public void printResult() {
        System.out.println(this.algoName + ":\n");
        for (Event temp : eventList) {
            if (!temp.getName().equals("Dispatcher")) { // if the event was not a dispatcher one
                System.out.println(temp.toString());
            }
        }
    }


}
