package game.board;

public class Board {

    //teste
    public char[][] boardTest;

    public Board() {
        this.boardTest = new char[6][6];
        this.fillBoard();
        this.desenharBoard();
    }

    //teste
    public void fillBoard(){
        for (int y = 0; y < boardTest.length; y++){
            for (int x = 0; x < boardTest.length; x++){
                this.boardTest[y][x] = 'o';
            }
        }
    }

    //teste
    public void desenharBoard(){
        this.boardTest[0][0] = 'c';
        this.boardTest[1][0] = 'c';
        this.boardTest[2][0] = 'c';
        this.boardTest[2][1] = 'c';
        this.boardTest[2][2] = 'c';
        this.boardTest[1][2] = 'c';
        this.boardTest[0][1] = 'c';
        this.boardTest[0][2] = 'c';
    }

}
