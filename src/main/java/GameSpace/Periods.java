package GameSpace;

import java.time.LocalTime;

public enum Periods {
    MORNING_START(LocalTime.of(9, 0)),
    MORNING_END(LocalTime.of(12, 0)),
    EVENING_START(LocalTime.of(14, 0)),
    EVENING_END(LocalTime.of(20, 0));

    private final LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    Periods(LocalTime time){
        this.time = time;
    }
}
