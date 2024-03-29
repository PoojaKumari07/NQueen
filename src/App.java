import board.Board;
import game.Game;

public class App {
    public static void main(String[] args) throws Exception {

        Board qb = new Board(3);
        Game game = new Game(qb);
        game.play();

    }
}
