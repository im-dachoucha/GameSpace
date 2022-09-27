package GameSpace;

public class Session {
    private String fullName;
    private Station station;
    private int duration;

    public Session(String fullName, Station station, int duration) {
        this.fullName = fullName;
        this.station = station;
        this.duration = duration;
    }
}
