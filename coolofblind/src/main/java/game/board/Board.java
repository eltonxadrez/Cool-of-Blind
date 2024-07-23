package game.board;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Board {

    private Map<Node, List<Node>> nodes = new HashMap<>();

    private Node firstNode;

    public void addNode(Node node, List<Node> adjNodes, boolean isFirst) {
        this.nodes.put(node, adjNodes);
        if(isFirst) {
            this.firstNode = node;
        }
    }

    public List<Node> findAdjNodes(Node node){
        return this.nodes.get(node);
    }




    //teste
    private char[][] boardTest;

    public Board() {
        this.boardTest = new char[20][20];
        this.fillBoard();
        this.desenharBoard();
    }

    //teste
    public void fillBoard(){
        for (int x = 0; x < boardTest.length; x++){
            for (int y = 0; y < boardTest.length; y++){
                this.boardTest[x][y] = 'o';
            }
        }
    }

    //teste
    public void desenharBoard(){
        //x - Y
        this.boardTest[0][0] = 'c';
        this.boardTest[0][1] = 'c';
//        this.boardTest[0][2] = 'c';
        this.boardTest[1][0] = 'c';
//        this.boardTest[2][0] = 'c';
//        this.boardTest[2][1] = 'c';
//        this.boardTest[2][2] = 'c';
//        this.boardTest[1][2] = 'c';
        this.boardTest[1][1] = 'c';
    }

}
