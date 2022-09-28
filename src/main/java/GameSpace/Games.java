package GameSpace;

import java.util.ArrayList;

public enum Games {
    WAR(new ArrayList<String>(){{
        add("Counter-Strike");
        add("Assassin's Creed");
    }}),
    FOOTBALL(new ArrayList<String>(){{
        add("Fifa");
        add("PES");
    }});
    private final ArrayList<String> games;

    public ArrayList<String> getGames(){
        return this.games;
    }
    Games(ArrayList<String> games){
        this.games = games;
    }
}
