package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    //    List<Player> players = new ArrayList<>();
    HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public boolean findByName(String playerName) {
        return players.containsKey(playerName);
    }

    public int round(String playerMame1, String playerName2) {
        if (!findByName(playerMame1)) {
            throw new NotRegisteredException(
                    "Игрок " + playerMame1 + " не зарегистрирован!"
            );
        }
        if (!findByName(playerName2)) {
            throw new NotRegisteredException(
                    "Игрок " + playerName2 + " не зарегистрирован!"
            );
        }

        Player player1 = players.get(playerMame1);
        Player player2 = players.get(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
