package GameSpace;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class GameSpace {
    private int todaysTotalRevnue;

    public GameSpace() {
        this.todaysTotalRevnue = 0;
    }

    public void Start() {
        Menu();
    }

    private void Menu() {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice;
            while (true) {
                System.out.println("1-List all stations");
                System.out.println("2-Reserve a station");
//                System.out.println("3-Check availability");
                System.out.println("4-Check availability");
                System.out.println("0- quit");
                System.out.print("Your choice: ");
                choice = scanner.nextInt();
                if (choice == 0) break;
                switch (choice) {
                    case 1 -> ListStations();
                    case 2 -> ReserveStation();
//                    case 3 -> CheckAvailability();
                    case 4 -> PrintTodaysRevenue();
                    default -> System.out.println("Choose a valid command!");
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    private void PrintTodaysRevenue() {
        System.out.println("Revenue for " + LocalDate.now() + " : " + this.todaysTotalRevnue + " dh");
    }

    private void ReserveStation() {
        try {
            Scanner scanner = new Scanner(System.in);
            String game = ChooseGame();
            ListAvailableStations();
            int stationNumber = scanner.nextInt();
            Station station = GameSpaceConstants.STATIONS.get(stationNumber - 1);
            if (!station.isAvailable()) {
                return;
            }
            ListDurations();
            int duration = scanner.nextInt();
            LocalDateTime ldt = LocalDateTime.now();
            System.out.print("Enter full name: ");
            scanner.next();
            String fullName = scanner.nextLine();
            boolean sessionAdded = station.AddSession(fullName, Durations.values()[duration - 1], game);
            if (sessionAdded) {
                this.todaysTotalRevnue += Durations.values()[duration - 1].price;
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

    }

    private String ChooseGame() {
        try {
            Scanner scanner = new Scanner(System.in);
            int i = 0;
            for (Games game : Games.values()) {
                System.out.println(i + 1 + " -> " + game);
                i++;
            }
            int type = scanner.nextInt();
            Games game = Games.values()[type - 1];
            for (i = 0; i < game.getGames().size(); i++) {
                System.out.println(i + 1 + " -> " + game.getGames().get(i));
            }
            int gameNum = scanner.nextInt();
            return game.getGames().get(gameNum - 1);
        } catch (Exception e) {
            System.out.println("Invalid input");
            return "";
        }
    }

//    private void CheckAvailability() {
//        for (Station station : GameSpaceConstants.STATIONS) {
//            for (Session session: getSessionWhereStation(station)) {
//                System.out.println(session);
//            }
//        }
//    }


    private void ListDurations() {
        int i = 0;
//        LocalTime max = LocalTime.of(12, 15);
        LocalTime now = LocalTime.now();
        for (Durations duration : Durations.values()) {
//            if (now.plusMinutes(duration.minutes).compareTo(max) <= 0) {
            System.out.println(i + 1 + " -> " + duration.minutes + " minutes for " + duration.price + " dh");
//            }
            i++;
        }
    }

    private void ListAvailableStations() {
        int i = 1;
        for (Station station : GameSpaceConstants.STATIONS) {
//            if (station.isAvailable())
            System.out.println(i + " -> " + station);
            i++;
        }
    }

    private void ListStations() {
        for (Station station : GameSpaceConstants.STATIONS) {
            System.out.println(station);
        }
    }

    private static class GameSpaceConstants {
        public static ArrayList<Station> STATIONS;
//        public static HashMap<String, ArrayList<Station>> GAMES;

        static {
            STATIONS = new ArrayList<>() {{
                add(new Station("p1", "Dell", "Xbox"));
                add(new Station("p2", "Asus", "Xbox"));
                add(new Station("p3", "Dell", "Xbox"));
                add(new Station("p4", "HP", "Xbox"));
                add(new Station("p5", "Samsung", "PlayStation5"));
                add(new Station("p6", "Samsung", "PlayStation5"));
                add(new Station("p7", "Asus", "PlayStation5"));
                add(new Station("p8", "Dell", "Nintendo switch"));
                add(new Station("p9", "Asus", "Nintendo switch"));
            }};
        }
    }
}

