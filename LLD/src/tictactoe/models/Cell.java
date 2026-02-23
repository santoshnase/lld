package tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tictactoe.enums.CellState;

@Getter
@AllArgsConstructor
public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.FREE;
    }

    public void updatePlayer(Player player) {
        this.player = player;
        this.cellState = CellState.OCCUPIED;
    }
}
