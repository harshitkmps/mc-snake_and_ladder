package Models;

import java.util.Map;

import Enums.MoveStatus;

public class Board {
    Integer startPosition;

    Integer endPosition;

    Map<Integer, Integer> snakes;

    Map<Integer, Integer> ladders;

    public Board(Integer startPosition, Integer endPosition, Map<Integer, Integer> snakes,
            Map<Integer, Integer> ladders) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public Board() {
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Integer endPosition) {
        this.endPosition = endPosition;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Integer> snakes) {
        this.snakes = snakes;
    }

    public Map<Integer, Integer> getLadder() {
        return ladders;
    }

    public void setLadder(Map<Integer, Integer> ladders) {
        this.ladders = ladders;
    }
    
    public MoveStatus moveCheck(Integer newPosition) {
        if (newPosition < endPosition) {
            return MoveStatus.ALLOWED;
        } else if (newPosition == endPosition) {
            return MoveStatus.PLAYER_WON;
        } else {
            return MoveStatus.NOT_ALLOWED;
        }
    }

    public Integer makeMoveAndGetFinalPosition(Integer position) {
        while (snakes.containsKey(position) || ladders.containsKey(position)) {
            if (snakes.containsKey(position)) {
                System.out.println("snakes gets one from " + position + " to " + snakes.get(position));
                position = snakes.get(position);
            }
            if (ladders.containsKey(position)) {
                System.out.println("ladder promotes one from " + position + " to " + ladders.get(position));
                position = ladders.get(position);
            }
        }
        return position;
    }
}
