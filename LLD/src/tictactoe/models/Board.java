package tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tictactoe.strategy.ColumnStrategy;
import tictactoe.strategy.DiagonalStrategy;
import tictactoe.strategy.RowStrategy;
import tictactoe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private List<List<Cell>> cells;
    private List<WinningStrategy> winningStrategies;
    private int capacity;

    public void initializeBoard(int boardSize) {
        List<List<Cell>> cells = new ArrayList<>();
        for(int i=0; i<boardSize; i++) {
            List<Cell> rowCells = new ArrayList<>();
            for(int j=0; j<boardSize; j++) {
                Cell cell = new Cell(i, j);
                rowCells.add(cell);
            }
            cells.add(rowCells);
        }
        this.cells = cells;
        this.capacity = boardSize * boardSize;
        this.winningStrategies = new ArrayList<>(List.of(new RowStrategy(), new ColumnStrategy(), new DiagonalStrategy()));
    }

    public void playMove(Player player, int row, int col) {
        Cell playerCell = this.cells.get(row).get(col);
        playerCell.updatePlayer(player);
        this.capacity = this.capacity - 1;
    }

    public boolean gameWon() {
        return this.winningStrategies.stream().anyMatch(winningStrategy -> winningStrategy.checkWinner(this));
    }

    public boolean isBoardFull() {
        return this.capacity <= 0;
    }
}
