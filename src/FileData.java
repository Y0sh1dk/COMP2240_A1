import java.util.ArrayList;

// Only use is so can return list and a int
public class FileData {
    private int disp;
    private ArrayList<Job> jobs;

    FileData(int d, ArrayList<Job> j) {
        this.disp = d;
        this.jobs = j;
    }

    public int getDisp() {
        return disp;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setDisp(int disp) {
        this.disp = disp;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

}
