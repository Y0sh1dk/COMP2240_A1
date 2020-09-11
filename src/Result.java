import java.util.ArrayList;

public class Result {
    protected ArrayList<Event> eventList;
    protected ArrayList<Job> finishedJobs;
    private int dispTime; // Not used currently
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
        System.out.println("\nProcess Turnaround Time Waiting Time");
        finishedJobs.sort(Job.arriveTimeComparitor()); // arrive time should sort by name, surely, dont want to make a name comparitor
        for (Job temp : finishedJobs) {
            System.out.println(temp.getId() + "      " + temp.getTurnaroundTime() + "              " + temp.getWaitingTime());
        }
    }

    public String getAlgoName() {
        return algoName;
    }

    public float getAvgTurnaroundTime() {
        int avg = 0;
        for (Job temp : finishedJobs) {
            avg += temp.getTurnaroundTime();
        }
        return (float)avg/finishedJobs.size();
    }

    public float getAvgWaitingTime() {
        int avg = 0;
        for (Job temp : finishedJobs) {
            avg += temp.getWaitingTime();
        }
        return (float)avg / finishedJobs.size();
    }

}
