import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Enums.MoveStatus;
import Models.Board;
import Models.Game;
import Models.Player;

public class Main {
    public static void main(String[] args) {
        Integer startPosition = 1;
        Integer endPosition = 100;
        Map<Integer, Integer> snakes = new HashMap<>();
        Map<Integer, Integer> ladders = new HashMap<>();

        snakes.put(99, 10);
        snakes.put(91, 82);
        snakes.put(78, 26);

        ladders.put(10, 26);
        ladders.put(13, 77);

        Board board = new Board(startPosition, endPosition, snakes, ladders);

        List<String> playerNames = Arrays.asList("Alpha", "Beta", "Gamma");
        List<Player> players = new ArrayList<>();

        for (String playerName : playerNames) {
            Player player = new Player(playerName);
            players.add(player);
        }

        Game game = new Game(board, players);
        while (game.isGameAlive()) {
            Player player = game.getNextPlayer();
            Integer move = game.rollDice();
            Integer currentPosition = player.getPosition();
            Integer finalPosition = board.makeMoveAndGetFinalPosition(currentPosition + move);

            MoveStatus moveStatus = board.moveCheck(finalPosition);
            switch (moveStatus) {
                case ALLOWED:
                    player.setPosition(finalPosition);
                    System.out.println(player.getName() + " moves from " + currentPosition + " to "
                            + finalPosition);
                    break;
                case NOT_ALLOWED:
                    System.out.println(player.getName() + " move is not allowed from " + currentPosition + " to "
                            + finalPosition);
                    break;
                case PLAYER_WON:
                    game.playerWon(player);
                    System.out.println(player.getName() + " moves from " + currentPosition + " to "
                            + finalPosition + " and wins the game with rank : " + player.getRank());
                    break;
            }
        }
        Player player = game.getNextPlayer();
        System.out.println("Game ends beautifully!! "  + player.getName() + " loses the game");
    }
}

