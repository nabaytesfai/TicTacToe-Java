
public class RuleEngine {

    private Board board;      
    private Player currentPlayer;
    private boolean gameOver;
    public Player winner;

    public RuleEngine(int boardSize) {
    this.board = new Board(boardSize);
    this.currentPlayer = Player.values()[0]; 
    this.gameOver = false;
    }

    public Board getBoard(){
        return board;
    }

    public int getBoardSize(){
        return board.getSize();
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public void switchPlayer(){
        currentPlayer = currentPlayer.getNext();
    }
    
    public boolean makeMove(int row, int col){

        if(!(board.getIndex(row, col) == '\0'))
            return false;
        
        if(board.isFull())
            return false;

        board.setIndex(row, col, currentPlayer.getSymbol());

        if (checkWin(currentPlayer)) {
            gameOver = true;
            winner= currentPlayer; 
        } else if (board.isFull()) {
            gameOver = true;
        }
        switchPlayer();
        return true;
    }

    public boolean checkWin(Player player){
       
        char[][] size = board.getBoard();

        for (char[] row : size) { 
        boolean rowWin = true;
        for (char r : row) {  
            if (r != player.getSymbol()) {
                rowWin = false;
                break;
            }
        }
        if (rowWin) return true;
    }

        for (int col = 0; col < size.length; col++) {
        boolean colWin = true;
        for (char[] row : size) {
            if (row[col] != player.getSymbol()) {
                colWin = false;
                break;
            }
        }
        if (colWin) return true;
    }

        boolean diagwin = true;
        for(int i= 0; i< size.length; i++){
            if(size[i][i] != player.getSymbol()){ 
            diagwin = false;
            break;
            }
        }  
            if (diagwin) return true;
      

        boolean DiagWin2 = true;
    for (int i = 0; i < size.length; i++) {
        if (size[i][size.length - 1 - i] != player.getSymbol()) {
            DiagWin2 = false;
            break;
        }
    }
    if (DiagWin2) return true;

    return false;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public void resetGame(){
        board.resetBoard();
        currentPlayer = Player.values()[0];
        gameOver = false;
    }
}
