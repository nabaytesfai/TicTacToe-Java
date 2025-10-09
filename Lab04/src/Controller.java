


public class Controller {

    private RuleEngine game;
    private View view;

    public Controller(RuleEngine game, View view){
        this.game = game;
        this.view = view;
     }

     
    public void setView(View view) {
        this.view = view;
    }

    public void handleMove(int row, int col){
        
        boolean moveMade = game.makeMove(row, col);
        
        if (!moveMade) {
             view.setStatus("Invalid move! Try again.");
             return;
            }

        view.updateBoard(game.getBoard());

        if (game.isGameOver()) {
        if (game.checkWin(game.winner)) {
            view.setStatus("Player " + game.winner.getSymbol() + " wins!");
        } else {
            view.setStatus("Draw!");
        }
        view.disableBoard();
    } else {
        Player next = game.getCurrentPlayer();
        view.setStatus("Player " + next.getSymbol() + "'s turn");
    }
    } 

    public Player getWinner() {
    Player opponent = game.getCurrentPlayer().getNext();
    if (game.checkWin(opponent)) {
        return opponent;
    }
    return null;
}

    public void resetGame(){
        game.resetGame();
        view.enableBoard();
    }
}