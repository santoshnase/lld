package tictactoe.models;

import lombok.Getter;


@Getter

public abstract class Player {
    private final int id;
    private final String name;
    private final char symbol;

    public Player(int id, String name, char symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public abstract void makeMove(Board board);
}
