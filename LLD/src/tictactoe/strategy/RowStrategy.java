package tictactoe.strategy;

import tictactoe.enums.CellState;
import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.Player;

public class RowStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board) {
        for(int i=0; i<board.getCells().size(); i++) {
            if(board.getCells().get(i).get(0).getCellState().equals(CellState.FREE)) {
                continue;
            }
            Player player = board.getCells().get(i).get(0).getPlayer();
            boolean isWinner = false;
            for(int j=1; j<board.getCells().size(); j++) {
                if(board.getCells().get(i).get(j).getCellState().equals(CellState.OCCUPIED) &&
                        board.getCells().get(i).get(j).getPlayer().getId() == player.getId()) {
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
