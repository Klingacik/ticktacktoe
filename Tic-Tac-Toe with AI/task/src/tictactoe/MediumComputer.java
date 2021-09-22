package tictactoe;

public class MediumComputer extends Computer{
    public MediumComputer(boolean playingAsX) {
        super(playingAsX, PlayerType.COMPUTER_MEDIUM);
    }

    @Override
    public int[] getNextPosition(Board board)
    {
        return playingAsX ?
               getNextGoodMove("X", board) :
               getNextGoodMove("O", board);
    }

    private int[] getNextGoodMove(String lookingFor, Board board) {
        int[] position = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (board.compareTwoPositions(lookingFor, i, j, i, j - 1) &&
                        board.isPositionEmpty(i, j + 1 > 2 ? 0 : j + 1)) {
                    position[0] = i;
                    position[1] = j == 2 ? 0 : j + 1;
                    return position;
                }

                if (board.compareTwoPositions(lookingFor, j, i, j - 1, i) &&
                        board.isPositionEmpty(j + 1 > 2 ? 0 : j + 1, i)) {
                    position[1] = i;
                    position[0] = j == 2 ? 0 : j + 1;
                    return position;
                }
            }
        }

        if (board.compareTwoPositions(lookingFor, 0, 0, 1, 1) && board.isPositionEmpty(2, 2)) {
            position[0] = 2;
            position[1] = 2;
            return position;
        }

        if (board.compareTwoPositions(lookingFor, 0, 0, 2, 2) && board.isPositionEmpty(1, 1)) {
            position[0] = 1;
            position[1] = 1;
            return position;
        }

        if (board.compareTwoPositions(lookingFor, 1, 1, 2, 2) && board.isPositionEmpty(0, 0)) {
            position[0] = 0;
            position[1] = 0;
            return position;
        }

        if (board.compareTwoPositions(lookingFor, 1, 1, 0, 2) && board.isPositionEmpty(2, 0)) {
            position[0] = 2;
            position[1] = 0;
            return position;
        }

        if (board.compareTwoPositions(lookingFor, 1, 1, 2, 0) && board.isPositionEmpty(0, 2)) {
            position[0] = 0;
            position[1] = 2;
            return position;
        }

        if (board.compareTwoPositions(lookingFor, 0, 2, 2, 0) && board.isPositionEmpty(1, 1)) {
            position[0] = 1;
            position[1] = 1;
            return position;
        }

        return new int[0];
    }
}
