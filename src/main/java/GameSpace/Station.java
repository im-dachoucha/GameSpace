package GameSpace;

public class Station {

    private String name;
    private final String screen, console;
    private boolean isAvailable;

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
    }

    @Override
    public String toString() {
        return "name -> " + name +
                ", screen -> " + screen +
                ", console -> " + console + ", " +
                (isAvailable ? "Available" : "Not available");
    }
}
