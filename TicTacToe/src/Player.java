
public enum Player {
    PLAYER_X('X'),
    PLAYER_O('O'),
    PLAYER_Z('Z');


    
    private char symbol;

    Player(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
    return symbol;
    }
    
     public Player getNext() {
        Player[] players = Player.values();
        int nextIndex = (this.ordinal() + 1) % players.length;
        return players[nextIndex];
    }
}
