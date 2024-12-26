package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    Player player1 = new Player(11, "Вася", 10);
    Player player2 = new Player(22, "Петя", 5);
    Player player3 = new Player(11, "Бугай", 100);
    Player player4 = new Player(44, "Силач", 100);

    @Test
    public void testFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        boolean expected = true;
        boolean actual = game.findByName("Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundWinnerFirst() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 1;
        int actual = game.round("Бугай", "Вася");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundWinnerSecond() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 2;
        int actual = game.round("Петя", "Силач");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundWinnerZero() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Бугай", "Силач");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundNoFindPlayerSecond() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Бугай", "Неизвестный");
        });
    }

    @Test
    public void testRoundNoFindPlayerFirst() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Инкогнито", "Петя");
        });
    }
}