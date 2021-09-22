package tictactoe;

public class EasyComputer extends Computer{

    protected EasyComputer() {
        super(true, PlayerType.COMPUTER_EASY);
    }

    @Override
    public int[] getNextPosition(Board board)
    {
        return new int[0];
    }

}
