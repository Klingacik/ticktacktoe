package tictactoe;

public class EasyComputer extends Computer{

    protected EasyComputer(boolean playingAsX) {
        super(playingAsX);
    }

    public int[] getNextMove(Board board) {
        System.out.println("Making move level \"easy\"");
        super.board = board;
        return super.getNextRandomMove();
    }
}
