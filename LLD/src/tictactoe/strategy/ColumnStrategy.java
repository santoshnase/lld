package tictactoe.strategy;

import tictactoe.enums.CellState;
import tictactoe.models.Board;
import tictactoe.models.Player;

public class ColumnStrategy implements WinningStrategy {

    public boolean checkWinner(Board board) {
        for(int i=0; i<board.getCells().size(); i++) {
            if(board.getCells().get(0).get(i).getCellState().equals(CellState.FREE)) {
                continue;
            }
            Player player = board.getCells().get(0).get(i).getPlayer();
            boolean isWinner = false;
            for(int j=1; j<board.getCells().size(); j++) {
                if(board.getCells().get(j).get(i).getCellState().equals(CellState.OCCUPIED) &&
                        board.getCells().get(j).get(i).getPlayer().getId() == player.getId()) {
                    isWinner = true;
                } else {
                    isWinner = false;
                    break;
                }
            }
            if(isWinner) {
                return true;
            }
        }
        return false;
    }
}
