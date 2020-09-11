public class Event {
    private String name;
    private int time;
    private int priority;

    Event(String n, int p, int t) {
        this.name = n;
        this.priority = p;
        this.time = t;
    }

    Event(String n, int t) {
        this.name = n;
        this.time = t;
    }

    public int getTime() {
        return this.time;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setTime(int t) {
        this.time = t;
    }

    public void setName(String name) {
        this.name = name;
    }

//    Used for printing the results
    @Override
    public String toString() {
        return "T" + this.getTime() + ": " + this.getName() + "(" + this.getPriority() +")";
    }


}
