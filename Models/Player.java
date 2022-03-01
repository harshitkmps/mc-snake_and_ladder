package Models;

public class Player {
    String name;

    Integer position;

    Integer rank;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Player(String name) {
        this.name = name;
        this.position = 0;
        this.rank = 0;
    }

}
