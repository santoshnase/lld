import tictactoe.models.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.initializeGame();
        game.startGame();
    }
}