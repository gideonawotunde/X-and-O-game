package boardgame.model;

public class PlayerData {

    private final String name;
    private Integer numberOfTurns;
    private Square symbol;

    public PlayerData (String name, Integer numberOfTurns, Square symbol) {
        this.name = name;
        this.numberOfTurns = numberOfTurns;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }
    public Integer getNumberOfTurns(){
        return numberOfTurns;
    }
    public void setNumberOfTurns(Integer numberOfTurns){
        this.numberOfTurns = numberOfTurns;
    }

    public Square getSymbol() {
        return symbol;
    }
}
