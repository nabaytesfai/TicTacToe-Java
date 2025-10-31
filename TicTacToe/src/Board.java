public class Board {

    private char[][] board;   
    private int size;         

    public Board(int size){
        this.size = size;
        board = new char[size][size];
        resetBoard();
    }


    public int getSize(){
        return size;
    }

    public char getIndex(int row, int col){
        if (row < 0 || row >= size || col < 0 || col >= size)
        throw new IllegalArgumentException("Invalid board position");
        return board[row][col];
    }

    public void resetBoard(){
        for(int r=0; r < size; r++){
            for(int c=0; c < size; c++)
            board[r][c] = '\0';
        }
    }

    public boolean isIndexEmpty(int row, int col){
        if(board[row][col] == '\0'){
            return true;
        }else{
                return false;
        }
    }


    public void setIndex(int row, int col, char symbol){
    
        if(isIndexEmpty(row, col) == true){
            board[row][col] = symbol;
        }
    }
    
    public boolean isFull(){        
        for(int r=0; r < size; r++){
            for(int c=0; c < size; c++)
            if(board[r][c] == '\0'){
                return false;
            }
        }
    return true;
    }

    public char[][] getBoard(){
        return board;
    }
}
