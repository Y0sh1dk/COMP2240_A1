
public class Event {
    private String name;
    private int duration;


    Event(String n, int d) {
        this.name = n;
        this.duration = d;
    }

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }


}
