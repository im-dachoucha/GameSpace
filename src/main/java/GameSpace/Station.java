package GameSpace;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Station {

    private final String name;
    private final String screen, console;
    private boolean isAvailable;
    private final ArrayList<Session> sessions;

    public String getScreen() {
        return screen;
    }

    public String getConsole() {
        return console;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Station(String name, String screen, String console) {
        this.name = name;
        this.screen = screen;
        this.console = console;
        this.isAvailable = true;
        sessions = new ArrayList<>();
    }

    public boolean AddSession(String fullName, Durations duration, String game) {
        LocalDateTime now = LocalDateTime.now();
        if (now.toLocalTime().compareTo(Periods.MORNING_START.getTime()) < 0 ||
                (now.toLocalTime().compareTo(Periods.MORNING_END.getTime()) > 0
                        &&
                        now.toLocalTime().compareTo(Periods.EVENING_START.getTime()) < 0) ||
                now.toLocalTime().compareTo(Periods.EVENING_END.getTime()) > 0
        ) {
            System.out.println("Can't fit a session");
            return false;
        }
        if (this.sessions.isEmpty()) {
            if(now.toLocalTime().compareTo(Periods.MORNING_END.getTime()) < 0 && now.toLocalTime().plusMinutes(duration.minutes).compareTo(Periods.EVENING_START.getTime()) > 0){
                System.out.println("Can't fit a session");
                return false;
            }
//            if(now.toLocalTime().compareTo(Periods.MORNING_START.getTime()) < 0 && now.toLocalTime().plusMinutes(duration.minutes).compareTo(Periods.MORNING_END.getTime()) > 0 ||
//                    now.toLocalTime().compareTo(Periods.EVENING_START.getTime()) < 0 && now.toLocalTime().plusMinutes(duration.minutes).compareTo(Periods.EVENING_END.getTime()) > 0
//            ){
//                System.out.println("Can't fit a session");
//                return false;
//            }
            this.sessions.add(new Session(fullName, this, duration.minutes, duration.price, now.toLocalDate(), now.toLocalTime(), game));
            return true;
        }
        Session lastSession = this.sessions.get(this.sessions.size() - 1);
        LocalTime lastSessionStartingTime = lastSession.getStartingTime().plusMinutes(lastSession.getDuration());

        if (lastSessionStartingTime.compareTo(Periods.MORNING_START.getTime()) > 0) {
            if(lastSessionStartingTime.compareTo(Periods.MORNING_END.getTime()) < 0 && lastSessionStartingTime.plusMinutes(duration.minutes).compareTo(Periods.EVENING_START.getTime()) > 0){
                System.out.println("Can't fit a session");
                return false;
            }
            this.sessions.add(new Session(fullName, this, duration.minutes, duration.price, now.toLocalDate(), lastSessionStartingTime, game));
            return true;
        }
        if (lastSessionStartingTime.plusMinutes(duration.minutes).compareTo(Periods.EVENING_START.getTime()) > 0 &&
                lastSessionStartingTime.plusMinutes(duration.minutes).compareTo(Periods.EVENING_END.getTime()) < 0) {
            this.sessions.add(new Session(fullName, this, duration.minutes, duration.price, now.toLocalDate(), lastSessionStartingTime, game));
            return true;
        }
        System.out.println("Can't fit a session");
        return false;
    }

    @Override
    public String toString() {
        String out = "";
        if (!this.sessions.isEmpty()) {
            int i = 1;
            for (Session session : this.sessions) {
                out += "\n  [Session " + i +
                        session.getFullName() + " " +
                        " played : " +
                        session.getGame() + " " +
                        " ends at : " +
                        session.getStartingTime().truncatedTo(ChronoUnit.MINUTES) + " " +
                        " ends at : " +
                        session.getStartingTime().plusMinutes(session.getDuration()).truncatedTo(ChronoUnit.MINUTES) +
                        " (" +
                        session.getDuration() +
                        " min)]";
                i++;
            }
        }
        return "name -> " + name +
                ", screen -> " + screen +
                ", console -> " + console +
                out;
    }
}
