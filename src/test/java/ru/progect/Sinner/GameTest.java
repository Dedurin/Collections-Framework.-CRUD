package ru.progect.Sinner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Иван", 10);
    Player player2 = new Player(2, "Лысый", 25);
    Player player3 = new Player(3, "Душнила", 100);
    Player player4 = new Player(4, "Ксения", 75);
    Player player5 = new Player(5, "Виктор", 100);

    Game game = new Game();

    @Test
    public void firstPlayerWon() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Лысый", "Иван");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWon() {
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Иван", "Лысый");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playersWereStrengthEqual() {
        game.register(player3);
        game.register(player5);

        int expected = 0;
        int actual = game.round("Душнила", "Виктор");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Душнила", "Ксения");
        });
    }

    @Test
    public void secondPlayerNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Иван", "Душнила");
        });
    }

    @Test
    public void bothPlayersNotRegistered() {
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Душнила", "Лысый");
        });
    }
}