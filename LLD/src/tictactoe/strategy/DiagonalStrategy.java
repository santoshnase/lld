package tictactoe.strategy;

import tictactoe.enums.CellState;
import tictactoe.models.Board;
import tictactoe.models.Player;

public class DiagonalStrategy implements WinningStrategy {
    public boolean checkWinner(Board board) {
        int row = 0;
        int col = 0;
        int boardSize = board.getCells().size();

        boolean topLeftDiagonal = false;
        if(board.getCells().get(row).get(col).getCellState().equals(CellState.OCCUPIED)) {
            Player player = board.getCells().get(row).get(col).getPlayer();
            while(row < boardSize && col < boardSize) {
                if(board.getCells().get(row).get(col).getCellState().equals(CellState.OCCUPIED) &&
                        board.getCells().get(row).get(col).getPlayer().getId() == player.getId()) {
                    topLeftDiagonal = true;
                } else {
                    topLeftDiagonal = false;
                    break;
                }
                row++;
                col++;
            }
        }

        row = 0;
        col = boardSize-1;
        boolean topRightDiagonal = false;
        if(board.getCells().get(row).get(col).getCellState().equals(CellState.OCCUPIED)) {
            Player player = board.getCells().get(row).get(col).getPlayer();
            while(row < boardSize && col >= 0) {
                if(board.getCells().get(row).get(col).getCellState().equals(CellState.OCCUPIED) &&
                        board.getCells().get(row).get(col).getPlayer().getId() == player.getId()) {
                    topRightDiagonal = true;
                } else {
                    topRightDiagonal = false;
                    break;
                }
                row++;
                col--;
            }
        }

        return (topLeftDiagonal || topRightDiagonal);
    }
}
