package C02_Encapsulation.Exercise.P05_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean containsPlayer = false;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                players.remove(player);
                containsPlayer = true;
                break;
            }
        }
        if (!containsPlayer) {
            throw new IllegalArgumentException
                    (String.format("Player %s is not in %s team.", name, this.name));
        }
    }
    public double getRating(){
        return Math.round(this.players.stream().mapToDouble(Player::overallSkillLevel).sum());
    }

}
