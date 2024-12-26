package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

//    public List<Player> findAll() {
//        return players;
//    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerMame1, String playerName2) {
        if (findByName(playerMame1) == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerMame1 + " не зарегистрирован!"
            );
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerName2 + " не зарегистрирован!"
            );
        }

        Player player1 = findByName(playerMame1);
        Player player2 = findByName(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
