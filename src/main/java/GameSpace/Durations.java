package GameSpace;

public enum Durations {
    HALF_HOUR(5, 30),
    ONE_HOUR(10, 60),
    TWO_HOURS(18, 120),
    FIVE_HOURS(40, 300),
    ALL_DAY(65, 540);

    final int price;
    final int minutes;
    Durations(int price, int minutes){
        this.price = price;
        this.minutes = minutes;
    }
}
