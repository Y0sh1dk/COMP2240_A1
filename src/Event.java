import java.util.Objects;

public class Event {
    private String name;
    private int duration;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return duration == event.duration &&
                Objects.equals(name, event.name);
    }

}
