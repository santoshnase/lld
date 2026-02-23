package tictactoe.strategy;

import tictactoe.models.Board;

public interface WinningStrategy {
    boolean checkWinner(Board board);
}
