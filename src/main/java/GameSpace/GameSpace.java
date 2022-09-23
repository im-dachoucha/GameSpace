package GameSpace;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameSpace {
    public void Start() {
        Menu();
    }

    private static void Menu() {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice;
            while (true) {
                System.out.println("1-List all stations");
                System.out.println("2-");
                System.out.println("3-");
                System.out.println("0- quit");
                System.out.print("Your choice: ");
                choice = scanner.nextInt();
                if (choice == 0) break;
                switch (choice) {
                    case 1:
                        ListStations();
                        break;
                    case 2:

                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    private static void ListStations() {
        for (Station station : GameSpaceConstants.STATIONS) {
            System.out.println(station);
        }
    }

    private static class GameSpaceConstants {
        public static ArrayList<Station> STATIONS;
        public static HashMap<String, ArrayList<Station>> GAMES;

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