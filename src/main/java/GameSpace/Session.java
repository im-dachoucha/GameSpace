package GameSpace;

import java.time.LocalDate;
import java.time.LocalTime;

public class Session {
    private String fullName;
    private Station station;
    private String game;
    private int duration, price;

    private LocalDate date;
    private LocalTime startingTime;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public String getGame() {return game;}

    public Session(String fullName, Station station, int duration, int price, LocalDate date, LocalTime startingTime, String game) {
        this.fullName = fullName;
        this.station = station;
        this.duration = duration;
        this.price = price;
        this.date = date;
        this.startingTime = startingTime;
        this.game = game;
    }

    @Override
    public String toString() {
        return "Session{" +
                "fullName='" + fullName + '\'' +
                ", station=" + station +
                ", game=" + game +
                ", duration=" + duration +
                ", date=" + date +
                ", startingTime=" + startingTime +
                '}';
    }
}
