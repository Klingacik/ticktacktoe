package tictactoe;

public abstract class Player
{
    protected PlayerType playerType;

    public Player(PlayerType playerType) {
        this.playerType = playerType;
    }

    public abstract int[] getNextMove(Board board);
}
