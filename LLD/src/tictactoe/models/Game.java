package tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import tictactoe.enums.GameState;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@AllArgsConstructor
@Builder
public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private int currentPlayerIndex;
    private Player winner;
    private Scanner scanner;

    public Game() {
        this.gameState = GameState.NEW;
        this.scanner = new Scanner(System.in);
    }

    public void initializeGame() {
        System.out.println("***** Welcome to Tic-Tac-Toe *****");
        Board board = processBoard();
        List<Player> players = processPlayer();
        this.board = board;
        this.players = players;
        this.gameState = GameState.NEW;
        this.currentPlayerIndex = 0;
    }

    public void startGame() {
        System.out.println("Game Started...");
        this.gameState = GameState.IN_PROGRESS;
        while(this.gameState.equals(GameState.IN_PROGRESS)) {
            //Display Board
            displayBoard();
            if(this.board.isBoardFull()) {
                this.gameState = GameState.DRAW;
                System.out.println("Game Draw...");
                return;
            }
            // Find next player
            Player player = this.players.get(this.currentPlayerIndex);
            // Make move for the player
            player.makeMove(this.board);
            // Check win
            boolean isWin = this.board.gameWon();
            // Update player
            if(isWin) {
                displayBoard();
                this.gameState = GameState.COMPLETED;
                this.winner = player;
                System.out.println("***** Winner is " + player.getName() + " *****");
            } else {
                this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.players.size();
            }
        }
    }

    private Board processBoard() {
        System.out.println("Enter the size of the board: ");
        int boardSize = this.scanner.nextInt();
        Board board = new Board();
        board.initializeBoard(boardSize);
        return board;
    }

    private List<Player> processPlayer() {
        System.out.println("Enter the number of players: ");
        int playersCount = this.scanner.nextInt();
        List<Player> players = new ArrayList<>();
        for(int i=0; i<playersCount; i++) {
            System.out.println("Enter Player " + (i+1) + " name: ");
            String playerName = this.scanner.next();
            System.out.println("Enter Symbol: ");
            char symbol = this.scanner.next().charAt(0);

            Player player = new HumanPlayer(i, playerName, symbol);
            players.add(player);
        }
        return players;
    }

    private void displayBoard() {
        for(int i=0; i<this.board.getCells().size(); i++) {
            for(int j=0; j<this.board.getCells().size(); j++) {
                if(null != this.board.getCells().get(i).get(j).getPlayer()) {
                    System.out.printf("| %s ", this.board.getCells().get(i).get(j).getPlayer().getSymbol());
                } else {
                    System.out.print("|   ");
                }

            }
            System.out.println("|");
        }
    }
}
