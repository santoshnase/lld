package tictactoe.models;

import lombok.*;

import java.util.Scanner;


@Getter
public class HumanPlayer extends Player {
    public HumanPlayer(int id, String name, char symbol) {
        super(id, name, symbol);
    }
    @Override
    public void makeMove(Board board) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the row for Player " + this.getId() + ": ");
            int row = scanner.nextInt();
            System.out.println("Enter the column for Player " + this.getId() + ": ");
            int col = scanner.nextInt();
            if(row < 0 || row > board.getCells().size() || col < 0 || col > board.getCells().size()) {
                throw new IllegalArgumentException("Invalid Cell entered");
            }
            board.playMove(this, row, col);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeMove(board);
        }
    }
}
