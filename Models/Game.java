package Models;

import java.util.List;
import java.util.Random;

public class Game {
    Board board;

    List<Player> currentPlayers;

    List<Player> players;

    Integer currentRank;

    Integer currentPlayerIndex;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getCurrentPlayers() {
        return currentPlayers;
    }

    public void setCurrentPlayers(List<Player> currentPlayers) {
        this.currentPlayers = currentPlayers;
    }

    public Integer getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(Integer currentRank) {
        this.currentRank = currentRank;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.currentPlayers = players;
        this.players = players;
        this.currentPlayerIndex = 0;
        this.currentRank = 1;
    }

    public Player getNextPlayer() {
        if (currentPlayerIndex >= currentPlayers.size()) {
            currentPlayerIndex = 0;
        }
        Player currentPlayer = currentPlayers.get(currentPlayerIndex);
        currentPlayerIndex++;
        if (currentPlayerIndex == currentPlayers.size()) {
            currentPlayerIndex = 0;
        }
        return currentPlayer;
    }

    public void playerWon(Player player) {
        player.setPosition(board.getEndPosition());
        player.setRank(currentRank);
        currentRank++;
        currentPlayers.remove(player);
        return;
    }

    public Boolean isGameAlive() {
        return currentPlayers.size() > 1;
    }

    public Integer rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
